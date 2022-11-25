package com.Pharmacy.Project.LogicComponent;

import com.Pharmacy.Project.DBLayer.Factory;
import com.Pharmacy.Project.DBLayer.PersistenceHandler;
import com.Pharmacy.Project.DBLayer.mysqlPersistence;

import java.sql.SQLException;
import java.util.ArrayList;

public class Pharmacy {
    private String name;
    private String address;
    private String phone;

    Ledger ledger;
    OrderRecord orderRecord;
    MedicineCatalog medicineCatalogue;
    ArrayList<Supplier> supplierList;
    OrderRecord orderList;
    PersistenceHandler db;
    ArrayList<Receipt> receiptList;

    static Pharmacy instance = null;
    private Pharmacy() throws SQLException {

        Factory factory = Factory.getInstance();
        db = factory.getDBhandler("mysql");
        medicineCatalogue = new MedicineCatalog();
        medicineCatalogue = db.getMedicineCatalog();
        orderList = new OrderRecord();

    }

    public static Pharmacy getInstance() throws SQLException {
        if (instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }

    public OrderRecord getOrderList() {
        return orderList;
    }
    public void setOrderList(OrderRecord orderList) {
        this.orderList = orderList;
    }

    public Pharmacy(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.ledger = new Ledger();
        this.orderRecord = new OrderRecord();
        this.medicineCatalogue = new MedicineCatalog();
        this.supplierList = new ArrayList<Supplier>();
        db = new mysqlPersistence();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Ledger getLedger() {
        return ledger;
    }

    public void setLedger(Ledger ledger) {
        this.ledger = ledger;
    }

    public OrderRecord getOrderRecord() {
        return orderRecord;
    }

    public void setOrderRecord(OrderRecord orderRecord) {
        this.orderRecord = orderRecord;
    }


    public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(ArrayList<Supplier> supplierList) {
        this.supplierList = supplierList;
    }


    public Boolean verifyManager(String EmployeeName, String password) throws SQLException {
        return db.verifyManager(EmployeeName, password);
    }
    public ArrayList<Medicine>getAllMedicines() throws SQLException {
        return db.getAllMedicines();
    }
    public PersistenceHandler getDb() {
        return db;
    }

    public void setDb(PersistenceHandler db) {
        this.db = db;
    }

    public MedicineCatalog getMedicineCatalogue() {
        return medicineCatalogue;
    }
    public void saveSale(Sale s) throws SQLException {
        db.insertSales(s);
    }
    public void addMedicineOrder(MedicineOrder medicineOrder) throws SQLException {
        orderRecord.addOrder(medicineOrder);
    }
    public ArrayList<Supplier> getSupplierListFromDB(Medicine M) throws SQLException {
        supplierList = db.getSupplierforMedicine(M);
        return supplierList;
    }
    public Sale getSale(int r) throws SQLException {
        Sale s  = db.getSalefromReceipt(r);
        return s;
    }
    public void updateSale(Sale s) throws SQLException {
        db.updateSale(s);
    }

    public void setMedicineCatalogue(MedicineCatalog medicineCatalogue) {
        this.medicineCatalogue = medicineCatalogue;
    }

    public void addMedicine(Medicine medicine, MedicineDescription medicineDescription) {
        medicineCatalogue.addMedicine(medicine, medicineDescription);
        db.addMedicine(medicine, medicineDescription);

    }
}
