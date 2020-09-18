package com.company;

public class PayingCustomer {
    private String payerName;
    private String payerEmail;
    private PaymentMethod paymentMethod;
    private Customer associateCustomer;
    public PayingCustomer() {
        payerName = "";
        payerEmail = "";
        paymentMethod = new PaymentMethod();
        associateCustomer = new Customer();
    }
}
