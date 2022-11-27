package com.Pharmacy.Project.LogicComponent;

public class Payment {
    private int paymentId;
    private int paymentAmount;
    private String paymentDate;
    private String paymentType;
    private int paymentStatus;
    private int paymentOrderId;
    private int paymentSalesId;
    public int getPaymentSalesId() {
        return paymentSalesId;
    }

    public void setPaymentSalesId(int paymentSalesId) {
        this.paymentSalesId = paymentSalesId;
    }



    public Payment(){
        paymentId = 0;
        paymentAmount = 0;
        paymentDate = "";
        paymentType = "";
        paymentStatus = 0;
        paymentOrderId = 0;
        paymentSalesId = 0;

    }
    public Payment(int paymentId, int paymentAmount, String paymentDate, String paymentType, int paymentStatus, int paymentOrderId) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.paymentOrderId = paymentOrderId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(int paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }
}
