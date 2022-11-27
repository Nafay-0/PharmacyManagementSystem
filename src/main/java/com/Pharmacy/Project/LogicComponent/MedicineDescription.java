package com.Pharmacy.Project.LogicComponent;

public class MedicineDescription {
    private int MedicineId;
    private String MedicineName;
    private String MedicineDescription;
    private String Company;

    double price;
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
    public String getMedicineDescription() {
        return MedicineDescription;
    }
    public void setMedicineDescription(String medicineDescription) {
        MedicineDescription = medicineDescription;
    }
    public String getCompany() {
        return Company;
    }
    public void setCompany(String company) {
        Company = company;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
