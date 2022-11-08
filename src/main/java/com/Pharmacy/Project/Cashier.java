package com.Pharmacy.Project;

public class Cashier {
    int EmployeeID;
    String EmployeeName;
    String EmployeeAddress;
    String EmployeePhone;
    String EmployeePassword;

    public Cashier(int employeeID, String employeeName, String employeeAddress, String employeePhone, String employeePassword) {
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        EmployeeAddress = employeeAddress;
        EmployeePhone = employeePhone;
        EmployeePassword = employeePassword;
    }


    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return EmployeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        EmployeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return EmployeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        EmployeePhone = employeePhone;
    }

    public String getEmployeePassword() {
        return EmployeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        EmployeePassword = employeePassword;
    }
}
