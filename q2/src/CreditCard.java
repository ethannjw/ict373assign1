import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @title       CreditCard
 * @desc        This class is to inherit from PaymentMethod and implement the credit card number and expiry date
 * @filename    CreditCard.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public class CreditCard extends PaymentMethod {
    private String creditCardNumber;
    private LocalDate expiry;

    // Other functional attributes
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
    private Pattern ccFormat = Pattern.compile("^(\\d{4}[ -]?){4}$");

    /**
     * Empty Constructor
     * Initialises the payment method holder name
     * @param name  The name of owner of credit card
     * @throws PaymentMethod.InvalidDetailException If any validation fail, such as name is empty
     */
    public CreditCard(String name) throws InvalidDetailException {
        super(name);
        creditCardNumber = "";
        this.setExpiry(LocalDate.of(3000,1,1));
    }
    /**
     * Constructor constructs the payer name, credit card number  and expiry date
     * @param payerName         Payer name in non zero length string
     * @param creditCardNumber  String (XXXX-XXXX-XXXX-XXXX) X: digits only
     * @param expiry            LocalDate, usage, LocalDate.of(2023, 5, 1)
     * @throws PaymentMethod.InvalidDetailException Upon Validation fail
     */
    public CreditCard(String payerName, String creditCardNumber, LocalDate expiry) throws InvalidDetailException{
        super(payerName);
        this.setCreditCardNumber(creditCardNumber);
        this.setExpiry(expiry);
    }
    /**
     * Retrieves the credit card number
     * @return creditCardNumber       The credit card number string
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Retrieves the expiry date
     * @return expiry            LocalDate class of credit card expiry date
     */
    public LocalDate getExpiry() {
        return this.expiry;
    }

    /**
     * Sets the credit card number
     * @param creditCardNumber       The credit card number string
     * @return boolean      Returns true if successful, false if not
     * @throws PaymentMethod.InvalidDetailException If credit card format incorrect
     */
    public boolean setCreditCardNumber(String creditCardNumber) throws InvalidDetailException {
        Matcher matcher = ccFormat.matcher(creditCardNumber);
        if (matcher.find()) {
            this.creditCardNumber = creditCardNumber;
            return true;
        } else {
            throw new InvalidDetailException("Invalid credit card number! Format is XXXX-XXXX-XXXX-XXXX X: digits only");
        }
    }

    /**
     * Sets the expiry date that must be in the future
     * @param expiry        The expiry date LocalDate
     * @return boolean      Returns true if successful, false if not
     * @throws PaymentMethod.InvalidDetailException If the expiry date is before today
     */
    public Boolean setExpiry(LocalDate expiry) throws InvalidDetailException{
        LocalDate today = LocalDate.now();
        if (expiry.isBefore(today) | expiry.equals(today)) {
            throw new InvalidDetailException("Expiry date must be in the future!");

        } else {
            this.expiry = expiry;
            return true;
        }

    }

    /**
     * To string method
     * @return string    String representation of class
     */
    @Override
    public String toString() {
        return super.toString().concat("Credit Card Number: " + creditCardNumber + '\n' +
                "Expiry: " + expiry.format(formatter) + '\n');
    }
}

