package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.Medicine;
import com.Pharmacy.Project.LogicComponent.MedicineDescription;
import com.Pharmacy.Project.LogicComponent.Pharmacy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddSupplierController implements Initializable {
    @FXML
    private TextField SupplierName;
    @FXML
    private TextField SupplierAddress;
    @FXML
    private TextField SupplierPhone;
    @FXML
    private TextField SupplierEmail;
    @FXML
    private ListView<String> medicineList;

    ArrayList<Medicine> medicines = new ArrayList<>();
    ArrayList<Medicine> suppliedMedicines = new ArrayList<>();
    @FXML
    private Button addMedicineButton;

    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) addMedicineButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void addMedicine(ActionEvent event) throws SQLException {
        // get selected medicine id
        Pharmacy pharmacy = Pharmacy.getInstance();
        medicines = pharmacy.getAllMedicines();
        String selectedMedicine = medicineList.getSelectionModel().getSelectedItem();
        int id = Integer.parseInt(selectedMedicine.split(" ")[0]);
        System.out.println(id);
        // get medicine object
        Medicine medicine = new Medicine();
        for (Medicine m: medicines){

            if (m.getMedicineId() == id){
                System.out.println("found");
                medicine.setMedicineId(m.getMedicineId());
                medicine.setQuantity(m.getQuantity());
                break;
            }
        }
        // add medicine to  array list if it is not already present
        if (!suppliedMedicines.contains(medicine)){
            suppliedMedicines.add(medicine);
        }
        System.out.println("Update list");
        for (Medicine m: suppliedMedicines){
            System.out.println(m.getMedicineId());
        }

    }

    public void addSupplier() throws SQLException {
        String name = SupplierName.getText();
        String address = SupplierAddress.getText();
        String phone = SupplierPhone.getText();
        String email = SupplierEmail.getText();
        Pharmacy pharmacy = Pharmacy.getInstance();
        pharmacy.addSupplier(name,address,phone,email,medicines);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Supplier Added");
        alert.setHeaderText("Supplier Added Successfully");
        alert.showAndWait();
        // clear all fields
        SupplierName.clear();
        SupplierAddress.clear();
        SupplierPhone.clear();
        SupplierEmail.clear();
        medicines.clear();
        medicineList.getItems().clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pharmacy pharmacy = null;
        try {
            pharmacy = Pharmacy.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Medicine> medicines;
        try {
            medicines = pharmacy.getAllMedicines();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Medicine medicine : medicines) {
            MedicineDescription md = pharmacy.getMedicineCatalogue().getMedicineDescription(medicine.getMedicineId());
            medicineList.getItems().add("" + medicine.getMedicineId() + " \t  "+  md.getMedicineName() );
        }
    }
}
