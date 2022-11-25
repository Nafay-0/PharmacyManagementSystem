package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.Pharmacy;
import com.Pharmacy.Project.LogicComponent.Sale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReturnsController implements Initializable {

    int SaleId;
    int RefundAmount;
    Sale currentSale;
    Pharmacy pharmacy;

    @FXML
    private Button getBtn;
    @FXML
    private TextField Rid;
    @FXML
    private ListView<String> saleView;
    @FXML
    private Label refundAmnt;


    public void endReturn(ActionEvent actionEvent)throws SQLException {
        pharmacy.updateSale(currentSale);
        // show alert that return is successfully complete
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Return");
        alert.setHeaderText("Return is successfully complete");
        alert.setContentText("Return is successfully complete");
        alert.showAndWait();

    }

    public void loadSale(ActionEvent actionEvent) throws SQLException {
        saleView.getItems().clear();
        refundAmnt.setText("Refund Amount : " + RefundAmount);
        int saleId = currentSale.getSaleId();
        System.out.println("Fetched : " + saleId);
        saleView.getItems().add("Sale Id : " + saleId);
        saleView.getItems().add("Sale Date : " + currentSale.getSaleDate());
        saleView.getItems().add("Sale Total : " + currentSale.getTotalPrice());
        saleView.getItems().add("Sale Line Items : \n");

        for (int i = 0; i < currentSale.getSaleLineItems().size(); i++) {
            String saleItem = "";
            saleItem += currentSale.getSaleLineItems().get(i).getMedicine().getMedicineId() + " ";
            //saleItem += "Medicine Name : " + currentSale.getSaleLineItems().get(i).getMedicine().getMedicineName() + "\t";
            saleItem += "Quantity : " + currentSale.getSaleLineItems().get(i).getQuantity() + "\t";
            saleItem += "Price : " + currentSale.getSaleLineItems().get(i).getPrice() + "\t";
            saleView.getItems().add(saleItem);

        }
    }
    public void removeItem(ActionEvent actionEvent) throws SQLException {
        // get the selected item
        String selectedItem = saleView.getSelectionModel().getSelectedItem();
        // get the id of the selected item
        int id = Integer.parseInt(selectedItem.split(" ")[0]);
        System.out.println(id);
        // show dialog to choose the quantity to be returned
        TextInputDialog dialog = new TextInputDialog("1");
        dialog.setTitle("Return Quantity");
        dialog.setHeaderText("Enter the quantity to be returned");
        dialog.setContentText("Quantity:");
        dialog.showAndWait();
        int quantity = Integer.parseInt(dialog.getResult());

        // get selected index of item in SaleLineItem array
        int index = 0;
        for (int i = 0; i < currentSale.getSaleLineItems().size(); i++) {
            if (currentSale.getSaleLineItems().get(i).getMedicine().getMedicineId() == id) {
                index = i;
            }
        }


        // if quantity is greater than the quantity in the sale
        if(quantity>currentSale.getSaleLineItems().get(index).getQuantity()){
            // show error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Quantity is greater than the quantity in the sale");
            alert.setContentText("Please enter a valid quantity");
            alert.showAndWait();
        }
        else{
            // If quantity == quantity in the sale
            if(quantity==currentSale.getSaleLineItems().get(index).getQuantity()){
                // remove the sale line item
                RefundAmount += currentSale.getSaleLineItems().get(index).getPrice() * quantity;
                currentSale.getSaleLineItems().remove(index);

            }
            else{

                currentSale.getSaleLineItems().get(index).setQuantity(currentSale.getSaleLineItems().get(index).getQuantity()-quantity);
                RefundAmount += currentSale.getSaleLineItems().get(index).getPrice() * quantity;
            }
            System.out.println("Previous quantity : " + pharmacy.getMedicineCatalogue().getMedicineQuantity(id));
            pharmacy.getMedicineCatalogue().setMedicineQuantity(id,pharmacy.getMedicineCatalogue().getMedicineQuantity(id)+quantity);
            System.out.println("New quantity : " + pharmacy.getMedicineCatalogue().getMedicineQuantity(id));
            currentSale.setTotalPrice(currentSale.getTotalPrice()-RefundAmount);
            System.out.println("Refund Amount : " + RefundAmount);
            System.out.println("Updated Sale Total : " + currentSale.getTotalPrice());
            loadSale(actionEvent);
        }

    }
    public void getSale() throws SQLException {
        int recieptId = Integer.parseInt(Rid.getText());
        pharmacy = Pharmacy.getInstance();
        currentSale = new Sale();
        currentSale= pharmacy.getSale(recieptId);
        int saleId = currentSale.getSaleId();
        System.out.println("Fetched : " + saleId);
        saleView.getItems().add("Sale Id : " + saleId);
        saleView.getItems().add("Sale Date : " + currentSale.getSaleDate());
        saleView.getItems().add("Sale Total : " + currentSale.getTotalPrice());
        saleView.getItems().add("Sale Line Items : \n");

        for (int i = 0; i < currentSale.getSaleLineItems().size(); i++) {
            String saleItem = "";
            saleItem += currentSale.getSaleLineItems().get(i).getMedicine().getMedicineId() + " ";
            //saleItem += "Medicine Name : " + currentSale.getSaleLineItems().get(i).getMedicine().getMedicineName() + "\t";
            saleItem += "Quantity : " + currentSale.getSaleLineItems().get(i).getQuantity() + "\t";
            saleItem += "Price : " + currentSale.getSaleLineItems().get(i).getPrice() + "\t";
            saleView.getItems().add(saleItem);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RefundAmount = 0;
        refundAmnt.setText("Refund Amount : " + RefundAmount);
        System.out.println("Returns Controller");
        System.out.println(SaleId);
        Text saleIdText = new Text();
        saleIdText.setText("Sale ID: " + SaleId);

    }

}
