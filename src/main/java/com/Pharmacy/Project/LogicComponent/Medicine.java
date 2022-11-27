package com.Pharmacy.Project.LogicComponent;

import java.util.ArrayList;

public class Medicine {
    private int MedicineId;
    private ArrayList<Supplier> suppliers;
    int quantity;

    public Medicine(int MedicineId, int quantity, ArrayList<Supplier> suppliers) {
        this.MedicineId = MedicineId;
        this.quantity = quantity;
        this.suppliers = suppliers;
    }
    public Medicine(){
        this.MedicineId = 0;
        this.quantity = 0;
        this.suppliers = new ArrayList<Supplier>();
    }

    public int getMedicineId() {
        return MedicineId;
    }

    public void setMedicineId(int MedicineId) {
        this.MedicineId = MedicineId;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
    public void addSupplier(Supplier supplier){
        this.suppliers.add(supplier);
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ArrayList<Supplier> getSupplierID() {
        return suppliers;
    }

}
