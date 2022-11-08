package com.Pharmacy.Project;

import java.util.Date;

public class MedicineOrder {
    int MedicineId;
    int amount;
    int orderId;
    int SupplierId;
    int PharmacyId;
    int status;
    int total;
    Date date;


    public MedicineOrder(int medicineId, int amount, int orderId, int supplierId, int pharmacyId, int status, int total, Date date) {
        MedicineId = medicineId;
        this.amount = amount;
        this.orderId = orderId;
        SupplierId = supplierId;
        PharmacyId = pharmacyId;
        this.status = status;
        this.total = total;
        this.date = date;
    }

    public int getMedicineId() {
        return MedicineId;
    }

    public int getAmount() {
        return amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public int getPharmacyId() {
        return PharmacyId;
    }

    public int getStatus() {
        return status;
    }

    public int getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public void setMedicineId(int medicineId) {
        MedicineId = medicineId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public void setPharmacyId(int pharmacyId) {
        PharmacyId = pharmacyId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MedicineOrder{" +
                "MedicineId=" + MedicineId +
                ", amount=" + amount +
                ", orderId=" + orderId +
                ", SupplierId=" + SupplierId +
                ", PharmacyId=" + PharmacyId +
                ", status=" + status +
                ", total=" + total +
                ", date=" + date +
                '}';
    }
}
