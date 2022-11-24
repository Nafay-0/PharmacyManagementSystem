package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

public class CashierController implements Initializable {
    @FXML
    private Button saleBtn;
    @FXML
    private Button addSale;
    @FXML
    private Button payBtn;
    @FXML
    private ListView<String> saleList;
    @FXML
    private TextField quanField;
    @FXML
    private TextField medId;
    double total = 0;
    @FXML
    private Label totalLabel;
    @FXML
    private Label totalCost1;
    @FXML
    private Button handleReturns;

    Sale currentSale;

    public void addSale(ActionEvent actionEvent) throws IOException, SQLException {
        currentSale = new Sale();
        currentSale.setSaleDate(new Date());
        currentSale.setSaleStatus(true);
        int med_id = Integer.parseInt(medId.getText());
        int quantity = Integer.parseInt(quanField.getText());
        Pharmacy pharmacy = new Pharmacy();
        ArrayList<Medicine> avlMedicines = pharmacy.getAllMedicines();
        Medicine currentMedicine = null;
        for (Medicine medicine : avlMedicines) {
            if (medicine.getMedicineId() == med_id) {
                currentMedicine = medicine;
            }
        }
        MedicineDescription medicineDescription = pharmacy.getMedicineCatalogue().getMedicineDescription(currentMedicine.getMedicineId());
        double price = medicineDescription.getPrice();

        currentSale.addSaleLineItem(currentMedicine, quantity, price);
        saleList.getItems().add(medicineDescription.getMedicineName() + " \t " + quantity + " \t " + price);
        total += price * quantity;
        currentSale.setTotalPrice(total);
        totalLabel.setText(String.valueOf("Total : " + total));

    }

    public void payAmount(ActionEvent actionEvent) throws SQLException, IOException {
        // show Dialog box asking for paid amount
        // if paid amount is greater than total amount
        // show change
        // else show error alert
// update sale status to false
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Payment");
        dialog.setHeaderText("Enter the amount paid");
        dialog.setContentText("Enter the amount paid :");
        dialog.showAndWait();
        double paidAmount = Double.parseDouble(dialog.getEditor().getText());
        if (paidAmount >= total) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Payment");
            alert.setHeaderText("Payment Successful");
            alert.setContentText("Change : " + (paidAmount - total));
            alert.showAndWait();
            currentSale.setSaleStatus(false);
            Pharmacy pharmacy =  Pharmacy.getInstance();
            pharmacy.saveSale(currentSale);
            Receipt receipt = new Receipt();
            receipt.setSaleID(currentSale.getSaleId());
            //dbHandler dbHandler = new dbHandler();
           // dbHandler.addSale(currentSale);
            Stage stage = (Stage) payBtn.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/CashierPage.fxml")));
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Payment");
            alert.setHeaderText("Payment Failed");
            alert.setContentText("Amount paid is less than total amount");
            alert.showAndWait();
        }


//        totalCost1.setText(String.valueOf("Total : " + total));
//        Stage stage = (Stage)payBtn.getScene().getWindow();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/Transaction.fxml")));
//        stage.setScene(new Scene(root));
//        stage.show();
    }
    public void startSale(ActionEvent actionEvent) throws IOException {


        // redirect to startSale page
        Stage stage = (Stage) saleBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/startSale.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleReturnFunction(ActionEvent event) throws IOException {
        Stage stage = (Stage)handleReturns .getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/Pharmacy/Project/handleReturns.fxml"));
        Parent root = (Parent) loader.load();
        ReturnsController controller = loader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (saleList == null) {
            saleList = new ListView<>();
            saleList.getItems().add("Medicine Name \t Quantity \t Price");
        }
    }
}
