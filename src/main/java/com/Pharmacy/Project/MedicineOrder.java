package com.Pharmacy.Project;

import java.util.Date;

public class MedicineOrder {
   Medicine medicine;
    int quantity;
    Date date;
    Supplier supplier;
    public MedicineOrder(){
        this.medicine = new Medicine();
        this.quantity = 0;
        this.date = new Date();
        this.supplier = new Supplier();
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
}
