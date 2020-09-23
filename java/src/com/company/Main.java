package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Declare the supplements
        ArrayList<Supplement> supps = new ArrayList<Supplement>();
        Supplement sup1 = new Supplement("Cod Oil", 60.6);
        supps.add(sup1);
        Supplement sup2 = new Supplement("Omega 2", 126.6);
        supps.add(sup2);
        Supplement sup3 = new Supplement("Tonkat Ali", 80.6);
        supps.add(sup3);
        // Declare a customer
        Customer cust1 = new Customer("John Lim", "john.lim@email.com");
        cust1.setSupplements(supps);
        // Declare payment method
        CreditCard cc1 = new CreditCard("John Lim", "1234 5678 9102 1234", LocalDate.now());
        // Declare a payer
        PayingCustomer payer1 = new PayingCustomer("John Doe", "john.doe@email.com", cc1, cust1);
        cust1.setPayingCustomer(payer1);

        // Declare new Magazine
        ArrayList<Magazine> mags = new ArrayList<Magazine>();
        mags.add(new Magazine("Daily News", 2, "This is an email", 12.3));
        Magazine mag2 = new Magazine("Daily Gossips", 1, "This is the email text from Daily Gossips", 12.3);
        mags.add(mag2);
        Magazine mag3 = new Magazine("Daily Shots", 3, "This is an email from Daily Shots", 12.3);
        mags.add(mag3);
        Magazine mag4 = new Magazine("Daily Jumps", 4, "This is an email from Daily Jumps", 12.3);
        mags.add(mag4);

        System.out.println(supps);
        System.out.println(mags);

    }
}
