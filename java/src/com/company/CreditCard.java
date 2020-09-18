package com.company;
import java.util.Date;

public class CreditCard extends PaymentMethod {
    private String creditCardNumber;
    private Date expiry;
    public CreditCard() {
        super();
        creditCardNumber = new String("");
        expiry = new Date();
    }
}
