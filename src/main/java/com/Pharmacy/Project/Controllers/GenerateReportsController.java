package com.Pharmacy.Project.Controllers;


import com.Pharmacy.Project.LogicComponent.MedicineOrder;
import com.Pharmacy.Project.LogicComponent.Pharmacy;
import com.Pharmacy.Project.LogicComponent.Sale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class GenerateReportsController {
    public Label HeadingLabel;
    ArrayList<MedicineOrder> completedOrders;
    ArrayList<Sale> completedSales;
    @FXML
    ListView<String>reports;
    @FXML
    public DatePicker startDate;
    @FXML
    public DatePicker endDate;
    public void getSalesReport(ActionEvent event) throws SQLException {
        Pharmacy pharmacy = Pharmacy.getInstance();
        completedSales = pharmacy.getSalesReport();
        reports.getItems().clear();

        Date start = Date.valueOf(startDate.getValue());
        Date end = Date.valueOf(endDate.getValue());
        if(start.after(end)){
            reports.getItems().clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Start date cannot be after end date");
            alert.showAndWait();
            return;
        }
        start = new Date(start.getTime() - 86400000);
        end = new Date(end.getTime() + 86400000);
        // filter by date
        for (Sale sale : completedSales) {
            if (sale.getSaleDate().after(start) && sale.getSaleDate().before(end)) {
                reports.getItems().add(sale.toString());
            }
        }
        HeadingLabel.setText("SaleID \t\t Total \t\t Date");

    }
    public void getOrdersReport(ActionEvent event) throws SQLException {
        Date start = Date.valueOf(startDate.getValue());
        Date end = Date.valueOf(endDate.getValue());
        if(start.after(end)){
            reports.getItems().clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Start date cannot be after end date");
            alert.showAndWait();
            return;
        }
        start = new Date(start.getTime() - 86400000);
        end = new Date(end.getTime() + 86400000);
        Pharmacy pharmacy = Pharmacy.getInstance();
        completedOrders = pharmacy.getOrdersReport();
        reports.getItems().clear();
        for (MedicineOrder o : completedOrders) {
            if (o.getDate().after(start) && o.getDate().before(end)) {
                reports.getItems().add(o.toString());
            }
        }

        HeadingLabel.setText("OrderID \t MedicineID \t Quantity \t OrderDate \t\t Total");
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) reports.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
