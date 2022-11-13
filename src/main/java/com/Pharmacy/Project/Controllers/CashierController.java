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

public class CashierController {
    @FXML
    private Button saleBtn;

    public void startSale(ActionEvent actionEvent) throws IOException {
        // redirect to startSale page
        Stage stage = (Stage) saleBtn.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/startSale.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
