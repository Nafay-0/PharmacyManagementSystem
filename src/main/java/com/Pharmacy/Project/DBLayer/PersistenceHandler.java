package com.Pharmacy.Project.DBLayer;

public class PersistenceHandler {
    static private PersistenceHandler persistenceHandler = null;
    static private dbHandler db = null;
    public static PersistenceHandler getInstance() {
        if (persistenceHandler == null) {
            persistenceHandler = new PersistenceHandler();
        }
        return persistenceHandler;
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
