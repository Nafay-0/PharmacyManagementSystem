package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.Medicine;
import com.Pharmacy.Project.LogicComponent.MedicineDescription;
import com.Pharmacy.Project.LogicComponent.Pharmacy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class addMedicineController {

    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) addBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void addMedicine() throws SQLException, IOException {
        Pharmacy pharmacy = Pharmacy.getInstance();
        Medicine m = new Medicine();
        m.setQuantity(Integer.parseInt(med_quantity.getText()));
        MedicineDescription md = new MedicineDescription();
        md.setCompany(med_company.getText());
        md.setMedicineName(med_name.getText());
        md.setPrice(Double.parseDouble(med_price.getText()));
        md.setMedicineDescription(med_description.getText());
        pharmacy.addMedicine(m,md);

        // show alert showing medicine added
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Medicine Added");
        alert.setHeaderText(null);
        alert.setContentText("Medicine Added Successfully");
        alert.showAndWait();
        // clear all fields
        med_name.clear();
        med_company.clear();
        med_price.clear();
        med_quantity.clear();
        med_description.clear();

    }
    @FXML
    public Button retBut;
    @FXML
    public ListView medListView;
    @FXML
    public TextArea med_description;
    @FXML
    public TextField med_name;
    @FXML
    public TextField med_price;
    @FXML
    public TextField med_quantity;
    @FXML
    public TextField med_company;
    @FXML
    public Button addBtn;
}
