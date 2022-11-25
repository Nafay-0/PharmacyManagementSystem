package com.Pharmacy.Project.DBLayer;

public class Factory {
    static private Factory factory = null;
    public static Factory getInstance() {
        if (factory == null) {
            factory = new Factory();
        }
        return factory;
    }
    public PersistenceHandler getDBhandler(String type) {
        PersistenceHandler db = null;
        if (type.equals("mysql")) {
            db = new mysqlPersistence();
        } else if (type.equals("file")) {
            db = new FilePersistence();
        }
        return db;
    }
}
