package com.company;

public class PaymentMethod {
    private String paymentName;
    public PaymentMethod() {
        paymentName = "";
    }
    public String getPaymentName() {
        return this.paymentName;
    }
    public Boolean setPaymentName(String val) {
        this.paymentName = val;
        return true;
    }
}
