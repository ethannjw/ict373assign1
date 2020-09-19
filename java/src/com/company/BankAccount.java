package com.company;

public class BankAccount extends PaymentMethod {
    private String accountNumber;
    private String bank;

    public BankAccount() {
        super();
        this.setAccountNumber("");
        this.setBank("");
    }
    public BankAccount(String paymentName, String accountNumber, String bank) {
        super(paymentName);
        this.setAccountNumber(accountNumber);
        this.setBank(bank);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}