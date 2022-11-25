package com.Pharmacy.Project.LogicComponent;

import com.Pharmacy.Project.DBLayer.dbHandler;
import com.Pharmacy.Project.DBLayer.mysqlDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MedicineCatalog {
    // map of medicine to medicine description
    private ArrayList<Medicine> medicineList;
    // hash map of medicine id to medicine description
    private HashMap<Integer, MedicineDescription> medicineDescriptionMap;

    public MedicineCatalog() {
        medicineList = new ArrayList<Medicine>();
        medicineDescriptionMap = new HashMap<Integer, MedicineDescription>();
    }
    public void addMedicine(Medicine medicine , MedicineDescription description) {
        medicineList.add(medicine);
        medicineDescriptionMap.put(medicine.getMedicineId(), description);
    }
    public void removeMedicine(Medicine medicine) {
        medicineList.remove(medicine);
        medicineDescriptionMap.remove(medicine.getMedicineId());
    }
    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }

    public MedicineDescription getMedicineDescription(int medicineId) {
        return medicineDescriptionMap.get(medicineId);
    }

    public int getMedicineQuantity(int medicineId) {
        Medicine Medicine = new Medicine();
        for (Medicine m : medicineList) {
            if (m.getMedicineId() == medicineId) {
                Medicine = m;
            }
        }
        return Medicine.getQuantity();
    }
    public void setMedicineQuantity(int medicineId, int quantity) throws SQLException {
        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineId() == medicineId) {
                medicine.setQuantity(quantity);
            }
        }
        dbHandler db = new mysqlDB();
        db.updateStock(medicineId, quantity);
    }
    public ArrayList<Medicine> getUnavailableMedicine() {
        ArrayList<Medicine> UnavlMed = new ArrayList<Medicine>();
        for (Medicine medicine : medicineList) {
            if (medicine.getQuantity() == 0) {
                UnavlMed.add(medicine);
            }
        }
        return UnavlMed;
    }

};
