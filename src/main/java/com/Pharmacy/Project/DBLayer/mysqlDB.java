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

    @Override
    public ArrayList<Medicine> getAllMedicines() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM Medicine";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        // check if result set is empty
        if (!resultSet.isBeforeFirst()) {
           System.out.println("No data");
        }
        ArrayList<Medicine> medicines = new ArrayList<>();
        // print the result set
        while (resultSet.next()) {
            Medicine medicine = new Medicine();
            medicine.setMedicineId(resultSet.getInt("MedicineId"));
            medicine.setQuantity(resultSet.getInt("quantity"));
            medicines.add(medicine);
        }
        //System.out.println(medicines);
//        // print all the medicines
//        for (Medicine medicine : medicines) {
//            System.out.println(medicine.getMedicineId() + " " + medicine.getQuantity());
//        }

        return medicines;
    }

    @Override
    public MedicineCatalog getMedicineCatalog() throws SQLException {
        ArrayList<Medicine> medicines = getAllMedicines();
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM MedicineDescription";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        // check if result set is empty
        if (!resultSet.isBeforeFirst()) {
           System.out.println("No data");
        }
        MedicineCatalog medicineCatalog = new MedicineCatalog();
        // get all medicines first

        // get all medicine descriptions
        while (resultSet.next()) {
            MedicineDescription medicineDescription = new MedicineDescription();
            medicineDescription.setMedicineId(resultSet.getInt("MedicineId"));
            medicineDescription.setMedicineName(resultSet.getString("MedicineName"));
            medicineDescription.setPrice(resultSet.getDouble("price"));
            medicineDescription.setCompany(resultSet.getString("Company"));
            Medicine m = new Medicine();
            for (Medicine medicine : medicines) {
                if (medicine.getMedicineId() == medicineDescription.getMedicineId()) {
                    m.setQuantity(medicine.getQuantity());
                    m.setMedicineId(medicine.getMedicineId());
                }
            }
            medicineCatalog.addMedicine(m, medicineDescription);
        }
        // print all the medicines in the catalog
        System.out.println("medicineCatalog");
        for (Medicine medicine : medicineCatalog.getMedicineList()) {
            System.out.println(medicine.getMedicineId() + " " + medicine.getQuantity());
        }
        return medicineCatalog;
    }

}
