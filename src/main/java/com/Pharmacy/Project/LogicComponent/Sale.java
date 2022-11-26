package com.Pharmacy.Project.LogicComponent;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    int SaleId;
    String CustomerName;
    double TotalPrice;
    Date SaleDate;
    boolean SaleStatus;
    ArrayList<SaleLineItem> SaleLineItems;

    public Sale(){
        SaleLineItems = new ArrayList<>();
    }
    public Sale(int saleId, String customerName, int totalPrice, Date saleDate, boolean saleStatus, ArrayList<SaleLineItem> saleLineItems) {
        SaleId = saleId;
        CustomerName = customerName;
        TotalPrice = totalPrice;
        SaleDate = saleDate;
        SaleStatus = saleStatus;
        SaleLineItems = saleLineItems;
    }
    public void addSaleLineItem(Medicine M, int quantity, double price)
    {
        SaleLineItem saleLineItem = new SaleLineItem(M, quantity, price);
        SaleLineItems.add(saleLineItem);
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

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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

    public double getTotalPriceOfSale()
    {
        double totalPrice = 0;
        for (SaleLineItem saleLineItem : SaleLineItems) {
            totalPrice += saleLineItem.getPrice();
        }
        return totalPrice;
    }


    @Override
    public String toString() {
        return  SaleId  + " \t\t " + TotalPrice + " \t\t " +  SaleDate ;
    }
};

