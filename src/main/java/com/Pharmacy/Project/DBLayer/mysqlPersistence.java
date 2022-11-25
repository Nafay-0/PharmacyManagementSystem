package com.Pharmacy.Project.DBLayer;
import com.Pharmacy.Project.LogicComponent.*;

import java.sql.*;
import java.util.ArrayList;

public class mysqlPersistence extends PersistenceHandler {
    // mysql specific code
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String url = "jdbc:mysql://localhost:3306/Pharmacy";
    private String user = "root";
    private String password = "tiger123";


    @Override
    public Boolean verifyManager(String EmployeeName, String EmployeePassword) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM Manager WHERE EmployeeName = '" + EmployeeName + "' AND EmployeePassword = '" + EmployeePassword + "'";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    public boolean verifyCashier(String EmployeeName, String EmployeePassword) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM Cashier WHERE EmployeeName = '" + EmployeeName + "' AND EmployeePassword = '" + EmployeePassword + "'";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    @Override
    public void insertSales(Sale S) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
           // sale table  = TotalPrice, SaleDate, SaleStatus
            Date date = new Date(System.currentTimeMillis());
            String query = "INSERT INTO Sale (TotalPrice, SaleDate, SaleStatus) VALUES (" + S.getTotalPrice() + ", '" +date + "', " + S.isSaleStatus() + ")";
            System.out.println(query);
            statement.executeUpdate(query);
            // saleItem table = medicineId,quantity,price,SaleId
            query = "SELECT SaleId FROM Sale WHERE SaleDate = '" + date + "'";
            System.out.println(query);
            resultSet = statement.executeQuery(query);
            int SaleId = 0;
            if (resultSet.next()) {
                SaleId = resultSet.getInt("SaleId");
            }
            for (SaleLineItem SI : S.getSaleLineItems()) {
                query = "INSERT INTO SaleLineItem (medicineId,quantity,price,SaleId) VALUES (" + SI.getMedicine().getMedicineId() + ", " + SI.getQuantity() + ", " + SI.getPrice() + ", " + SaleId + ")";
                System.out.println(query);
                statement.executeUpdate(query);
            }
            Receipt R = new Receipt();
            R.setSaleID(SaleId);
            this.writeReceipt(R);


            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }



    @Override
    void addManager(Manager M) {

    }

    @Override
    void addCashier(Cashier c) {

    }

    @Override
    public void  addMedicine(Medicine m, MedicineDescription md) {
        // Medicine MedicineId,quantity
        // MedicineDescription MedicineId,MedicineName,MedicineDescription,Company,price
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String query = "INSERT INTO Medicine (quantity) VALUES (" + m.getQuantity() + ")";
            System.out.println(query);
            statement.executeUpdate(query);

            // get MedicineId of added medicine
            query = "SELECT MedicineId FROM Medicine WHERE MedicineId = (SELECT MAX(MedicineId) FROM Medicine)";
            System.out.println(query);
            resultSet = statement.executeQuery(query);
            int MedicineId = 0;
            if (resultSet.next()) {
                MedicineId = resultSet.getInt("MedicineId");
            }

            query = "INSERT INTO MedicineDescription (MedicineId,MedicineName,MedicineDescription,Company,price) VALUES (" + MedicineId + ", '" + md.getMedicineName() + "', '" + md.getMedicineDescription() + "', '" + md.getCompany() + "', " + md.getPrice() + ")";
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }



    @Override
    void addSupplier(Supplier s) {

    }

    @Override
    void addOrder(MedicineOrder o) {

    }

    @Override
    ArrayList<Medicine> getMedicine() {
        return null;
    }

    @Override
    ArrayList<Manager> getManager() {
        return null;
    }

    @Override
    ArrayList<Cashier> getCashier() {
        return null;
    }

    @Override
    ArrayList<Supplier> getSupplier() {
        return null;
    }

    @Override
    public ArrayList<Supplier> getSupplierforMedicine(Medicine m) throws SQLException {
        // MedicineSuppliers table = MedicineId, SupplierId
        // Supplier table = SupplierId, SupplierName, SupplierAddress, SupplierPhone,SupplierEmail
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM MedicineSuppliers WHERE MedicineId = " + m.getMedicineId();
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        while (resultSet.next()) {
            int SupplierId = resultSet.getInt("SupplierId");
            query = "SELECT * FROM Supplier WHERE SupplierId = " + SupplierId;
            System.out.println(query);
            Statement statement2 = connection.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(query);
            if (resultSet2.next()) {
                Supplier s = new Supplier();
                s.setSupplierId(resultSet2.getInt("SupplierId"));
                s.setSupplierName(resultSet2.getString("SupplierName"));
                s.setSupplierAddress(resultSet2.getString("SupplierAddress"));
                s.setSupplierPhone(resultSet2.getString("SupplierPhone"));
                s.setSupplierEmail(resultSet2.getString("SupplierEmail"));
                suppliers.add(s);
            }
        }
        return suppliers;
    }

    @Override
    ArrayList<Sale> getSales() {
        return null;
    }

    @Override
    ArrayList<MedicineOrder> getOrders() {
        return null;
    }

    @Override
    public ArrayList<Medicine> getAllMedicines() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM Medicine";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        // check if result set is empty
        if (!resultSet.isBeforeFirst()) {
           System.out.println("No data");
        }
        ArrayList<Medicine> medicines = new ArrayList<>();
        // print the result set
        while (resultSet.next()) {
            Medicine medicine = new Medicine();
            medicine.setMedicineId(resultSet.getInt("MedicineId"));
            medicine.setQuantity(resultSet.getInt("quantity"));
            medicines.add(medicine);
        }
        //System.out.println(medicines);
