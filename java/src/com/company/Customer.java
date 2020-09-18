package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    private ArrayList<Supplement> supplements;
    private PayingCustomer payingCustomer;

    public Customer() {
        this.name = "";
        this.email = "";
        this.supplements = new ArrayList<Supplement>();
        this.payingCustomer = new PayingCustomer();
    }

    public Customer(String name, String email, PayingCustomer payer) {
        this.name = name;
        this.email = email;
        this.supplements = new ArrayList<Supplement>();
        this.payingCustomer = payer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setSupplements(ArrayList<Supplement> supplements) {
        this.supplements = supplements;
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
        String str = ("Customer: " + this.name + "\n" +
                "Email: " + this.email + "\n" +
                "Payer: " + this.payingCustomer + "\n" +
                "Supplements: ");
        for (Supplement s : this.supplements) {
            str = (str + s.toString());
            str = (str + "\n");
        }
        return str;
    }
}
