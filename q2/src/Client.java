

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @title   Client
 * @desc    This class is for testing the Magazine Service system and all of its classes. It contains the methods that
 *          can be called from main
 * @filename Client.java
 * @version 0.1
 * @date    01/10/2020
 * @author  Ethan Ng
 */

public class Client {
    private char userInput;
    private Boolean runSystem;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private MagazineService magService;
    private HashMap<String, String> weeklyEmails;
    private HashMap<Integer, String> monthlyEmails;

    /**
     * Generates a new MagazineService with 7 customers and 4 supplements
     */
    public Client() {
        runSystem = true;
        userInput = '\0';
        magService = generateMagazineService();

        weeklyEmails = new HashMap<String, String>();
        monthlyEmails = new HashMap<Integer, String>();
        this.recordWeeklyEmails();
        this.recordMonthlyEmails();
    }

    /**
     * Returns the MagazineService
     * @return MagazineService
     */
    public MagazineService getMagService() {
        return magService;
    }

    /**
     * Prints the student details
     */
    public static void displayStudentDetails() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Name: Ethan Ng");
        System.out.println("Student Number: 33804877");
        System.out.println("Mode of Enrolment: External");
        System.out.println("Tutor Name: Chong Siew Cheong");
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }

    /**
     * Generates a new MagazineService with 4 magazines, 7 customers and 4 supplements
     * @return MagazineService
     */
    public static MagazineService generateMagazineService() {
        MagazineService s = new MagazineService();
        try {
            // Part A: Construct Magazine
            Magazine mag1 = new Magazine("Programming Magazine", 12.20);
            Magazine mag2 = new Magazine("Cooking Magazine", 12.20);
            Magazine mag3 = new Magazine("Exercise Magazine", 12.20);
            Magazine mag4 = new Magazine("Empty Magazine", 12.20);

            s.setMags(mag1);
            s.setMags(mag2);
            s.setMags(mag3);
            s.setMags(mag4);
            Supplement sup1 = new Supplement("Java Rocks", 32.32);
            Supplement sup2 = new Supplement("Go Lang!", 2.34);
            Supplement sup3 = new Supplement("WooHoo", 12.3);
            Supplement sup4 = new Supplement("The Grind", 2.50);
            s.setSupplement(sup1);
            s.setSupplement(sup2);
            s.setSupplement(sup3);
            s.setSupplement(sup4);
            // Part B: Construct Customers

            AssociateCustomer cust1 = new AssociateCustomer("John Lim", "john.lim@email.com");
            cust1.setSupplement(sup1);
            cust1.setSupplement(sup3);
            AssociateCustomer cust2 = new AssociateCustomer("Jayne Petersen", "jayne.petersen@email.com");
            cust2.setSupplement(sup1);
            cust2.setSupplement(sup4);
            AssociateCustomer cust3 = new AssociateCustomer("Brian Meadows", "brian.meadows@email.com");
            cust3.setSupplement(sup2);
            cust3.setSupplement(sup1);
            cust3.setSupplement(sup4);
            cust3.setSupplement(sup3);
            AssociateCustomer cust4 = new AssociateCustomer("Chloe-Ann Manning", "Chloe-Ann@email.com");
            cust4.setSupplement(sup3);
            s.setAssociateCustomer(cust1);
            s.setAssociateCustomer(cust2);
            s.setAssociateCustomer(cust3);
            s.setAssociateCustomer(cust4);

            PayingCustomer payer1 = new PayingCustomer("John Lim", "john.doe@email.com");
            PayingCustomer payer2 = new PayingCustomer("Jayne Petersen", "petersen@email.com");
            PayingCustomer payer3 = new PayingCustomer("Alan Burnett", "burnett@email.com");
            CreditCard cc1 = new CreditCard("Lim Swee Keat", "1234 5678 9102 1234", LocalDate.of(2023, 5, 1));
            CreditCard cc2 = new CreditCard("Tim Petersen", "1234 9851 4592 1984", LocalDate.of(2024, 1, 1));
            BankAccount ba1 = new BankAccount("Alan Burnett", "123-567-981", "ABC Bank");

            payer1.setCreditCard(cc1);
            payer1.setAssociateCustomer(cust1);
            payer2.setCreditCard(cc2);
            payer2.setAssociateCustomer(cust2);
            payer3.setBankAccount(ba1);
            payer3.setAssociateCustomer(cust3);
            payer3.setAssociateCustomer(cust4);

            s.setMagPayingCustomer(payer1);
            s.setMagPayingCustomer(payer2);
            s.setMagPayingCustomer(payer3);

        }
        catch (Customer.InvalidDetailException | PaymentMethod.InvalidDetailException e) {
            System.out.println("Adding customer failed!");
            System.exit(1);
        }
        return s;
    }

    /**
     * Records the hardcoded weekly emails for all magazines and customers
     */
    private void recordWeeklyEmails() {
        for (Magazine mag : magService.getMagazines()) {
            String weeklyEmail = magService.printWeeklyEmail(mag);
            weeklyEmails.put(mag.getMagName(), weeklyEmail);
        }
    }
    /**
     * Records the hardcoded monthly emails for all paying customers
     */
    private void recordMonthlyEmails() {
        for (PayingCustomer payer : magService.getMagPayingCustomers()) {
            int payerId = payer.getCustId();
            String monthlyEmail = magService.printMonthlyEmail(payer);
            monthlyEmails.put(payerId, monthlyEmail);
        }
    }

    /**
     * Part C
     * Prints weekly emails for all magazines and customers
     */
    public void printWeeklyEmails() {
        if (weeklyEmails.isEmpty()) {
            this.recordWeeklyEmails();
        }
        System.out.println("---------------------All Weekly Emails--------------------");

        for (String weeklyEmail : weeklyEmails.values()) {
            System.out.println(weeklyEmail);
        }
        System.out.println("--------------------Done Weekly Emails--------------------");
    }

    /**
     * Part D
     * Prints bill emails for all paying customers
     */
    public void printMonthlyEmails() {
        if (monthlyEmails.isEmpty()) {
            this.recordMonthlyEmails();
        }
        System.out.println("--------------------Print Monthly Emails------------------");
        for (String monthlyEmail : monthlyEmails.values()) {
            System.out.println(monthlyEmail);
        }
        System.out.println("--------------------Done Monthly Emails-------------------");
    }
    /**
     * Part E
     * Adds new associate customer with name and email as input
     * @param custName: String
     * @param custEmail: String
     */
    public void addNewAssociateCustomer(String custName, String custEmail) {
        try{
            AssociateCustomer newCust = new AssociateCustomer(custName, custEmail);
            this.magService.setAssociateCustomer(newCust);
        }
        catch (Customer.InvalidDetailException e) {
            System.out.println("Adding customer failed!");
        }

    }
    /**
     * Part E
     * Adds new paying customer with name and email as input
     * @param custName: String
     * @param custEmail: String
     */
    public void addNewPayingCustomer(String custName, String custEmail) {
        try {
            PayingCustomer newCust = new PayingCustomer(custName, custEmail);
            this.magService.setMagPayingCustomer(newCust);
        }
        catch (Customer.InvalidDetailException e) {
            System.out.println("Adding customer failed!");
        }


    }
    /**
     * Part F
     * Removes associate customer with name and email as input
     * @param custName: String
     * @param custEmail: String
     */
    public void removeAssociateCustomer(String custName, String custEmail) {

        List<AssociateCustomer> cust = this.magService.getAssociateCustomers();
        for (AssociateCustomer c : cust) {
            if (c.getCustName().equals(custName) && c.getCustEmail().equals(custEmail)) {
                // Found customer to delete
                if (this.magService.remCustomer(c)) {
                    System.out.println("Successfully removed customer: " + c.getCustName() + "\n");
                    return; // customer removal success
                } else {
                    System.out.println("Unable to remove customer: " + c.getCustName());
                }
            }
        }
        System.out.println("No such customer");
    }
    /**
     * Part F
     * Removes paying customer with name and email as input
     * @param custName: String
     * @param custEmail: String
     */
    public void removePayingCustomer(String custName, String custEmail) {

        List<PayingCustomer> cust = this.magService.getMagPayingCustomers();
        for (PayingCustomer c : cust) {
            if (c.getCustName().equals(custName) && c.getCustEmail().equals(custEmail)) {
                // Found customer to delete
                if (this.magService.remCustomer(c)) {
                    System.out.println("Successfully removed customer: " + c.getCustName() + "\n");
                    return; // customer removal success
                } else {
                    System.out.println("Unable to remove customer: " + c.getCustName());
                }
            }
        }
        System.out.println("No such customer");
    }

