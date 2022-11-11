package com.Pharmacy.Project;

import java.util.ArrayList;

public class MedicineCatalog {
   // save arraylist of medicine-description and the quantity
    private ArrayList<MedicineDescription> medicineDescription;
    private ArrayList<Integer> quantity;

    public MedicineCatalog() {
        medicineDescription = new ArrayList<>();
        quantity = new ArrayList<>();
    }

    public void addMedicine(MedicineDescription medicineDescription, int quantity) {
        this.medicineDescription.add(medicineDescription);
        this.quantity.add(quantity);
    }

    public void removeMedicine(MedicineDescription medicineDescription) {
        this.medicineDescription.remove(medicineDescription);
    }

    public ArrayList<MedicineDescription> getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(ArrayList<MedicineDescription> medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }

    public void updateQuantity(MedicineDescription medicineDescription, int quantity) {
        int index = this.medicineDescription.indexOf(medicineDescription);
        this.quantity.set(index, quantity);
    }

    public int getQuantity(MedicineDescription medicineDescription) {
        int index = this.medicineDescription.indexOf(medicineDescription);
        return this.quantity.get(index);
    }

    public MedicineDescription getMedicineDescription(int index) {
        return this.medicineDescription.get(index);
    }

}
