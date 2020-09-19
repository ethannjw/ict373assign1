package com.company;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Magazine {
    private static AtomicInteger nextId = new AtomicInteger();
    private int magId;
    private String magName;
    private int magWeek;
    private String magEmailContent;
    private double magWeeklyCost;
    private ArrayList<Customer> customer = new ArrayList<Customer>();

    public Magazine() {
        this.magId = nextId.incrementAndGet();
        this.setMagName("");
    }

    public Magazine(String magName, int magWeek) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeek(magWeek);
    }

    public Magazine(String magName, int magWeek, String magEmailContent) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeek(magWeek);
        this.setMagEmailContent(magEmailContent);
    }

    public Magazine(String magName, int magWeek, String magEmailContent, double magWeeklyCost) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeek(magWeek);
        this.setMagEmailContent(magEmailContent);
        this.setMagWeeklyCost(magWeeklyCost);
    }

    public Magazine(String magName, int magWeek, String magEmailContent, double magWeeklyCost, Customer customer) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeek(magWeek);
        this.setMagEmailContent(magEmailContent);
        this.setMagWeeklyCost(magWeeklyCost);
        this.setCustomer(customer);
    }

    public Magazine(String magName, int magWeek, String magEmailContent, double magWeeklyCost, ArrayList<Customer> customer) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeeklyCost(magWeek);
        this.setMagEmailContent(magEmailContent);
        this.setMagWeeklyCost(magWeeklyCost);
        this.setCustomer(customer);
    }

    // magName
    public String getMagName() {
        return magName;
    }

    public Boolean setMagName(String magName) {
        this.magName = magName;
        return true;
    }

    // magWeek
    public int getMagWeek() {
        return magWeek;
    }

    public void setMagWeek(int magWeek) {
        this.magWeek = magWeek;
    }

    // magEmailContent
    public String getMagEmailContent() {
        return magEmailContent;
    }

    public void setMagEmailContent(String magEmailContent) {
        this.magEmailContent = magEmailContent;
    }

    // magWeeklyCost
    public void setMagWeeklyCost(double magazineWeeklyCost) {
        this.magWeeklyCost = magazineWeeklyCost;
    }

    public double getMagWeeklyCost() {
        return this.magWeeklyCost;
    }

    // customers
    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public void setCustomer(Customer customer) {
        this.customer.add(customer);
    }

    public ArrayList<Customer> getCustomer() {
        return this.customer;
    }

    @Override
    public String toString() {
        String str = "Magazine: \n" +
                "magazine ID: " + magId + '\n' +
                "magazine Name: " + magName + '\n' +
                "magazine Week: " + magWeek + '\n' +
                "magezine Email Content: " + magEmailContent + '\n' +
                "magazine Weekly Cost: $" + magWeeklyCost + '\n' +
                "Customers: " + '\n';
        for (Customer c : this.customer) {
            str = str.concat(c.getName());
            str = str.concat("\n");
        }
        return str;
    }
}
