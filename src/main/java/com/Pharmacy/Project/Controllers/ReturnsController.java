package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.Pharmacy;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ReturnsController implements Initializable {
    @FXML
    private Text saleIdText;
    int SaleId;
    Pharmacy pharmacy;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Returns Controller");
        System.out.println(SaleId);
        Text saleIdText = new Text();
        saleIdText.setText("Sale ID: " + SaleId);

    }

}
