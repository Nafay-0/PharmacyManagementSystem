package com.Pharmacy.Project.Controllers;

import com.Pharmacy.Project.LogicComponent.MedicineOrder;
import com.Pharmacy.Project.LogicComponent.OrderRecord;
import com.Pharmacy.Project.LogicComponent.Pharmacy;
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

public class MedicineOrdersManage implements Initializable {

    @FXML
    public ListView ordersView;
    @FXML
    public Button retBut;
    @FXML
    public Button completeBtn;

    ArrayList<MedicineOrder>orders;

    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) retBut.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/Pharmacy/Project/AdminPage.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void markComplete(ActionEvent actionEvent) {
        String order = (String) ordersView.getSelectionModel().getSelectedItem();
        String[] orderSplit = order.split(" ");
        int orderID = Integer.parseInt(orderSplit[0]);
        System.out.println(orderID);
        int Toremove = -1;
        for (MedicineOrder o : orders) {
            if (o.getOrderId() == orderID) {
                try {
                    Pharmacy.getInstance().completeOrder(o);
                    // remove from orders
                    Toremove = orders.indexOf(o);
                    break;
                    // remove from view
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        if (Toremove != -1) {
            orders.remove(Toremove);
            initialize(null, null);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ordersView.getItems().clear();
        orders = new ArrayList<>();
        Pharmacy pharmacy;
        try {
            pharmacy = Pharmacy.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<MedicineOrder> orderRecord = null;
        try {
            orders = pharmacy.getOrderRecord();
            System.out.println("Fetched from Pharmacy : " + orders.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (MedicineOrder order : orders) {
            String orderDetails = order.getOrderId() + " \t\t " + order.getMedicine().getMedicineId() + " \t\t " + order.getQuantity() + " \t\t " +order.getSupplier().getSupplierName()+ " \t\t " + order.getTotal();
            ordersView.getItems().add(orderDetails);
        }

    }
}
