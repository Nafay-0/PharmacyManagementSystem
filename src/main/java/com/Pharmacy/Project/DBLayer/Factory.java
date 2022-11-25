package com.Pharmacy.Project.DBLayer;

public class Factory {
    static private Factory factory = null;
    static private dbHandler db = null;
    public static Factory getInstance() {
        if (factory == null) {
            factory = new Factory();
        }
        return factory;
    }
    public void createDB(String dbType) {
        if (dbType.equals("mysql")) {
            db = new mysqlDB();
        }
        else{
            db = new FileDb();
        }
    }
}
