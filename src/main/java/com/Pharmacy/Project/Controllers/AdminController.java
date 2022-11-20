package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.Medicine;
import com.Pharmacy.Project.Pharmacy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private Button reportBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button viewBtn;
    @FXML
    private ListView<String>medList;
    @FXML
    private Button checkStock;


    public void showReport(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/viewReport.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void addMedicine(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AddMedicinePage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void ManageStock(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/StockUpdatePage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void AddStock(int MedicineId, int quantity) throws SQLException {
        return;
    }
    public void RemoveStock(int MedicineId, int quantity) throws SQLException {
        return;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pharmacy pharmacy = new Pharmacy();
        try {
            // if medList is NULL then it returns
            if (medList == null) {
                return;
            }
            ArrayList<Medicine> avlMedicines = pharmacy.getAllMedicines();
            for (Medicine medicine : avlMedicines) {
                int medicineId = medicine.getMedicineId();
                int quantity = medicine.getQuantity();
                String Display = "Medicine ID: " + medicineId + " Quantity: " + quantity;
                medList.getItems().add(Display);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
