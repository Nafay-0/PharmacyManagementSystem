package com.Pharmacy.Project.LogicComponent;

import java.util.Date;

public class MedicineOrder {
    Medicine medicine;
    int quantity;
    Date date;
    Supplier supplier;
    double totalCost;
    public MedicineOrder(){
        this.medicine = new Medicine();
        this.quantity = 0;
        this.date = new Date();
        this.supplier = new Supplier();
        this.totalCost = 0;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setTotal(double total) {
        this.totalCost = total;

    }
    public double getTotal() {
        return totalCost;
    }
}
