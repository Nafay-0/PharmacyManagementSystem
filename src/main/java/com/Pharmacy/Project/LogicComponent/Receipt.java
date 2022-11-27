package com.Pharmacy.Project.LogicComponent;

public class Receipt {
    int ReceiptID;
    int SaleID;

    public Receipt(int ReceiptID, int SaleID) {
        this.ReceiptID = ReceiptID;
        this.SaleID = SaleID;
    }

    public Receipt() {
        this.ReceiptID = 0;
        this.SaleID = 0;
    }

    public int getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(int ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public int getSaleID() {
        return SaleID;
    }

    public void setSaleID(int saleID) {
        SaleID = saleID;
    }
}
