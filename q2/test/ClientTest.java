import java.lang.management.ManagementFactory;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        client = new Client();
    }

    /**
     * Test case for part C: print out the text of all the emails for all customers for four weeks of magazines
     */
    @org.junit.jupiter.api.Test
    void printWeeklyEmails() {
        String testStr = "Magazine: Programming Magazine\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: john.lim@email.com\n" +
                "Subject:\n" +
                "\tJohn Lim, your Weekly Magazine Programming Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear John Lim,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: jayne.petersen@email.com\n" +
                "Subject:\n" +
                "\tJayne Petersen, your Weekly Magazine Programming Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Jayne Petersen,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: brian.meadows@email.com\n" +
                "Subject:\n" +
                "\tBrian Meadows, your Weekly Magazine Programming Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Brian Meadows,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tGo Lang!\n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: Chloe-Ann@email.com\n" +
                "Subject:\n" +
                "\tChloe-Ann Manning, your Weekly Magazine Programming Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Chloe-Ann Manning,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tWooHoo\n" +
                "\n" +
                "Magazine: Cooking Magazine\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: john.lim@email.com\n" +
                "Subject:\n" +
                "\tJohn Lim, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear John Lim,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: jayne.petersen@email.com\n" +
                "Subject:\n" +
                "\tJayne Petersen, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Jayne Petersen,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: brian.meadows@email.com\n" +
                "Subject:\n" +
                "\tBrian Meadows, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Brian Meadows,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tGo Lang!\n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: Chloe-Ann@email.com\n" +
                "Subject:\n" +
                "\tChloe-Ann Manning, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Chloe-Ann Manning,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tWooHoo\n" +
                "\n" +
                "Magazine: Exercise Magazine\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: john.lim@email.com\n" +
                "Subject:\n" +
                "\tJohn Lim, your Weekly Magazine Exercise Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear John Lim,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: jayne.petersen@email.com\n" +
                "Subject:\n" +
                "\tJayne Petersen, your Weekly Magazine Exercise Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Jayne Petersen,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: brian.meadows@email.com\n" +
                "Subject:\n" +
                "\tBrian Meadows, your Weekly Magazine Exercise Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Brian Meadows,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tGo Lang!\n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: Chloe-Ann@email.com\n" +
                "Subject:\n" +
                "\tChloe-Ann Manning, your Weekly Magazine Exercise Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Chloe-Ann Manning,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tWooHoo\n" +
                "\n" +
                "Magazine: Empty Magazine\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: john.lim@email.com\n" +
                "Subject:\n" +
                "\tJohn Lim, your Weekly Magazine Empty Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear John Lim,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: jayne.petersen@email.com\n" +
                "Subject:\n" +
                "\tJayne Petersen, your Weekly Magazine Empty Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Jayne Petersen,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: brian.meadows@email.com\n" +
                "Subject:\n" +
                "\tBrian Meadows, your Weekly Magazine Empty Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Brian Meadows,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tGo Lang!\n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: Chloe-Ann@email.com\n" +
                "Subject:\n" +
                "\tChloe-Ann Manning, your Weekly Magazine Empty Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Chloe-Ann Manning,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tWooHoo\n" +
                "\n";
        assertEquals(testStr, client.getMagService().printWeeklyEmails());
    }
    /**
     * Test case for part C: print out the text of all the emails for one customer for four weeks of magazines
     */
    @org.junit.jupiter.api.Test
    void printWeeklyEmail() {
        Magazine testMag = new Magazine("Cooking Magazine", 12.20);
        String testStr = "Magazine: Cooking Magazine\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: john.lim@email.com\n" +
                "Subject:\n" +
                "\tJohn Lim, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear John Lim,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: jayne.petersen@email.com\n" +
                "Subject:\n" +
                "\tJayne Petersen, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Jayne Petersen,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: brian.meadows@email.com\n" +
                "Subject:\n" +
                "\tBrian Meadows, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Brian Meadows,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tGo Lang!\n" +
                "\t\tJava Rocks\n" +
                "\t\tThe Grind\n" +
                "\t\tWooHoo\n" +
                "\n" +
                "From: customerservice@scammagazines.com\n" +
                "Recipient: Chloe-Ann@email.com\n" +
                "Subject:\n" +
                "\tChloe-Ann Manning, your Weekly Magazine Cooking Magazine is ready for viewing!\n" +
                "Content:\n" +
                "Dear Chloe-Ann Manning,\n" +
                "\tPlease follow the following link to view your magazine: \n" +
                "\twww.tinyurl.com/fakeurl \n" +
                "\tAlong with your supplements: \n" +
                "\t\tWooHoo\n" +
                "\n";
        assertEquals(testStr, client.getMagService().printWeeklyEmail(testMag));
    }
    /**
     * Test case for part D: print out the text for the end of month emails for the paying customers
     */
    @org.junit.jupiter.api.Test
    void printMonthlyEmails() {
        String testStr = "From: billing@scammagazines.com\n" +
                "Recipient: john.doe@email.com\n" +
                "Subject:\n" +
                "\tJohn Lim, your bill for this month is ready for viewing!\n" +
                "Content:\n" +
                "Dear John Lim,\n" +
                "\tHere is a list of customers you paying for: \n" +
                "\tCustomer: John Lim\n" +
                "\t\tJava Rocks Cost: $32.32\n" +
                "\t\tWooHoo Cost: $12.3\n" +
                "\tFor this month: \n" +
                "\tTotal subscription bill (main magazine part): $48.8\n" +
                "\tTotal Bill: $93.42\n" +
                "\tPayment will be deducted end of the month from credit card:\n" +
                "\t\tCredit Card Holder Name: Lim Swee Keat\n" +
                "\t\tCredit Card Number: 1234 5678 9102 1234\n" +
                "\t\tCredit Card Expiry: 2023-05-01\n" +
                "\n" +
                "From: billing@scammagazines.com\n" +
                "Recipient: petersen@email.com\n" +
                "Subject:\n" +
                "\tJayne Petersen, your bill for this month is ready for viewing!\n" +
                "Content:\n" +
                "Dear Jayne Petersen,\n" +
                "\tHere is a list of customers you paying for: \n" +
                "\tCustomer: Jayne Petersen\n" +
                "\t\tJava Rocks Cost: $32.32\n" +
                "\t\tThe Grind Cost: $2.5\n" +
                "\tFor this month: \n" +
                "\tTotal subscription bill (main magazine part): $48.8\n" +
                "\tTotal Bill: $83.62\n" +
                "\tPayment will be deducted end of the month from credit card:\n" +
                "\t\tCredit Card Holder Name: Tim Petersen\n" +
                "\t\tCredit Card Number: 1234 9851 4592 1984\n" +
                "\t\tCredit Card Expiry: 2024-01-01\n" +
                "\n" +
                "From: billing@scammagazines.com\n" +
                "Recipient: burnett@email.com\n" +
                "Subject:\n" +
                "\tAlan Burnett, your bill for this month is ready for viewing!\n" +
                "Content:\n" +
                "Dear Alan Burnett,\n" +
                "\tHere is a list of customers you paying for: \n" +
                "\tCustomer: Brian Meadows\n" +
                "\t\tGo Lang! Cost: $2.34\n" +
                "\t\tJava Rocks Cost: $32.32\n" +
                "\t\tThe Grind Cost: $2.5\n" +
                "\t\tWooHoo Cost: $12.3\n" +
                "\tCustomer: Chloe-Ann Manning\n" +
                "\t\tWooHoo Cost: $12.3\n" +
                "\tFor this month: \n" +
                "\tTotal subscription bill (main magazine part): $97.6\n" +
                "\tTotal Bill: $159.35999999999999\n" +
                "\tPayment will be deducted end of the month from bank account:\n" +
                "\t\tAccount Holder Name: Alan Burnett\n" +
                "\t\tBank Name: ABC Bank\n" +
                "\t\tBank Account Number: 123-567-981\n" +
                "\n";
        assertEquals(testStr, client.getMagService().printMonthlyEmails());
    }

    /**
     * Test case for magazine class
     */
    @org.junit.jupiter.api.Test
    void testMagazine() {
        Magazine testMag = new Magazine("test Magazine", 123.3);

        // test get magazine name
        assertEquals("test Magazine", testMag.getMagName());

        // test get magazine weekly cost
        assertEquals(123.3, testMag.getMagWeeklyCost());

        // test invalid name
        assertFalse(testMag.setMagName(""));

        // test invalid float
        assertFalse(testMag.setMagWeeklyCost(-1.3));    // negative
        assertFalse(testMag.setMagWeeklyCost((double)0));   // zero
    }

    /**
     * Test case for supplement class
     */
    @org.junit.jupiter.api.Test
    void testSupplement() {
        Supplement testSupp = new Supplement("test Supplement", 123.3);

        // test get supplement name
        assertEquals("test Supplement", testSupp.getSuppName());

        // test get supplement weekly cost
        assertEquals(123.3, testSupp.getSupplementWeeklyCost());

        // test invalid name
        assertFalse(testSupp.setSuppName(""));

        // test invalid float
        assertFalse(testSupp.setSupplementWeeklyCost(-1.3));    // negative
        assertFalse(testSupp.setSupplementWeeklyCost((double)0));   // zero
    }

    /**
     * Test case for paying customer class
     */
    @org.junit.jupiter.api.Test
    void testPaymentMethod() throws PaymentMethod.InvalidDetailException {
        LocalDate testLocalDate = LocalDate.of(2022, 9, 1);
        CreditCard testCC = new CreditCard("NewCC", "1234-1234-1234-1234", testLocalDate);
        BankAccount testBA = new BankAccount("NewBA", "123-123-123", "Test account");
        PaymentMethod.InvalidDetailException thrown;

        // test empty name entry for Credit card
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testCC.setPayerName(""));
        assertEquals("Name must be having a length of more than 1! Try again!", thrown.getMessage());

        // test equals method
        CreditCard test2CC = new CreditCard("NewCC", "1234-1234-1234-1234", testLocalDate);
        assertEquals(testCC, test2CC);
        CreditCard test3CC = new CreditCard("New2CC", "1454-1245-1245-1245", testLocalDate);
        assertNotEquals(testCC, test3CC);

        // test invalid entry for Credit card number
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testCC.setCreditCardNumber(""));
        assertEquals("Invalid credit card number! Format is XXXX-XXXX-XXXX-XXXX X: digits only", thrown.getMessage());
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testCC.setCreditCardNumber("123-123-123"));
        assertEquals("Invalid credit card number! Format is XXXX-XXXX-XXXX-XXXX X: digits only", thrown.getMessage());
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testCC.setCreditCardNumber("1234-1234-1234-12a4"));
        assertEquals("Invalid credit card number! Format is XXXX-XXXX-XXXX-XXXX X: digits only", thrown.getMessage());

        // test invalid date for credit card
        LocalDate testLocalDate2 = LocalDate.of(2020, 9, 1);
        // test past date
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testCC.setExpiry(testLocalDate2));
        assertEquals("Expiry date must be in the future!", thrown.getMessage());
        // test now date
        LocalDate testLocalDate3 = LocalDate.now();
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testCC.setExpiry(testLocalDate3));
        assertEquals("Expiry date must be in the future!", thrown.getMessage());

        // test invalid entry for Bank Account number
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testBA.setAccountNumber(""));
        assertEquals("Invalid Bank account number! Try again!", thrown.getMessage());
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testBA.setAccountNumber("1454-1245-1245-1245"));
        assertEquals("Invalid Bank account number! Try again!", thrown.getMessage());
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testBA.setAccountNumber("1454-1245-12sa"));
        assertEquals("Invalid Bank account number! Try again!", thrown.getMessage());

        // test invalid entry for Bank name
        thrown = assertThrows(PaymentMethod.InvalidDetailException.class, () -> testBA.setBankName(""));
        assertEquals("Name must be having a length of more than 1! Try again!", thrown.getMessage());

    }
    /**
     * Test case for paying customer class
     */
    @org.junit.jupiter.api.Test
    void testPayingCustomer() throws PaymentMethod.InvalidDetailException, Customer.InvalidDetailException {
        // Paying customer
        PayingCustomer testPayingCustomer = new PayingCustomer();
        Customer.InvalidDetailException thrown;
        // assert Customer.InvalidDetailException if name is zero length
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setCustName(""));
        assertEquals("Name must be having a length of more than 1! Try again!", thrown.getMessage());

        // assert Customer.InvalidDetailException if email is zero length
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setCustEmail(""));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        // assert Customer.InvalidDetailException if email is invalid
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setCustEmail("1234"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setCustEmail("asc#df.sdf"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setCustEmail("asc&df"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setCustEmail("asc.df"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        LocalDate testLocalDate = LocalDate.of(2022, 9, 1);
        CreditCard testCC = new CreditCard("NewCC", "1234-1234-1234-1234", testLocalDate);

        // check credit card method
        assertTrue(testPayingCustomer.setCreditCard(testCC));

        // check if the payment method is updated
        assertEquals(testCC, testPayingCustomer.getPaymentMethod());
        // test duplicate entry of same credit card
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setCreditCard(testCC));
        assertEquals("Payment Method already exists!", thrown.getMessage());

        BankAccount testBA = new BankAccount("NewBA", "123-123-123", "Test account");

        // check bank account method
        assertTrue(testPayingCustomer.setBankAccount(testBA));

        // check if the payment method is updated
        assertEquals(testBA, testPayingCustomer.getPaymentMethod());

        // test duplicate entry of same credit card
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testPayingCustomer.setBankAccount(testBA));
        assertEquals("Payment Method already exists!", thrown.getMessage());

        AssociateCustomer testAC = new AssociateCustomer("Jonathan New", "Jonathan@email.com");

        // test enter associate customer
        assertTrue(testPayingCustomer.setAssociateCustomer(testAC));

        // test duplicate associate customer
        assertFalse(testPayingCustomer.setAssociateCustomer(testAC));

        // test equals method
        PayingCustomer testPayingCustomer2 = new PayingCustomer("New customer 2", "test@email.com");
        PayingCustomer testPayingCustomer3 = new PayingCustomer("New customer 2", "test@email.com");
        assertEquals(testPayingCustomer2, testPayingCustomer3);
    }
    /**
     * Test case for associate customer class
     */
    @org.junit.jupiter.api.Test
    void testAssociateCustomer() throws Customer.InvalidDetailException {
        // Associate customer
        AssociateCustomer testAssociateCustomer2 = new AssociateCustomer();
        Customer.InvalidDetailException thrown;
        // assert Customer.InvalidDetailException if name is zero length
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustName(""));
        assertEquals("Name must be having a length of more than 1! Try again!", thrown.getMessage());

        // assert Customer.InvalidDetailException if email is zero length
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail(""));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        // assert Customer.InvalidDetailException if email is invalid
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("1234"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("asc#df.sdf"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("asc&df"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("asc.df"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        // test supplement entry
        Supplement testSupp = new Supplement("test Supplement", 123.3);

        // test supplement entry
        assertTrue(testAssociateCustomer2.setSupplement(testSupp));

        // test duplicate supplement
        assertFalse(testAssociateCustomer2.setSupplement(testSupp));

        // test equals method
        AssociateCustomer testAssociateCustomer3 = new AssociateCustomer("New customer 2", "test@email.com");
        AssociateCustomer testAssociateCustomer4 = new AssociateCustomer("New customer 2", "test@email.com");
        assertEquals(testAssociateCustomer3, testAssociateCustomer4);
    }

    /**
     * Test case for part E: add a new customer to the magazine service
     */
    @org.junit.jupiter.api.Test
    void addNewAssociateCustomer() throws Customer.InvalidDetailException {
        //Test successful add
        // Generate new customer
        AssociateCustomer testAssociateCustomer = new AssociateCustomer("Jonathan New", "Jonathan@email.com");
        // add the customer
        assertTrue(client.addNewAssociateCustomer("Jonathan New", "Jonathan@email.com"));
        // check if the new customer is found
        assertTrue(client.getMagService().getAssociateCustomers().contains(testAssociateCustomer));
        // clean up
        client.removeAssociateCustomer("Jonathan New", "Jonathan@email.com");

        // Test add duplicate customer
        assertFalse(client.addNewAssociateCustomer("John Lim", "john.lim@email.com"));

        // Test add empty customer name
        assertFalse(client.addNewAssociateCustomer("", "Jonathan@email.com"));

        // test add empty customer email
        assertFalse(client.addNewAssociateCustomer("Jonathan New", ""));

        // test add invalid customer email
        assertFalse(client.addNewAssociateCustomer("Jonathan New", "123.sd.com"));

        AssociateCustomer testAssociateCustomer2 = new AssociateCustomer();
        Customer.InvalidDetailException thrown;
        // assert Customer.InvalidDetailException if name is zero length
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustName(""));
        assertEquals("Name must be having a length of more than 1! Try again!", thrown.getMessage());

        // assert Customer.InvalidDetailException if email is zero length
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail(""));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        // assert Customer.InvalidDetailException if email is invalid
        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("1234"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("asc#df.sdf"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("asc&df"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());

        thrown = assertThrows(Customer.InvalidDetailException.class, () -> testAssociateCustomer2.setCustEmail("asc.df"));
        assertEquals("Invalid email! Try again!", thrown.getMessage());
    }

    /**
     * Test case for part E: add a new customer to the magazine service
     */
    @org.junit.jupiter.api.Test
    void addNewPayingCustomer() throws Customer.InvalidDetailException{
        // Generate new customer
        PayingCustomer testPayingCustomer = new PayingCustomer("Jonathan New", "Jonathan@email.com");
        // add the customer
        assertTrue(client.addNewPayingCustomer("Jonathan New", "Jonathan@email.com"));
        // check if the new customer is found
        assertTrue(client.getMagService().getMagPayingCustomers().contains(testPayingCustomer));
        // clean up
        client.removeAssociateCustomer("Jonathan New", "Jonathan@email.com");
    }

    /**
     * Test case for part F: remove an existing customer from the magazine service,
     */
    @org.junit.jupiter.api.Test
    void removeAssociateCustomer() throws Customer.InvalidDetailException{
        // Generate a customer that is available in the init
        AssociateCustomer testAssociateCustomer = new AssociateCustomer("John Lim", "john.lim@email.com");
        Integer testAssociateCustomerId = client.getMagService().getAssociateCustomer("John Lim").getCustId();
        PayingCustomer testPayer = client.getMagService().getMagPayingCustomer("John Lim");
        // check if the paying customer for testAssociateCustomer is removed
        assertEquals(testAssociateCustomerId,testPayer.getAssociateCustomers().get(0));

        // remove customer that exists as one of the customer in the init
        assertTrue(client.removeAssociateCustomer("John Lim", "john.lim@email.com"));

        // check if the new customer is found after remove
        assertFalse(client.getMagService().getAssociateCustomers().contains(testAssociateCustomer));

        // check if the paying customer for testAssociateCustomer is removed
        assertTrue(testPayer.getAssociateCustomers().isEmpty());
    }

    /**
     * Test case for part F: remove an existing customer from the magazine service,
     */
    @org.junit.jupiter.api.Test
    void removePayingCustomer() throws Customer.InvalidDetailException{
        // Generate a customer that is available in the init
        PayingCustomer testPayingCustomer = new PayingCustomer("John Lim", "john.doe@email.com");

        // remove customer that exists as one of the customer in the init
        assertTrue(client.removePayingCustomer("John Lim", "john.doe@email.com"));

        // check if the new customer is found after remove
        assertFalse(client.getMagService().getMagPayingCustomers().contains(testPayingCustomer));
    }

    /**
     * Test case for part A: add an new supplement to magazine service
     */
    @org.junit.jupiter.api.Test
    void addSupplement() {
        // create a new supplement
        Supplement newSupp = new Supplement("New Supplement", 12.43);

        // add new supplement
        assertTrue(client.addNewSupplement("New Supplement", 12.43));

        // check if the new supplement is found after adding
        assertTrue(client.getMagService().getSupplements().contains(newSupp));
    }

    /**
     * Test case for part A: add an new magazine to magazine service
     */
    @org.junit.jupiter.api.Test
    void addMagazine() {
        // create a new supplement
        Magazine newMag = new Magazine("New Magazine", 12.43);

        // add new supplement
        assertTrue(client.addNewMagazine("New Magazine", 12.43));

        // check if the new supplement is found after adding
        assertTrue(client.getMagService().getMagazines().contains(newMag));
    }
}