package com.Pharmacy.Project.LogicComponent;

import java.util.ArrayList;

public class Ledger {
    ArrayList<Sale> sales = new ArrayList<Sale>();

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public void removeSale(Sale sale) {
        sales.remove(sale);
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    Sale getSale(int id) {
        for (Sale sale : sales) {
            if (sale.getSaleId() == id) {
                return sale;
            }
        }
        return null;
    }
}
