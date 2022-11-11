package com.Pharmacy.Project;

import java.util.Date;

public class Medicine {
    private int MedicineId;
    private int SupplierId;
    private Date expiryDate;

    public Medicine(int MedicineId, int SupplierId, int quantity, Date expiryDate) {
        this.MedicineId = MedicineId;
        this.SupplierId = SupplierId;
        this.expiryDate = expiryDate;
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

}