//    /**
//     * Displays list of customers.
//     * Performed by option [5].
//     */
//    private void listCustomers() {
//        Customer customer;
//        ArrayList<Customer> all = customers.getAll();
//        ArrayList<String> supplements;
//
//        for (int i = 0; i < all.size(); i++) {
//            customer = all.get(i);
//            supplements = customer.getSupplements();
//            System.out.println("-------------------------------------------------------");
//            System.out.printf("| %-16s | %-32s |\n", "ID",            customer.getID());
//            System.out.printf("| %-16s | %-32s |\n", "Name",          customer.getName());
//            System.out.printf("| %-16s | %-32s |\n", "Email",         customer.getEmail());
//            System.out.printf("| %-16s | %-32s |\n", "Supplement(s)", supplements.size() > 0 ? supplements : "None");
//
//            if (customer.isPaying()) {
//                PayingCustomer payer = (PayingCustomer) customer;
//                ArrayList<String> associates = payer.getAssociates();
//                System.out.printf("| %-16s | %-32s |\n", "Payment method", payer.getPaymentMethod());
//                System.out.printf("| %-16s | %-32s |\n", "Payment number", payer.getPaymentNumber());
//                System.out.printf("| %-16s | %-32s |\n", "Associate(s)", associates.size() > 0 ? associates : "None");
//            }
//        }
//
//        System.out.println("-------------------------------------------------------");
//    }
    /**
     * Breaks loop and exits program.
     * Performed by option [q].
     */
    private void exitSystem() {
        System.out.println("Exiting system.");
        runSystem = false;
    }

    private void promptContinue() {
        String choice = "";
        System.out.println("Press enter to continue, 'q' to quit");
        try {
            choice = reader.readLine();
        }
        catch (IOException e) {
            System.out.println("Invalid Input! Try again!");
            this.promptContinue();
        }

        while (!choice.equalsIgnoreCase("q")) {
            promptMainOptions();
        }

        System.exit(0);

    }

    /**
     * Collects input required for adding a new paying customer.
     * Part E
     * Performed by menu option [4].
     */
    private void promptAddPayingCustomer() {
        String custName = "";
        String custEmail = "";
        String associateCustName = "";
        AssociateCustomer associateCustomer;
        // add customer name
        while (custName.isEmpty()) {
            try {
                System.out.print("Customer's name: ");
                custName = reader.readLine();
            } catch (IOException e) {
                System.out.println(e);
                custName = "";
            }
        }

        // add customer email
        while (custEmail.isEmpty()) {
            try {
                System.out.print("Customer's email: ");
                custEmail = reader.readLine();
            } catch (IOException e) {
                System.out.println(e);
                custEmail = "";
            }
        }
        PayingCustomer payer = promptAddPayingCustomer(custName, custEmail);

        // add customer that payer is paying for
        while (true) {
            try {
                System.out.print("Associate Customer's name: ");
                associateCustName = reader.readLine();
            } catch (IOException e) {
                System.out.println(e);
                associateCustName = "";
            }
            if ((associateCustomer = magService.getAssociateCustomer(associateCustName)) != null) {
                payer.setAssociateCustomer(associateCustomer);
                break;
            } else {
                System.out.println("Customer " + associateCustName + " not found! Try Again!");
            }
        }

        magService.setMagPayingCustomer(payer);
        System.out.println("Sucessfully added new paying customer");
    }

    /**
     * Collects payment method input required for adding a new paying customer.
     * @param custName
     * @param custEmail
     */
    private PayingCustomer promptAddPayingCustomer(String custName, String custEmail) {
        String paymentMethodOption = "";
        PaymentMethod paymentMtd;
        String paymentName = "";
        String paymentNumber = "";
        String bankName = "";
        LocalDate exp = null;
        PayingCustomer payer = new PayingCustomer();
        System.out.println("Enter your payment details: ");
        // first create a new paying customer with existing customer detail
        try {
            payer.setCustName(custName);
            payer.setCustEmail(custEmail);
        } catch (Customer.InvalidDetailException e) {
            System.out.println(e);
        }
        // get user payment method
        while (true) {
            System.out.println("Select customer's payment method:");
            System.out.println("[0] Credit Card");
            System.out.println("[1] Bank Account");
            System.out.print("Select option: ");
            try {
                paymentMethodOption = reader.readLine();
            }
            catch (IOException e) {
                System.out.println(e);
                continue;
            }
            if (!paymentMethodOption.equals("0") && !paymentMethodOption.equals("1")) {
                System.out.println("Invalid Entry! Try again!");
                continue;
            } else {
                break;
            }
        }

        // enter the payment name from user
        while(true) {
            System.out.print("Customer's name in bank or card: ");
            try {
                paymentName = reader.readLine();
            }
            catch (IOException e) {
                System.out.println(e);
                continue;
            }
            if (paymentName.equals("")) {   // check that name is not empty
                System.out.println("Name cannot be empty! Try again!");
            } else {
                if (paymentMethodOption.equals("0")) {  // credit card
                    try {
                        paymentMtd = new CreditCard(paymentName);  // create new instance
                        break;
                    } catch (PaymentMethod.InvalidDetailException e) {  // exit entering payment detail if fail
                        System.out.println(e);
                    }
                }   else {
                    try {
                        paymentMtd = new BankAccount(paymentName);  // create new instance
                        break;
                    } catch (PaymentMethod.InvalidDetailException e) {  // exit entering payment detail if fail
                        System.out.println(e);
                    }
                }
            }

        }
        // enter the credit card number
        if (paymentMethodOption.equals("0")) {  // credit card
            while(true) {
                System.out.print("Customer's credit card number in (XXXX-XXXX-XXXX-XXXX): ");
                try {
                    paymentNumber = reader.readLine();
                }
                catch (IOException e) {
                    System.out.println(e);
                    continue;
                }
                if (paymentName.equals("")) {
                    System.out.println("Invalid Entry! Try again!");
                    continue;
                }
                // try to record the payment detail
                try {
                    ((CreditCard)paymentMtd).setCreditCardNumber(paymentNumber);
                    break;
                } catch (PaymentMethod.InvalidDetailException e) {
                    System.out.println(e);
                }
            }
        }

        // enter the credit card date
        if (paymentMethodOption.equals("0")) {  // credit card
            String year = "";
            String mth = "";
            Integer yearInt = 1900;
            Integer mthInt = 0;

            // get the year from user
            while(true) {
                System.out.print("Customer's credit card expiry date year in (YYYY): ");
                try {
                    year = reader.readLine();
                }
                catch (IOException e) {
                    System.out.println(e);
                    continue;
                }
                System.out.print("Customer's credit card expiry date mth in (MM): ");
                try {
                    mth = reader.readLine();
                }
                catch (IOException e) {
                    System.out.println(e);
                    continue;
                }
                if (year.equals("") | mth.equals("")) {
                    System.out.println("Invalid Entry! Try again!");
                } else {
                    try {
                        yearInt = Integer.parseInt(year);
                        mthInt = Integer.parseInt(mth);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Entry:" + e);
                    }
                    try {
                        exp = LocalDate.of(yearInt, mthInt,1);
                        ((CreditCard) paymentMtd).setExpiry(exp);
                        break;
                    } catch (PaymentMethod.InvalidDetailException | DateTimeException e) {  // check if the date is in future and if the date is valid
                        System.out.println(e);
                    }

                }
            }
            // store the credit card
            try {
                payer.setCreditCard((CreditCard) paymentMtd);
                System.out.println("Successfully stored credit card details");
            }
            catch (Customer.InvalidDetailException e) {
                System.out.println(e);
            }
        }   // end credit card

        // enter the bank account details
        else {
            // enter the bank account number
            while(true) {
                System.out.print("Customer's bank account number in (XXX-XXX-XXX): ");
                try {
                    paymentNumber = reader.readLine();
                }
                catch (IOException e) {
                    System.out.println(e);
                    continue;
                }
                if (paymentName.equals("")) {
                    System.out.println("Invalid Entry! Try again!");
                    continue;
                }
                // try to record the payment detail
                try {
                    ((BankAccount)paymentMtd).setAccountNumber(paymentNumber);
                    break;
                } catch (PaymentMethod.InvalidDetailException e) {
                    System.out.println(e);
                }
            }

            // get the bank name from user
            while(true) {
                System.out.print("Customer's Bank Name: ");
                try {
                    bankName = reader.readLine();
                }
                catch (IOException e) {
                    System.out.println(e);
                    continue;
                }

                if (bankName.equals("") ) {
                    System.out.println("Invalid Entry! Try again!");
                } else {
                    try {
                        ((BankAccount) paymentMtd).setBankName(bankName);
                        break;
                    } catch (PaymentMethod.InvalidDetailException e) {  // check if the date is in future and if the date is valid
                        System.out.println(e);
                    }
                }
            }
            try {
                payer.setBankAccount((BankAccount) paymentMtd);
                System.out.println("Successfully stored bank details");
            }
            catch (Customer.InvalidDetailException e) {
                System.out.println(e);
            }
        }   // end bank account

        return payer;
    }

    /**
     * Collects input required for adding a new associate customer.
     * Part E
     * Performed by menu option [3].
     */
    private void promptAddAssociateCustomer() {
        System.out.println("Adding an associate customer");
        String custName = "";
        String custEmail = "";
        String supplementID;
        Supplement supp;
        int suppId;
        List<String> supplements = new ArrayList<String>();
        AssociateCustomer associateCustomer = new AssociateCustomer();
        PayingCustomer payer;

        // add customer name
        while (custName.isEmpty()) {
            try {
                System.out.print("Customer's name: ");
                custName = reader.readLine();
                associateCustomer.setCustName(custName);
            } catch (Customer.InvalidDetailException | IOException e) {
                System.out.println(e);
                custName = "";
            }
        }

        // add customer email
        while (custEmail.isEmpty()) {
            try {
                System.out.print("Customer's email: ");
                custEmail = reader.readLine();
                associateCustomer.setCustEmail(custEmail);
            } catch (Customer.InvalidDetailException | IOException e) {
                System.out.println(e);
                custEmail = "";
            }
        }

        // select supplement(s) that customer will subscribe to
        while (true) {
            System.out.println("Would you like to subscribe to additional supplements? Enter a supplement ID or an empty entry to skip: ");
            System.out.println(magService.printAllSupplements());
            try {
                supplementID = reader.readLine();
            }
            catch (IOException e) {
                System.out.println(e);
                continue;
            }

            if (supplementID.equals("")) {
                System.out.println("Exiting Supplement entry");
                break;
            } else {
                try {
                    suppId = Integer.parseInt(supplementID);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entry! Please try again!");
                    continue;
                }
                if ((supp = magService.getSupplement(suppId)) != null) {
                    // check if customer already subscribed to the supplement
                    if (associateCustomer.getSupplements().contains(suppId)){
                        System.out.println("You have already subscribed to: " + supp.getSuppName());
                        continue;
                    }
                    associateCustomer.setSupplement(supp);
                    System.out.println("Congratulations! You have subscribed to: " + supp.getSuppName());

                } else {
                    System.out.println(supplementID + " is not a valid supplement. Please try again!");
                }
            }
        }

        String paymentDetailsOption = "";
        // check if the customer wants to insert paying customer or wait till another time
        while(true) {

            System.out.println("Enter your payment details now? N for no or press enter to enter details");
            try {
                paymentDetailsOption = reader.readLine();
                break;
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }

        if (paymentDetailsOption.equals("")) {
            // get the payer
            payer = promptAddPayingCustomer(custName, custEmail);
            // store the associate customer in the payer
            payer.setAssociateCustomer(associateCustomer);
            magService.setMagPayingCustomer(payer);
        }

        // record the associate customer
        magService.setAssociateCustomer(associateCustomer);

        System.out.println("** Customer added.");
    }

    /**
     * Performs action designated to option.
     * @param {char} option
     */
    private void runOption(char option) {
        // reset line from input from options prompt, otherwise nextLine is skipped.
//        try {
//            reader.readLine();
//        }
//        catch (IOException e) {
//            System.out.println(e);
//            this.promptMainOptions();
//        }

        switch (option) {
            case '1':
                System.out.println(magService.printWeeklyEmails());
                promptContinue();
                break;
            case '2':
                System.out.println(magService.printMonthlyEmails());
                promptContinue();
                break;
            case '3':
                promptAddAssociateCustomer();
                promptContinue();
                break;
            case '4':
                promptAddPayingCustomer();
                promptContinue();
                break;
//            case '5':
//                promptRemoveAssociateCustomer();
//                promptContinue();
//                break;
//            case '6':
//                promptRemovePayingCustomer();
//                promptContinue();
//                break;
//            case 'q':
//                exitSystem();
//                break;
            default:
                System.out.println("Information: Invalid option selected.");
                break;
        }
        promptMainOptions();
    }

    /**
     * Display program's main options.
     */
    public void promptMainOptions() {
        while (runSystem) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Welcome to the Scam Magazines management system.");
            System.out.println("Please select an option below:");
            System.out.println("[1] Show weekly email for all customers.");
            System.out.println("[2] Show monthly email for paying customers.");
            System.out.println("[3] Add an associate customer.");
            System.out.println("[4] Add a paying customer.");
            System.out.println("[5] Remove an associate customer.");
            System.out.println("[6] Remove a paying customer.");
            System.out.println("[q] Exit the system.");
            System.out.println("-------------------------------------------------------");

            System.out.println("Select option: ");
            try {
                userInput = reader.readLine().charAt(0);
            }
            catch (IOException e) {
                System.out.println(e);
                this.promptMainOptions();
            }

            runOption(userInput);
        }
    }
}

