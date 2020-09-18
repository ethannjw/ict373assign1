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
        // Declare a payment method
        CreditCard cc1 = new CreditCard("John Lim", "1234 5678 9102 1234", LocalDate.now());
        // Declare a payer
        PayingCustomer payer1 = new PayingCustomer("John Doe", "john.doe@email.com", cc1, cust1);
        cust1.setPayingCustomer(payer1);

        // Declare new Magazine
        Magazine mag1 = new Magazine("Daily News", 12.6, cust1);

        System.out.println(mag1);
        System.out.println(cust1);
        System.out.println(payer1);
    }
}
