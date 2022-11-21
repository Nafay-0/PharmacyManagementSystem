package com.Pharmacy.Project;

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

    public void setMedicineQuantity(int medicineId, int quantity) throws SQLException {
        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineId() == medicineId) {
                medicine.setQuantity(quantity);
            }
        }
        dbHandler db = new mysqlDB();
        db.updateStock(medicineId, quantity);
    }
};
