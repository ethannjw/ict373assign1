import java.lang.management.ManagementFactory;
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
     * Test case for part C: print out the text of all the emails for all customers for four weeks of magazines
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
     * Test case for part E: add a new customer to the magazine service
     */
    @org.junit.jupiter.api.Test
    void addNewAssociateCustomer() {
        AssociateCustomer testAssociateCustomer = new AssociateCustomer("Jonathan New", "Jonathan@email.com");
        client.addNewAssociateCustomer("Jonathan New", "Jonathan@email.com");

        // check if the new customer is found
        assertTrue(client.getMagService().getAssociateCustomers().contains(testAssociateCustomer));

    }

    /**
     * Test case for part E: add a new customer to the magazine service
     */
    @org.junit.jupiter.api.Test
    void addNewPayingCustomer() {
        PayingCustomer testPayingCustomer = new PayingCustomer("Jonathan New", "Jonathan@email.com");
        client.addNewPayingCustomer("Jonathan New", "Jonathan@email.com");
        // check if the new customer is found
        assertTrue(client.getMagService().getMagPayingCustomers().contains(testPayingCustomer));

    }

    /**
     * Test case for part F: remove an existing customer from the magazine service,
     */
    @org.junit.jupiter.api.Test
    void removeAssociateCustomer() {
        AssociateCustomer testAssociateCustomer = new AssociateCustomer("John Lim", "john.lim@email.com");
        // remove customer
        client.removeAssociateCustomer("John Lim", "john.lim@email.com");

        // check if the new customer is found after remove
        assertFalse(client.getMagService().getAssociateCustomers().contains(testAssociateCustomer));
    }

    /**
     * Test case for part F: remove an existing customer from the magazine service,
     */
    @org.junit.jupiter.api.Test
    void removePayingCustomer() {
        PayingCustomer testPayingCustomer = new PayingCustomer("John Lim", "john.doe@email.com");

        // remove customer
        client.removePayingCustomer("John Lim", "john.doe@email.com");

        // check if the new customer is found after remove
        assertFalse(client.getMagService().getMagPayingCustomers().contains(testPayingCustomer));
    }
}