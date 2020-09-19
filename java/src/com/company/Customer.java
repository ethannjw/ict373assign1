package com.company;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static AtomicInteger nextId = new AtomicInteger();
    private int custId;
    private String custName;
    private String custEmail;
    private ArrayList<Supplement> supplements = new ArrayList<Supplement>();
    private PayingCustomer payingCustomer = new PayingCustomer();

    public Customer() {
        this.custId = nextId.incrementAndGet();
        this.setCustName("");
        this.setCustEmail("");
    }

    public Customer(String custName, String custEmail) {
        this.custId = nextId.incrementAndGet();
        this.setCustName(custName);
        this.setCustEmail(custEmail);
    }

    public Customer(String custName, String custEmail, PayingCustomer payer) {
        this.custId = nextId.incrementAndGet();
        this.setCustName(custName);
        this.setCustEmail(custEmail);
        this.setPayingCustomer(payer);
    }

    public Customer(String custName, String custEmail, PayingCustomer payer, ArrayList<Supplement> supplements) {
        this.custId = nextId.incrementAndGet();
        this.setCustName(custName);
        this.setCustEmail(custEmail);
        this.setSupplements(supplements);
        this.setPayingCustomer(payer);
    }

    public Customer(String custName, String custEmail, PayingCustomer payer, Supplement supplements) {
        this.custId = nextId.incrementAndGet();
        this.setCustName(custName);
        this.setCustEmail(custEmail);
        this.setSupplements(supplements);
        this.setPayingCustomer(payer);
    }

    public int getCustId() {
        return this.custId;
    }

    public void setCustName(String name) {
        this.custName = name;
    }

    public String getCustName() {
        return this.custName;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustEmail() {
        return this.custEmail;
    }

    public void setSupplements(ArrayList<Supplement> supplements) {
        this.supplements = supplements;
    }

    public void setSupplements(Supplement supplements) {
        this.supplements.add(supplements);
    }

    public ArrayList<Supplement> getSupplements() {
        return this.supplements;
    }

    public PayingCustomer getPayingCustomer() {
        return this.payingCustomer;
    }

    public void setPayingCustomer(PayingCustomer payingCustomer) {
        this.payingCustomer = payingCustomer;
    }

    public String toString() {
        String str = ("Customer: " + this.custName + "\n" +
                "Email: " + this.custEmail + "\n" +
                "Payer: " + this.payingCustomer.getPayerName() + "\n" +
                "Supplements: \n");
        for (Supplement s : this.supplements) {
            str = str.concat(s.toString());
            str = str.concat("\n");
        }
        return str;
    }
}
