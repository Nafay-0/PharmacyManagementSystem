package com.Pharmacy.Project.DBLayer;

import com.Pharmacy.Project.LogicComponent.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

// generic db class; can be used for any db mysql, oracle, etc
public abstract class PersistenceHandler {
    static private PersistenceHandler instance = null;
    public static PersistenceHandler getInstance(String dbType) {
        if (instance == null) {
            if (dbType.equals("mysql")) {
                instance = new mysqlPersistence();
            }
            else{
                instance = new FilePersistence();
            }
        }
        return instance;
    }
    public abstract   Boolean verifyManager(String EmployeeName, String EmployeePassword) throws SQLException, IOException, ClassNotFoundException;
    public abstract boolean verifyCashier(String EmployeeName, String EmployeePassword) throws SQLException, IOException;
    public abstract void insertSales(Sale S);
    abstract void addManager(Manager M);
    public abstract void addCashier(Cashier c);
    public abstract void addMedicine(Medicine m, MedicineDescription md);
    public abstract void removeMedicine(Medicine m);
    public abstract void addSupplier(Supplier s, ArrayList<Medicine> medicines) throws SQLException;
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


    public abstract void insertOrder(MedicineOrder medicineOrder);

    public abstract ArrayList<MedicineOrder> getOrderRecord() throws SQLException;

    public abstract void completeOrder(MedicineOrder o);
    public abstract Medicine getMedicine(int id) throws SQLException;
    public abstract Supplier getSupplier(int id) throws SQLException;
}
