package com.Pharmacy.Project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysqlDB extends dbHandler{
    // mysql specific code
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String url = "jdbc:mysql://localhost:3306/BankDB";
    private String user = "root";
    private String password = "tiger123";


    @Override
    void insertSales(Sale S) {

    }

    @Override
    void addManager(Manager M) {

    }

    @Override
    void addCashier(Cashier c) {

    }

    @Override
    void addMedicine(Medicine m) {

    }

    @Override
    void addSupplier(Supplier s) {

    }

    @Override
    void addOrder(MedicineOrder o) {

    }

    @Override
    ArrayList<Medicine> getMedicine() {
        return null;
    }

    @Override
    ArrayList<Manager> getManager() {
        return null;
    }

    @Override
    ArrayList<Cashier> getCashier() {
        return null;
    }

    @Override
    ArrayList<Supplier> getSupplier() {
        return null;
    }

    @Override
    ArrayList<Sale> getSales() {
        return null;
    }

    @Override
    ArrayList<MedicineOrder> getOrders() {
        return null;
    }
}
