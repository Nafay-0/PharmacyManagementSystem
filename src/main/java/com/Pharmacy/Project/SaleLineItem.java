package com.Pharmacy.Project;

public class SaleLineItem {
    private Medicine medicine;
    private int quantity;
    private double price;

    public SaleLineItem(Medicine medicine, int quantity, double price) {
        this.medicine = medicine;
        this.quantity = quantity;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SaleLineItem{" +
                "medicine=" + medicine +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
