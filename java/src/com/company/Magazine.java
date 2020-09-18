package com.company;

import java.util.ArrayList;

public class Magazine {
    private String magName;
    private Double magazineWeeklyCost;
    private ArrayList<Customer> customer = new ArrayList<Customer>();

    public Magazine() {
        this.setMagName("");
        this.setMagazineWeeklyCost(0.0);
    }

    public Magazine(String magName, Double magazineWeeklyCost, ArrayList<Customer> customer) {
        this.setMagName(magName);
        this.setMagazineWeeklyCost(magazineWeeklyCost);
        this.setCustomer(customer);
    }

    public Magazine(String magName, Double magazineWeeklyCost, Customer customer) {
        this.setMagazineWeeklyCost(magazineWeeklyCost);
        this.setCustomer(customer);
    }

    public String getMagName() {
        return magName;
    }

    public Boolean setMagName(String magName) {
        this.magName = magName;
        return true;
    }

    public Boolean setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
        return true;
    }

    public Boolean setCustomer(Customer customer) {
        this.customer.add(customer);
        return true;
    }

    public ArrayList<Customer> getCustomer() {
        return this.customer;
    }

    public Boolean setMagazineWeeklyCost(Double magazineWeeklyCost) {
        this.magazineWeeklyCost = magazineWeeklyCost;
        return true;
    }

    public Double getMagazineWeeklyCost() {
        return this.magazineWeeklyCost;
    }

    @Override
    public String toString() {
        String str = "Magazine: \n" +
                "magazineWeeklyCost: " + magazineWeeklyCost + '\n' +
                "Customers: " + '\n';
        for (Customer c : this.customer) {
            str = str.concat(c.getName());
            str = str.concat("\n");
        }
        return str;
    }
}
