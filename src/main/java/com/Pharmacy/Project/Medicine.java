package com.Pharmacy.Project;

import java.util.Date;

public class Medicine {
    private int MedicineId;
    private int SupplierId;
    int quantity;

    public Medicine(int MedicineId, int SupplierId, int quantity, Date expiryDate) {
        this.MedicineId = MedicineId;
        this.SupplierId = SupplierId;
        this.quantity = quantity;
    }

    public int getMedicineId() {
        return MedicineId;
    }

    public void setMedicineId(int MedicineId) {
        this.MedicineId = MedicineId;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int SupplierId) {
        this.SupplierId = SupplierId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
