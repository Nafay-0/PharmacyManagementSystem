package com.Pharmacy.Project.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminController {
    @FXML
    private Button reportBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button viewBtn;


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
}
