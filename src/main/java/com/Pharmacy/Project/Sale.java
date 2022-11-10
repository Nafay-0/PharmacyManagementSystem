package com.Pharmacy.Project;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    int SaleId;
    String CustomerName;
    int SaleQuantity;
    ArrayList<Medicine> SaleMedicine;
    int SalePrice;
    Date SaleDate;
    boolean SaleStatus;


    public Sale(int saleId, String customerName, int saleQuantity, ArrayList<Medicine> saleMedicine, int salePrice, Date saleDate, boolean saleStatus) {
        SaleId = saleId;
        CustomerName = customerName;
        SaleQuantity = saleQuantity;
        SaleMedicine = saleMedicine;
        SalePrice = salePrice;
        SaleDate = saleDate;
        SaleStatus = saleStatus;
    }

    public int getSaleId() {
        return SaleId;
    }

    public void setSaleId(int saleId) {
        SaleId = saleId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getSaleQuantity() {
        return SaleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        SaleQuantity = saleQuantity;
    }

    public ArrayList<Medicine> getSaleMedicine() {
        return SaleMedicine;
    }

    public void setSaleMedicine(ArrayList<Medicine> saleMedicine) {
        SaleMedicine = saleMedicine;
    }

    public int getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(int salePrice) {
        SalePrice = salePrice;
    }

    public Date getSaleDate() {
        return SaleDate;
    }

    public void setSaleDate(Date saleDate) {
        SaleDate = saleDate;
    }

    public boolean isSaleStatus() {
        return SaleStatus;
    }

    public void setSaleStatus(boolean saleStatus) {
        SaleStatus = saleStatus;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "SaleId=" + SaleId +
                ", CustomerName='" + CustomerName + '\'' +
                ", SaleQuantity=" + SaleQuantity +
                ", SaleMedicine=" + SaleMedicine +
                ", SalePrice=" + SalePrice +
                ", SaleDate=" + SaleDate +
                ", SaleStatus=" + SaleStatus +
                '}';
    }
}
