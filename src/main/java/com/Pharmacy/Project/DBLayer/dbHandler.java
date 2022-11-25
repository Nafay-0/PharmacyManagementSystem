package com.Pharmacy.Project.DBLayer;

import com.Pharmacy.Project.LogicComponent.*;

import java.sql.SQLException;
import java.util.ArrayList;

// generic db class; can be used for any db mysql, oracle, etc
public abstract class dbHandler {

    static private dbHandler instance = null;
    public static dbHandler getInstance(String dbType) {
        if (instance == null) {
            if (dbType.equals("mysql")) {
                instance = new mysqlDB();
            }
            else{
                instance = new FileDb();
            }
        }
        return instance;
    }
    public abstract   Boolean verifyManager(String EmployeeName, String EmployeePassword) throws SQLException;
    public abstract boolean verifyCashier(String EmployeeName, String EmployeePassword) throws SQLException;
    public abstract void insertSales(Sale S);
    abstract void addManager(Manager M);
    abstract void addCashier(Cashier c);
    abstract void addMedicine(Medicine m);
    abstract void addSupplier(Supplier s);
    abstract void addOrder(MedicineOrder o);
    abstract ArrayList<Medicine> getMedicine();
    abstract ArrayList<Manager> getManager();
    abstract ArrayList<Cashier> getCashier();
    abstract ArrayList<Supplier> getSupplier();

    public abstract ArrayList<Supplier> getSupplierforMedicine(Medicine m) throws SQLException;
    abstract ArrayList<Sale> getSales();
    abstract ArrayList<MedicineOrder> getOrders();


    public abstract ArrayList<Medicine> getAllMedicines() throws SQLException;
    public abstract MedicineCatalog getMedicineCatalog() throws SQLException;

    public abstract void updateStock(int MedicineId, int Quantity) throws SQLException;

    public abstract void writeReceipt(Receipt r) throws SQLException;
    public abstract Sale getSalefromReceipt(int receiptId) throws SQLException;

    public abstract void updateSale(Sale s) throws SQLException;

}