//        // print all the medicines
//        for (Medicine medicine : medicines) {
//            System.out.println(medicine.getMedicineId() + " " + medicine.getQuantity());
//        }

        return medicines;
    }

    @Override
    public MedicineCatalog getMedicineCatalog() throws SQLException {
        ArrayList<Medicine> medicines = getAllMedicines();
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM MedicineDescription";
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        // check if result set is empty
        if (!resultSet.isBeforeFirst()) {
           System.out.println("No data");
        }
        MedicineCatalog medicineCatalog = new MedicineCatalog();
        // get all medicines first

        // get all medicine descriptions
        while (resultSet.next()) {
            MedicineDescription medicineDescription = new MedicineDescription();
            medicineDescription.setMedicineId(resultSet.getInt("MedicineId"));
            medicineDescription.setMedicineName(resultSet.getString("MedicineName"));
            medicineDescription.setPrice(resultSet.getDouble("price"));
            medicineDescription.setCompany(resultSet.getString("Company"));
            Medicine m = new Medicine();
            for (Medicine medicine : medicines) {
                if (medicine.getMedicineId() == medicineDescription.getMedicineId()) {
                    m.setQuantity(medicine.getQuantity());
                    m.setMedicineId(medicine.getMedicineId());
                }
            }
            medicineCatalog.addMedicine(m, medicineDescription);
        }
        // print all the medicines in the catalog
        System.out.println("medicineCatalog");
        for (Medicine medicine : medicineCatalog.getMedicineList()) {
            System.out.println(medicine.getMedicineId() + " " + medicine.getQuantity());
        }
        return medicineCatalog;
    }

    @Override
    public void updateStock(int MedicineId, int Quantity) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "UPDATE Medicine SET Quantity = " + Quantity + " WHERE MedicineId = " + MedicineId;
        System.out.println(query);
        statement.executeUpdate(query);
    }

    @Override
    public void writeReceipt(Receipt r) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        // Receipt table = ReceiptId, SaleID
        String query = "INSERT INTO Receipt (SaleId) VALUES (" + r.getSaleID() + ")";
        System.out.println(query);
        statement.executeUpdate(query);


    }

    @Override
    public Sale getSalefromReceipt(int receiptId) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "SELECT * FROM Receipt WHERE ReceiptId = " + receiptId;
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        Sale sale = new Sale();
        if (resultSet.next()) {
            sale.setSaleId(resultSet.getInt("SaleId"));
        }
        // get Sale from Sale Table
        // Sale Table SaleId, TotalPrice, SaleDate, SaleStatus
        query = "SELECT * FROM Sale WHERE SaleId = " + sale.getSaleId();
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            sale.setTotalPrice(resultSet.getDouble("TotalPrice"));
            sale.setSaleDate(resultSet.getDate("SaleDate"));
            sale.setSaleStatus(Boolean.parseBoolean(resultSet.getString("SaleStatus")));

        }
        // get all SaleItems from SaleLineItem Table
        // SaleLineItem Table itemID,medicineID,quantity,price,SaleId
        ArrayList<SaleLineItem> saleItems = new ArrayList<>();
        query = "SELECT * FROM SaleLineItem WHERE SaleId = " + sale.getSaleId();
        System.out.println(query);
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            SaleLineItem saleItem = new SaleLineItem();
            //saleItem.set(resultSet.getInt("ItemId"));
            int medId = resultSet.getInt("MedicineId");

            Medicine M = new Medicine();
            M.setMedicineId(medId);
            saleItem.setMedicine(M);
            saleItem.setQuantity(resultSet.getInt("Quantity"));
            saleItem.setPrice(resultSet.getDouble("Price"));
            saleItems.add(saleItem);
        }
        sale.setSaleLineItems(saleItems);


        return sale;
    }

    @Override
    public void updateSale(Sale s) throws SQLException {
        // Sale Table SaleId, TotalPrice, SaleDate, SaleStatus
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        String query = "UPDATE Sale SET TotalPrice = " + s.getTotalPrice() + ", SaleDate = '" + s.getSaleDate() + "', SaleStatus = '" + 0 + "' WHERE SaleId = " + s.getSaleId();
        System.out.println(query);
        statement.executeUpdate(query);
        // SaleLineItem Table itemID,medicineId,quantity,price,SaleId
        //UPDATE ALL sale line items for sale
        for (SaleLineItem saleItem : s.getSaleLineItems()) {
            query = "UPDATE SaleLineItem SET Quantity = " + saleItem.getQuantity() + ", Price = " + saleItem.getPrice() + " WHERE SaleId = " + s.getSaleId() + " AND MedicineId = " + saleItem.getMedicine().getMedicineId();
            System.out.println(query);
            statement.executeUpdate(query);
        }


    }

}
