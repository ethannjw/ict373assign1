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
     * Constructor constructs the customer name and email
     * @param custName: String
     * @param custEmail: String
     */
    public PayingCustomer(String custName, String custEmail) {
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
     */
    public boolean setCreditCard(CreditCard creditCard) {
        if (this.paymentMethod != null) {
            if (this.paymentMethod.equals(creditCard)) {
                System.out.println("Payment Method already exists!");
                return false;
            }
        }
        this.paymentMethod = creditCard;
        return true;
    }

    /**
     * Sets the payment method of bank account
     * @param bankAccount: bank account class
     * @return boolean  Returns true if successful, false if not
     */
    public boolean setBankAccount(BankAccount bankAccount) {
        if (this.paymentMethod != null) {
            if (this.paymentMethod.equals(bankAccount)) {
                System.out.println("Payment Method already exists!");
                return false;
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
