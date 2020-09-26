
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

    // Other functional attributes
    private Pattern emailFormat = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    /**
     * Constructor constructs the customer name and email
     * @param custEmail: String
     * @param custName: String
     */
    protected Customer(String custName, String custEmail) {
        this.custId = nextId.incrementAndGet();

        try {
            this.setCustName(custName);
            this.setCustEmail(custEmail);
        }
        catch (Exception e) {
            System.out.println(e);
        }
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
    protected void setCustName(String custName) throws Exception{
        if (custName.length() > 0) {
            this.custName = custName;
        } else {
            throw new Exception("Name must be having a length of more than 1! Try again!");
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
    protected void setCustEmail(String custEmail) {
        // Check if the email matches email format
        Matcher matcher = emailFormat.matcher(custEmail);
        if (matcher.find()) {
            this.custEmail = custEmail;
        } else {
            System.out.println("Invalid email! Try again!");
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
     * Overrides the equals method to check for equality by checking the customerid, custNaame and custEmail
     * @param otherCustomer: AssociateCustomer
     * @return boolean
     */
    @Override
    public boolean equals(Object otherCustomer) {
        if (otherCustomer instanceof AssociateCustomer){
            if (((AssociateCustomer) otherCustomer).getCustId() == this.getCustId()) {
                return true;
            }
            if (((AssociateCustomer) otherCustomer).getCustName() == this.getCustName() && ((AssociateCustomer) otherCustomer).getCustEmail() == this.getCustEmail()) {
                return true;
            }
        }
        if (otherCustomer instanceof PayingCustomer){
            if (((PayingCustomer) otherCustomer).getCustId() == this.getCustId()) {
                return true;
            }
            if (((PayingCustomer) otherCustomer).getCustName() == this.getCustName() && ((PayingCustomer) otherCustomer).getCustEmail() == this.getCustEmail()) {
                return true;
            }
        }
        return false;
    }
}
