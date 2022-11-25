package com.Pharmacy.Project.DBLayer;

import com.Pharmacy.Project.LogicComponent.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class FilePersistence extends PersistenceHandler {
    private String path;



    @Override
    public Boolean verifyManager(String EmployeeName, String EmployeePassword) throws SQLException {
        return null;
    }

    @Override
    public boolean verifyCashier(String EmployeeName, String EmployeePassword) throws SQLException {
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
}
