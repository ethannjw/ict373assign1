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
        this.setPaymentMethod(new PaymentMethod());
    }

    /**
     * Returns the payment method
     * @return paymentMethod: payment method
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method
     * @param paymentMethod: payment method
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        if (this.paymentMethod == paymentMethod) {
            System.out.println("Payment Method already exists!");
            return;
        }
        this.paymentMethod = paymentMethod;

    }

    /**
     * Adds an Associate Customer
     * @param associateCustomer: AssociateCustomer
     */
    public void setAssociateCustomer(AssociateCustomer associateCustomer)  {
        int addId = associateCustomer.getCustId();
        for (Integer custId : this.associateCustomers) {
            if (custId == addId) {
                System.out.println("Duplicate associate customer! Cannot insert");
                return;
            }
        }
        this.associateCustomers.add(addId) ;
    }
    /**
     * Returns the list of associate customers
     * @return paymentMethod: payment method
     */
    public ArrayList<Integer> getAssociateCustomers() {
        return associateCustomers;
    }
}
