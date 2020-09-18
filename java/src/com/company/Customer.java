package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    private ArrayList<Supplement> supplements;
    private PayingCustomer payingCustomer;

    public Customer() {
        this.setName("");
        this.setEmail("");
        this.setSupplements(new ArrayList<Supplement>());
        this.setPayingCustomer(new PayingCustomer());
    }

    public Customer(String name, String email) {
        this.setName(name);
        this.setEmail(email);
        this.setSupplements(new ArrayList<Supplement>());
        this.setPayingCustomer(new PayingCustomer());
    }

    public Customer(String name, String email, PayingCustomer payer) {
        this.setName(name);
        this.setEmail(email);
        this.setSupplements(new ArrayList<Supplement>());
        this.setPayingCustomer(payer);
    }

    public Customer(String name, String email, PayingCustomer payer, ArrayList<Supplement> supplements) {
        this.setName(name);
        this.setEmail(email);
        this.setSupplements(supplements);
        this.setPayingCustomer(payer);
    }

    public Customer(String name, String email, PayingCustomer payer, Supplement supplements) {
        this.setName(name);
        this.setEmail(email);
        this.setSupplements(supplements);
        this.setPayingCustomer(payer);
    }

    public Boolean setName(String name) {
        this.name = name;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public Boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean setSupplements(ArrayList<Supplement> supplements) {
        this.supplements = supplements;
        return true;
    }

    public Boolean setSupplements(Supplement supplements) {
        this.supplements.add(supplements);
        return true;
    }

    public ArrayList<Supplement> getSupplements() {
        return this.supplements;
    }

    public PayingCustomer getPayingCustomer() {
        return this.payingCustomer;
    }

    public Boolean setPayingCustomer(PayingCustomer payingCustomer) {
        this.payingCustomer = payingCustomer;
        return true;
    }

    public String toString() {
        String str = ("Customer: " + this.name + "\n" +
                "Email: " + this.email + "\n" +
                "Payer: " + this.payingCustomer.getPayerName() + "\n" +
                "Supplements: \n");
        for (Supplement s : this.supplements) {
            str = str.concat(s.toString());
            str = str.concat("\n");
        }
        return str;
    }
}
