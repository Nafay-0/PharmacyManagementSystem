package com.Pharmacy.Project;

import java.util.ArrayList;

public class OrderRecord {
    private ArrayList<MedicineOrder> orderList ;

    public OrderRecord() {
        orderList = new ArrayList<MedicineOrder>();
    }
    public void addOrder(MedicineOrder order){
        orderList.add(order);
    }


}
