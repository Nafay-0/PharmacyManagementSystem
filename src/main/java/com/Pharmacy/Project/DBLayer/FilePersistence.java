package com.Pharmacy.Project.DBLayer;

import com.Pharmacy.Project.LogicComponent.*;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilePersistence extends PersistenceHandler {
    private String path;



    @Override
    public Boolean verifyManager(String EmployeeName, String EmployeePassword) throws SQLException, IOException, ClassNotFoundException {
        String fileName = "Manager.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Manager> managers = (ArrayList<Manager>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        for (Manager manager : managers) {
            if (manager.getEmployeeName().equals(EmployeeName) && manager.getEmployeePassword().equals(EmployeePassword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean verifyCashier(String EmployeeName, String EmployeePassword) throws SQLException, IOException {
        String fileName = "Cashier.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Cashier> cashiers = null;
        try {
            cashiers = (ArrayList<Cashier>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        objectInputStream.close();
        fileInputStream.close();
        for (Cashier cashier : cashiers) {
            if (cashier.getEmployeeName().equals(EmployeeName) && cashier.getEmployeePassword().equals(EmployeePassword)) {
                return true;
            }
        }
        return false;


    }

    @Override
    public void insertSales(Sale S) {

    }

    @Override
    void addManager(Manager M) {

    }

    @Override
    public void addCashier(Cashier c) {

    }

    @Override
    public void addMedicine(Medicine m, MedicineDescription md) {

    }

    @Override
    public void removeMedicine(Medicine m) {

    }


    @Override
    public void addSupplier(Supplier s, ArrayList<Medicine> medicines) {

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
    public ArrayList<Supplier> getSupplierforMedicine(Medicine m) {
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
    public ArrayList<Medicine> getAllMedicines() {
        return null;
    }

    @Override
    public MedicineCatalog getMedicineCatalog() throws SQLException {
        return null;
    }

    @Override
    public void updateStock(int MedicineId, int Quantity) throws SQLException {

    }

    @Override
    public void writeReceipt(Receipt r) throws SQLException {

    }

    @Override
    public Sale getSalefromReceipt(int receiptId) throws SQLException {
        return null;
    }

    @Override
    public void updateSale(Sale s) throws SQLException {

    }

    @Override
    public void insertOrder(MedicineOrder medicineOrder) {

    }

    @Override
    public ArrayList<MedicineOrder> getOrderRecord() {
        return null;
    }

    @Override
    public void completeOrder(MedicineOrder o) {

    }

    @Override
    public Medicine getMedicine(int id) throws SQLException {
        return null;
    }

    @Override
    public Supplier getSupplier(int id) throws SQLException {
        return null;
    }
}
