package com.Pharmacy.Project.DBLayer;
import com.Pharmacy.Project.*;

import java.sql.*;
import java.util.ArrayList;

public class mysqlDB extends dbHandler {
    // mysql specific code
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String url = "jdbc:mysql://localhost:3306/Pharmacy";
    private String user = "root";
    private String password = "tiger123";


    @Override
    public Boolean verifyManager(String EmployeeName, String EmployeePassword) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM Manager WHERE EmployeeName = '" + EmployeeName + "' AND EmployeePassword = '" + EmployeePassword + "'";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    public boolean verifyCashier(String EmployeeName, String EmployeePassword) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM Cashier WHERE EmployeeName = '" + EmployeeName + "' AND EmployeePassword = '" + EmployeePassword + "'";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

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