package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.Pharmacy;
import com.Pharmacy.Project.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class RegisterCashier {
    @FXML
    private Button regButton;
    @FXML
    private TextField regName;
    @FXML
    private TextField Address;
    @FXML
    private TextField Phone;
    @FXML
    private PasswordField passwordField;

    public void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) regButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
    public Boolean check_exist(String regName, String Password) throws SQLException, IOException {
        Pharmacy pharmacy = Pharmacy.getInstance();
        if(pharmacy.verifyCashier(regName,Password)){
            return true;
        }
        else{
            return false;
        }
    }
    public void register(ActionEvent event) throws SQLException, IOException {
        String name = regName.getText();
        String password = passwordField.getText();
        String address = Address.getText();
        String phone = Phone.getText();
        if (check_exist(name,password)){
            System.out.println("Cashier already exists");
            // show error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cashier already exists");
            alert.showAndWait();
            // clear fields
            regName.clear();
            passwordField.clear();
            Address.clear();
            Phone.clear();

        }
        else{
            Pharmacy pharmacy = Pharmacy.getInstance();
            pharmacy.addCashier(name,password,address,phone);
            // show success Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cashier Added");
            alert.setHeaderText(null);
            alert.setContentText("Cashier Added Successfully");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 750, 600);
            Stage stage = new Stage();
            stage.setTitle("Login Page");
            stage.setScene(scene);
            stage.show();
        }
    }

}
