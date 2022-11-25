package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.Medicine;
import com.Pharmacy.Project.LogicComponent.MedicineCatalog;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class RemoveMedicineController implements Initializable {
    @FXML
    public Button retBut;
    @FXML
    public ListView medList;
    @FXML
    public Button removeBtn;

    public void removeMedicine() throws SQLException {
        // get selected medicine
        String des = (String) medList.getSelectionModel().getSelectedItem();
        // parse int from string
        int id = Integer.parseInt(des.substring(0,des.indexOf(" ")));
        Medicine m = new Medicine();
        m.setMedicineId(id);
        Pharmacy pharmacy = Pharmacy.getInstance();
        // confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // confirm removal of medicine
        alert.setTitle("Confirm Removal");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to remove this medicine?");
        alert.showAndWait();
        pharmacy.removeMedicine(m);
        // show alert showing medicine removed
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Medicine Removed");
        alert1.setHeaderText(null);
        alert1.setContentText("Medicine Removed Successfully");
        alert1.showAndWait();
        // refresh list
        medList.getItems().clear();
        initialize(null,null);
    }


    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) retBut.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pharmacy pharmacy;
        try {
            pharmacy = Pharmacy.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Medicine> avlMedicines = null;
        try {
            avlMedicines = pharmacy.getAllMedicines();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String header = "MedicineId\tName\tQuantity";
        medList.getItems().add(header);
        for (Medicine medicine : avlMedicines) {
            int medicineId = medicine.getMedicineId();
            int quantity = medicine.getQuantity();
            String Display = String.valueOf(medicineId);
            MedicineCatalog medicineCatalog = new MedicineCatalog();
            medicineCatalog = pharmacy.getMedicineCatalogue();
            MedicineDescription medicineDescription = medicineCatalog.getMedicineDescription(medicineId);
            if(medicineDescription != null){
                String medicineName = medicineDescription.getMedicineName();
                Display = Display + "  \t  \t" + medicineName;
            }
            Display = Display + "  \t  \t " + quantity;
            medList.getItems().add(Display);
        }
    }
}
