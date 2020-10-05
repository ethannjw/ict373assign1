
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @title       Customer
 * @desc        This class is an abstract class that defines a customer with name, email and ID.
 * @filename    Customer.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public abstract class Customer {
    protected static AtomicInteger nextId = new AtomicInteger();
    protected int custId;
    protected String custName;
    protected String custEmail;

    // email format validation string
    private Pattern emailFormat = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    /**
     * Invalid exception class that tells the user error message on invalid entry
     * @param msg in String
     */
    static class InvalidDetailException extends Exception {
        public InvalidDetailException(String msg) {
            super(msg);
        }
    }

    /**
     * Constructor constructs the customer name and email to empty string
     */
    protected Customer() {
        this.custId = nextId.incrementAndGet();
        this.custName = "";
        this.custEmail = "";
    }

    /**
     * Constructor constructs the customer name and email
     * @param custEmail String of customer email
     * @param custName  String of customer name
     */
    protected Customer(String custName, String custEmail) throws InvalidDetailException {
        this.custId = nextId.incrementAndGet();
        this.setCustName(custName);
        this.setCustEmail(custEmail);
    }

    /**
     * Returns the customer ID
     * @return custId: int
     */
    protected int getCustId() {
        return this.custId;
    }

    /**
     * Sets the customer name
     * @param custName: String
     */
    protected void setCustName(String custName) throws InvalidDetailException {
        if (custName.length() > 0) {
            this.custName = custName;
        } else {
            throw new InvalidDetailException("Name must be having a length of more than 1! Try again!");
        }
    }

    /**
     * Returns the customer name
     * @return custName: String
     */
    protected String getCustName() {
        return this.custName;
    }

    /**
     * Sets the customer email
     * @param custEmail: String
     */
    protected void setCustEmail(String custEmail) throws InvalidDetailException {
        // Check if the email matches email format
        Matcher matcher = emailFormat.matcher(custEmail);
        if (matcher.find()) {
            this.custEmail = custEmail;
        } else {
            throw new InvalidDetailException("Invalid email! Try again!");
        }
    }

    /**
     * Returns the customer email to check for equality by checking the customerid, custNaame and custEmail
     * @return custEmail: String
     */
    protected String getCustEmail() {
        return this.custEmail;
    }

    /**
     * Overrides the equals method to check for equality by checking the custName and custEmail
     * @param otherCustomer AssociateCustomer or PayingCustomer to be compared
     * @return boolean  Returns true if both are equals, false if not
     */
    @Override
    public boolean equals(Object otherCustomer) {
        if (otherCustomer instanceof AssociateCustomer){
            if (!((AssociateCustomer) otherCustomer).getCustName().equalsIgnoreCase(this.getCustName()) && !((AssociateCustomer) otherCustomer).getCustEmail().equalsIgnoreCase(this.getCustEmail())) {
                return false;
            }
        }
        if (otherCustomer instanceof PayingCustomer){
            if (!((PayingCustomer) otherCustomer).getCustName().equalsIgnoreCase(this.getCustName()) && !((PayingCustomer) otherCustomer).getCustEmail().equalsIgnoreCase(this.getCustEmail())) {
                return false;
            }
        }
        return true;
    }
}
