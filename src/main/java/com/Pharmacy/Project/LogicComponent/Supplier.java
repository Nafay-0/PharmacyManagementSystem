package com.Pharmacy.Project.LogicComponent;

public class Supplier {
    int SupplierId;
    String SupplierName;
    String SupplierAddress;
    String SupplierPhone;
    String SupplierEmail;

    public Supplier(int SupplierId, String SupplierName, String SupplierAddress, String SupplierPhone, String SupplierEmail) {
        this.SupplierId = SupplierId;
        this.SupplierName = SupplierName;
        this.SupplierAddress = SupplierAddress;
        this.SupplierPhone = SupplierPhone;
        this.SupplierEmail = SupplierEmail;
    }

    public Supplier() {
        this.SupplierName = "";
        this.SupplierAddress = "";
        this.SupplierPhone = "";
        this.SupplierEmail = "";
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getSupplierAddress() {
        return SupplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        SupplierAddress = supplierAddress;
    }

    public String getSupplierPhone() {
        return SupplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        SupplierPhone = supplierPhone;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        SupplierEmail = supplierEmail;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "SupplierId=" + SupplierId +
                ", SupplierName='" + SupplierName + '\'' +
                ", SupplierAddress='" + SupplierAddress + '\'' +
                ", SupplierPhone='" + SupplierPhone + '\'' +
                ", SupplierEmail='" + SupplierEmail + '\'' +
                '}';
    }
}
