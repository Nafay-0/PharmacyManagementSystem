package com.Pharmacy.Project;

public class MedicineDescription {
    private int MedicineId;
    private String MedicineName;
    private String MedicineType;
    private String MedicineDescription;
    private String Manufacturer;

    public int getMedicineId() {
        return MedicineId;
    }
    public void setMedicineId(int medicineId) {
        MedicineId = medicineId;
    }
    public String getMedicineName() {
        return MedicineName;
    }
    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }
    public String getMedicineType() {
        return MedicineType;
    }
    public void setMedicineType(String medicineType) {
        MedicineType = medicineType;
    }
    public String getMedicineDescription() {
        return MedicineDescription;
    }
    public void setMedicineDescription(String medicineDescription) {
        MedicineDescription = medicineDescription;
    }
    public String getManufacturer() {
        return Manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

}
