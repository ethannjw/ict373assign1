import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @title       BankAccount
 * @desc        This class inherit from PaymentMethod and implement the bank account number and expiry date
 * @filename    BankAccount.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public class BankAccount extends PaymentMethod {
    private String accountNumber;
    private String bankName;
    private Pattern bankFormat = Pattern.compile("^(\\d{3}[ -]?){3}$");

    /**
     * Constructor constructs the payer name, credit card number  and expiry date
     * @param payerName         Payer name in non zero length string
     * @param accountNumber     String (XXX-XXX-XXX) X: digits only
     * @param bankName              Name of Bank in string
     */
    public BankAccount(String payerName, String accountNumber, String bankName) {
        super(payerName);
        this.setAccountNumber(accountNumber);
        this.setBankName(bankName);
    }
    /**
     * Sets the bank account number
     * @param accountNumber          The bank account number string
     * @return boolean              Returns true if successful, false if not
     */
    public boolean setAccountNumber(String accountNumber) {
        Matcher matcher = bankFormat.matcher(accountNumber);
        if (matcher.find()) {
            this.accountNumber = accountNumber;
            return true;
        } else {
            System.out.println("Invalid Bank account number! Try again!");
            return false;
        }
    }

    /**
     * Sets the bank name
     * @param bankName          The bank name string
     * @return boolean          Returns true if successful, false if not
     */
    public boolean setBankName(String bankName) {
        if (bankName.length() > 0) {
            this.bankName = bankName;
            return true;
        } else {
            System.out.println("Name must be having a length of more than 1! Try again!");
            return false;
        }
    }

    /**
     * Retrieves the bank name
     * @return bank            Name of bank in string
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Retrieves the bank account number
     * @return accountNumber       The bank account number string
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * To string method
     * @return string    String representation of class
     */
    @Override
    public String toString() {
        return super.toString().concat("Bank Account Number: " + accountNumber + '\n' +
                "Bank Name: " + bankName + '\n');
    }
}
