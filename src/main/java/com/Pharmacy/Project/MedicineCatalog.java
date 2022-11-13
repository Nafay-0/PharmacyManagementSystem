package com.Pharmacy.Project;

import java.util.ArrayList;

public class MedicineCatalog {
    private ArrayList<MedicineDescription> AvailableMedicines;
    public MedicineCatalog() {
        AvailableMedicines = new ArrayList<MedicineDescription>();
    }
    public void addMedicine(MedicineDescription medicine) {
        AvailableMedicines.add(medicine);
    }
    public void removeMedicine(MedicineDescription medicine) {
        AvailableMedicines.remove(medicine);
    }
};
