package com.Pharmacy.Project.DBLayer;

import com.Pharmacy.Project.*;

import java.sql.SQLException;
import java.util.ArrayList;

// generic db class; can be used for any db mysql, oracle, etc
public abstract class dbHandler {
    public abstract   Boolean verifyManager(String EmployeeName, String EmployeePassword) throws SQLException;
    public abstract boolean verifyCashier(String EmployeeName, String EmployeePassword) throws SQLException;
    abstract void insertSales(Sale S);
    abstract void addManager(Manager M);
    abstract void addCashier(Cashier c);
    abstract void addMedicine(Medicine m);
    abstract void addSupplier(Supplier s);
    abstract void addOrder(MedicineOrder o);
    abstract ArrayList<Medicine> getMedicine();
    abstract ArrayList<Manager> getManager();
    abstract ArrayList<Cashier> getCashier();
    abstract ArrayList<Supplier> getSupplier();
    abstract ArrayList<Sale> getSales();
    abstract ArrayList<MedicineOrder> getOrders();



}
