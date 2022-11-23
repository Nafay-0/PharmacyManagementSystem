package com.Pharmacy.Project;

import java.util.ArrayList;

public class Catalogue {
    ArrayList<Medicine> medicines = new ArrayList<Medicine>();

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }
    public void removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
    }
    public Medicine searchMedicine(int MedicineId) {
        for (Medicine medicine : medicines) {
            if (medicine.getMedicineId() == MedicineId) {
                return medicine;
            }
        }
        return null;
    }

   public ArrayList<Medicine>  getUnavailableMedicines() {
        ArrayList<Medicine> unavailableMedicines = new ArrayList<Medicine>();
        for (Medicine medicine : medicines) {
            if (medicine.getQuantity() == 0) {
                unavailableMedicines.add(medicine);
            }
        }
        return unavailableMedicines;
    }



    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

}
