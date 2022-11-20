package com.Pharmacy.Project;

import com.Pharmacy.Project.DBLayer.dbHandler;
import com.Pharmacy.Project.DBLayer.mysqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Pharmacy {
    private String name;
    private String address;
    private String phone;

    Ledger ledger;
    OrderRecord orderRecord;
    Catalogue medicineCatalogue;
    ArrayList<Supplier> supplierList;

    dbHandler db;

    public Pharmacy(){
        db = new mysqlDB();
    }

    public Pharmacy(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.ledger = new Ledger();
        this.orderRecord = new OrderRecord();
        this.medicineCatalogue = new Catalogue();
        this.supplierList = new ArrayList<Supplier>();
        db = new mysqlDB();
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

    public Catalogue getMedicineCatalogue() {
        return medicineCatalogue;
    }

    public void setMedicineCatalogue(Catalogue medicineCatalogue) {
        this.medicineCatalogue = medicineCatalogue;
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
    public dbHandler getDb() {
        return db;
    }

    public void setDb(dbHandler db) {
        this.db = db;
    }
}
