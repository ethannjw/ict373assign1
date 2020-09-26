import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard extends PaymentMethod {
    private String creditCardNumber;
    private LocalDate expiry;

    // Other functional attributes
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");
    private Pattern ccFormat = Pattern.compile("^(\\d{4}[ -]?){4}$");

    public CreditCard() {
        super();
        this.setCreditCardNumber("");
        this.setExpiry(LocalDate.now());
    }
    public CreditCard(String paymentName, String creditCardNumber, LocalDate expiry) {
        super(paymentName);
        this.setCreditCardNumber(creditCardNumber);
        this.setExpiry(expiry);
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public LocalDate getExpiry() {
        return this.expiry;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        Matcher matcher = ccFormat.matcher(creditCardNumber);
        if (matcher.find()) {
            this.creditCardNumber = creditCardNumber;
        } else {
            System.out.println("Invalid email! Try again!");
        }

    }

    public Boolean setExpiry(LocalDate expiry) {
        this.expiry = expiry;
        return true;
    }

    @Override
    public String toString() {
        return super.toString().concat("Credit Card Number: " + creditCardNumber + '\n' +
                "Expiry: " + expiry.format(formatter) + '\n');
    }
}

