import java.util.ArrayList;

/**
 * @title       PayingCustomer
 * @desc        This class is a on implementation of customer class that adds a list of associate customers
 *              and the payment method
 * @filename    PayingCustomer.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public class PayingCustomer extends Customer {

    private PaymentMethod paymentMethod;
    private ArrayList<Integer> associateCustomers = new ArrayList<Integer>();

    /**
     * Empty Constructor initialises the customer
     */
    public PayingCustomer() {
        super();
    }
    /**
     * Constructor constructs the customer name and email
     * @param custName: String
     * @param custEmail: String
     * @throws Customer.InvalidDetailException  Upon error
     */
    public PayingCustomer(String custName, String custEmail) throws InvalidDetailException{
        super(custName, custEmail);
    }

    /**
     * Returns the payment method
     * @return paymentMethod: payment method
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method of credit card
     * @param creditCard    CreditCard class
     * @return boolean  Returns true if successful, false if not
     * @throws Customer.InvalidDetailException  If the payment method already exists
     */
    public boolean setCreditCard(CreditCard creditCard) throws InvalidDetailException {
        if (this.paymentMethod != null) {
            if (this.paymentMethod.equals(creditCard)) {
                throw new InvalidDetailException("Payment Method already exists!");
            }
        }
        this.paymentMethod = creditCard;
        return true;
    }

    /**
     * Sets the payment method of bank account
     * @param bankAccount: bank account class
     * @return boolean  Returns true if successful, false if not
     * @throws Customer.InvalidDetailException  If the payment method already exists
     */
    public boolean setBankAccount(BankAccount bankAccount) throws InvalidDetailException{
        if (this.paymentMethod != null) {
            if (this.paymentMethod.equals(bankAccount)) {
                throw new InvalidDetailException("Payment Method already exists!");
            }
        }
        this.paymentMethod = bankAccount;
        return true;

    }

    /**
     * Adds an Associate Customer
     * @param associateCustomer AssociateCustomer
     * @return boolean  Returns true if successful, false if not
     */
    public boolean setAssociateCustomer(AssociateCustomer associateCustomer)  {
        int addId = associateCustomer.getCustId();
        for (Integer custId : this.associateCustomers) {
            if (custId == addId) {
                System.out.println("Duplicate associate customer! Cannot insert");
                return false;
            }
        }
        this.associateCustomers.add(addId);
        return true;
    }

    /**
     * Returns the list of associate customers
     * @return paymentMethod    payment method
     */
    public ArrayList<Integer> getAssociateCustomers() {
        return associateCustomers;
    }
}
