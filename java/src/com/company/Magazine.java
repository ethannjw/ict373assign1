package com.company;

import java.util.ArrayList;

public class Magazine {
    private Double magazineWeeklyCost;
    private ArrayList<Customer> customer;

    public Magazine() {
        this.magazineWeeklyCost = 0.0;
        this.customer = new ArrayList<Customer>();
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<Customer> getCustomer() {
        return this.customer;
    }

    public void setMagazineWeeklyCost(Double magazineWeeklyCost) {
        this.magazineWeeklyCost = magazineWeeklyCost;
    }

    public Double getMagazineWeeklyCost() {
        return this.magazineWeeklyCost;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "magazineWeeklyCost=" + magazineWeeklyCost +
                ", customer=" + customer +
                '}';
    }
}
