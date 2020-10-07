/**
 * @title       PaymentMethod
 * @desc        This class is to define an abstract PaymentMethod that contains the name of the payment method holder
 * @filename    PaymentMethod.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public abstract class PaymentMethod {
    private String payerName;

    /**
     * Invalid exception class that tells the user error message on invalid entry
     */
    static class InvalidDetailException extends Exception {
        public InvalidDetailException(String msg) {
            super(msg);
        }
    }

    /**
     * Empty Constructor
     * Initialises the payment method holder name
     */
    public PaymentMethod(){
        payerName = "";
    }

    /**
     * Constructor
     * Initialises the payment method holder name
     * @param payerName           Name of payment method holder in String
     * @throws InvalidDetailException   If name length is zero
     */
    public PaymentMethod(String payerName) throws InvalidDetailException{
        this.setPayerName(payerName);
    }

    /**
     * Retrieves the payer name
     * @return paymentName    The payer name string
     */
    public String getPayerName() {
        return this.payerName;
    }

    /**
     * Sets the payer name
     * @param payerName       The payer name string
     * @return boolean      Returns true if successful, false if not
     * @throws InvalidDetailException   If name is having length zero
     */
    public Boolean setPayerName(String payerName) throws InvalidDetailException{
        if (payerName.length() > 0) {
            this.payerName = payerName;
            return true;
        } else {
            throw new InvalidDetailException("Name must be having a length of more than 1! Try again!");
        }

    }

    /**
     * To string method
     * @return string    String representation of class
     */
    @Override
    public String toString() {
        return "Payer Name: " + payerName + '\n';
    }

    /**
     * Overrides the equals method to check for equality by checking the Name
     * @param otherPaymentMethod     PaymentMethod class to be compared
     * @return boolean    Returns true if both are equals, false if not
     */
    @Override
    public boolean equals(Object otherPaymentMethod) {
        if ( ((PaymentMethod) otherPaymentMethod).getPayerName().equalsIgnoreCase(this.payerName)) {
            return true;
        }
        return false;
    }
}
