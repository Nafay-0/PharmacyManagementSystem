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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    public Label headerLabel;
    @FXML
    public TextField searchMed;
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
    @FXML
    private Button orderBtn;


    public void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/LoginPage.fxml")));
        Stage window = (Stage) reportBtn.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) addBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void showReport(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/generateReports.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void orderMedicines(ActionEvent event) throws IOException {
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/orderMedicines.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void addMedicine(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AddMedicinePage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void removeMedicine(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/RemoveMedicine.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void ManageStock(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/StockUpdatePage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void AddStock(ActionEvent event) throws SQLException, IOException {
        // print selected item in list view
        String i = medList.getSelectionModel().getSelectedItem();
        // parse id from string
        String[] parts = i.split(" ");
        String part1 = parts[0];
        int id = Integer.parseInt(part1);
        System.out.println(id);
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Manage Stock");
        dialog.setHeaderText("Manage Stock");
        dialog.setContentText("Enter the new amount of stock :");
        dialog.showAndWait();
        String result = dialog.getResult();
        int stock = Integer.parseInt(result);
        System.out.println(stock);
        Pharmacy p = Pharmacy.getInstance();
        p.getMedicineCatalogue().setMedicineQuantity(id,stock);
        Stage stage = (Stage) addBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/StockUpdatePage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void RemoveStock(int MedicineId, int quantity) throws SQLException {
        return;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pharmacy pharmacy = null;
        try {
            pharmacy = Pharmacy.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            // if medList is NULL then it returns
            if (medList == null) {
                return;
            }
            ArrayList<Medicine> avlMedicines = pharmacy.getAllMedicines();
            String header = "MedId   \tName\tQuantity";
            headerLabel.setText(header);
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
                else {
                    Display = Display + "  \t  \t" + "Not Available";
                }
                Display = Display + "  \t  \t " + quantity;
                medList.getItems().add(Display);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void AddSupplier(ActionEvent event) throws IOException {
        Stage stage = (Stage) reportBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/addSupplier.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void RegisterCashier(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/RegisterCashier.fxml")));
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void manageOrders(ActionEvent actionEvent) {
        Stage stage = (Stage) orderBtn.getScene().getWindow();
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/MedicineOrders.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void SearchMedicine(ActionEvent actionEvent) {
        String Tosearch = searchMed.getText();
        medList.getItems().clear();
        Pharmacy pharmacy = null;
        try {
            pharmacy = Pharmacy.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            // if medList is NULL then it returns
            if (medList == null) {
                return;
            }
            ArrayList<Medicine> avlMedicines = pharmacy.getAllMedicines();
            String header = "MedId   \tName\tQuantity";
            headerLabel.setText(header);
            for (Medicine medicine : avlMedicines) {
                int medicineId = medicine.getMedicineId();
                int quantity = medicine.getQuantity();
                String Display = String.valueOf(medicineId);
                MedicineCatalog medicineCatalog = new MedicineCatalog();
                medicineCatalog = pharmacy.getMedicineCatalogue();
                MedicineDescription medicineDescription = medicineCatalog.getMedicineDescription(medicineId);
                String medicineName = " ";
                if(medicineDescription != null){
                    medicineName= medicineDescription.getMedicineName();

                }
                else {
                    Display = Display + "  \t  \t" + "Not Available";
                }
                if (medicineName.contains(Tosearch)){
                    Display = Display + "  \t  \t" + medicineName;
                    Display = Display + "  \t  \t " + quantity;
                    medList.getItems().add(Display);
                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
