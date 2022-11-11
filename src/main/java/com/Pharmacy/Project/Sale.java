package com.Pharmacy.Project;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    int SaleId;
    String CustomerName;
    int TotalPrice;
    Date SaleDate;
    boolean SaleStatus;
    ArrayList<SaleLineItem> SaleLineItems;

    public Sale(int saleId, String customerName, int totalPrice, Date saleDate, boolean saleStatus, ArrayList<SaleLineItem> saleLineItems) {
        SaleId = saleId;
        CustomerName = customerName;
        TotalPrice = totalPrice;
        SaleDate = saleDate;
        SaleStatus = saleStatus;
        SaleLineItems = saleLineItems;
    }

    public Sale(int saleId, String customerName, int totalPrice, Date saleDate, boolean saleStatus) {
        SaleId = saleId;
        CustomerName = customerName;
        TotalPrice = totalPrice;
        SaleDate = saleDate;
        SaleStatus = saleStatus;
        SaleLineItems = new ArrayList<>();
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

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
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

    public ArrayList<SaleLineItem> getSaleLineItems() {
        return SaleLineItems;
    }

    public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
        SaleLineItems = saleLineItems;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "SaleId=" + SaleId +
                ", CustomerName='" + CustomerName + '\'' +
                ", TotalPrice=" + TotalPrice +
                ", SaleDate=" + SaleDate +
                ", SaleStatus=" + SaleStatus +
                ", SaleLineItems=" + SaleLineItems +
                '}';
    }
};

