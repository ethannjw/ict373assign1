package com.company;

import java.util.ArrayList;

public class PayingCustomer {
    private String payerName;
    private String payerEmail;
    private PaymentMethod paymentMethod;
    private ArrayList<Customer> associateCustomer = new ArrayList<Customer>();
    public PayingCustomer() {
        this.setPayerName("");
        this.setPayerEmail("");
        this.setPaymentMethod(new PaymentMethod());
    }

    public PayingCustomer(String payerName, String payerEmail) {
        this.setPayerName(payerName);
        this.setPayerEmail(payerEmail);
        this.setPaymentMethod(new PaymentMethod());
    }

    public PayingCustomer(String payerName, String payerEmail, PaymentMethod paymentMethod) {
        this.setPayerName(payerName);
        this.setPayerEmail(payerEmail);
        this.setPaymentMethod(paymentMethod);
    }

    public PayingCustomer(String payerName, String payerEmail, PaymentMethod paymentMethod, Customer associateCustomer) {
        this.setPayerName(payerName);
        this.setPayerEmail(payerEmail);
        this.setPaymentMethod(paymentMethod);
        this.setAssociateCustomer(associateCustomer);
    }

    public PayingCustomer(String payerName, String payerEmail, PaymentMethod paymentMethod, ArrayList<Customer> associateCustomer) {
        this.setPayerName(payerName);
        this.setPayerEmail(payerEmail);
        this.setPaymentMethod(paymentMethod);
        this.setAssociateCustomer(associateCustomer);
    }

    public String getPayerName() {
        return this.payerName;
    }

    public Boolean setPayerName(String payerName) {
        this.payerName = payerName;
        return true;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public Boolean setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
        return true;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Boolean setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return true;
    }

    public Boolean setAssociateCustomer(ArrayList<Customer> associateCustomer) {
        this.associateCustomer = associateCustomer;
        return true;
    }

    public Boolean setAssociateCustomer(Customer associateCustomer) {
        this.associateCustomer.add(associateCustomer);
        return true;
    }
    public ArrayList<Customer> getAssociateCustomer() {
        return associateCustomer;
    }

    @Override
    public String toString() {
        String str = "PayingCustomer: \n" +
                "payerName:" + payerName + '\n' +
                "payerEmail: " + payerEmail + '\n' +
                "paymentMethod: \n" + paymentMethod + '\n' +
                "associateCustomers: \n";
        for (Customer c : this.associateCustomer) {
            str = str.concat(c.getName());
            str = str.concat("\n");
        }
        return str;
    }
}
