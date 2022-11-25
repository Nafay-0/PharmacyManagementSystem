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
import java.util.Objects;
import java.util.ResourceBundle;

public class OrderMedicines implements Initializable {
    private Pharmacy pharmacy;
    @FXML
    private Button orderBtn;
    @FXML
    private ListView<String> medList;


    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void orderMedicine(ActionEvent event) throws SQLException {
        // get medicine id from selected item
        int id = Integer.parseInt(medList.getSelectionModel().getSelectedItem().split(" ")[0]);
        // get medicine from id
        ArrayList<Medicine> medicines = pharmacy.getMedicineCatalogue().getMedicineList();
        Medicine medicine = null;
        for (Medicine m : medicines) {
            if (m.getMedicineId() == id) {
                medicine = m;
                break;
            }
        }
        // get suppliers for medicine
        ArrayList<Supplier>suppliers = pharmacy.getSupplierListFromDB(medicine);
        for (Supplier s : suppliers) {
            System.out.println(s.getSupplierName());
        }
        // Display the list of suppliers
        // Dialog with drop down list of suppliers

        ArrayList<String>choices = new ArrayList<>();
        for (Supplier s : suppliers) {
            choices.add(s.getSupplierName());
        }
        ChoiceDialog<String>dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle("Supplier Selection");
        dialog.setHeaderText("Select a supplier");
        dialog.setContentText("Choose a supplier:");
        dialog.showAndWait();

        // choose quantity
        TextInputDialog dialog1 = new TextInputDialog("1");
        dialog1.setTitle("Quantity Selection");
        dialog1.setHeaderText("Select a quantity");
        dialog1.setContentText("Choose a quantity:");
        dialog1.showAndWait();
        int quantity = Integer.parseInt(dialog1.getEditor().getText());


        String supplierName = dialog.getSelectedItem();
        System.out.println("Email sent to " + supplierName);
        // show alert of email sent to supplier
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Email Sent");
        alert.setHeaderText("Email sent to " + supplierName);
        alert.setContentText("Email sent to " + supplierName);
        alert.showAndWait();

        MedicineOrder medicineOrder = new MedicineOrder();
        medicineOrder.setMedicine(medicine);
        medicineOrder.setQuantity(quantity);
        Supplier slectedSuppler = null;
        for (Supplier s : suppliers) {
            if (s.getSupplierName().equals(supplierName)) {
                slectedSuppler = s;
                break;
            }
        }
        medicineOrder.setSupplier(slectedSuppler);
        pharmacy.addMedicineOrder(medicineOrder);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            pharmacy = Pharmacy.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Medicine> UnavlMed = pharmacy.getMedicineCatalogue().getUnavailableMedicine();
        for (Medicine med : UnavlMed) {
            MedicineDescription medDesc = pharmacy.getMedicineCatalogue().getMedicineDescription(med.getMedicineId());
            String medId = String.valueOf(med.getMedicineId());

            medList.getItems().add(medId + " \t " + medDesc.getMedicineName());
        }
    }
}
