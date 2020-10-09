

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @title   Client
 * @desc    This class is for testing the Magazine Service system and all of its classes. It contains the methods that
 *          can be called from main
 * @filename Client.java
 * @version 0.1
 * @date    01/10/2020
 * @author  Ethan Ng
 * // TODO: 10/8/2020 When entering paying customer, add return option to allow user to return to main menu if the
 *          associate customer cannot be found
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
        LocalDate today = LocalDate.now();
        MagazineService s = new MagazineService();
        try {
            // Part A: Construct Magazine
            Magazine mag1 = new Magazine("Programming Magazine", 12.20, (today.getMonthValue()-1));
            Magazine mag2 = new Magazine("Cooking Magazine", 12.20, (today.getMonthValue()-1));
            Magazine mag3 = new Magazine("Exercise Magazine", 12.20, (today.getMonthValue()-1));
            Magazine mag4 = new Magazine("Empty Magazine", 12.20, (today.getMonthValue()-1));

            s.setMagazine(mag1);
            s.setMagazine(mag2);
            s.setMagazine(mag3);
            s.setMagazine(mag4);
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
     * Records the hardcoded weekly emails for all magazines and customers so that the
     * magazine information from previous magazines are not lost
     */
    private void recordWeeklyEmails() {
        for (Magazine mag : magService.getMagazines()) {
            if (!weeklyEmails.containsKey(mag.getMagName())) {  // if the magazine is not already present
                String weeklyEmail = magService.printWeeklyEmail(mag);
                weeklyEmails.put(mag.getMagName(), weeklyEmail);
            }
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

        this.recordWeeklyEmails();

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

        this.recordMonthlyEmails();

        System.out.println("--------------------Print Monthly Emails------------------");
        for (String monthlyEmail : monthlyEmails.values()) {
            System.out.println(monthlyEmail);
        }
        System.out.println("--------------------Done Monthly Emails-------------------");
    }

    /**
     * Part E
     * Adds new associate customer with name and email as input
     * @param custName  Customer name in String
     * @param custEmail Customer email in String
     * @return boolean  Return true if successful, false if not
     */
    public boolean addNewAssociateCustomer(String custName, String custEmail) {
        try {
            AssociateCustomer newCust = new AssociateCustomer(custName, custEmail);
            if (this.magService.setAssociateCustomer(newCust)) {
                return true;
            } else {
                System.out.println("Adding customer failed!");
                return false;
            }
        }
        catch (Customer.InvalidDetailException e) {
            System.out.println("Adding customer failed!");
            return false;
        }
    }

    /**
     * Part E
     * Adds new paying customer with name and email as input
     * @param custName      Customer name in String
     * @param custEmail     Customer email in String
     * @return boolean  Return true if successful, false if not
     */
    public boolean addNewPayingCustomer(String custName, String custEmail) {
        try {
            PayingCustomer newCust = new PayingCustomer(custName, custEmail);
            this.magService.setMagPayingCustomer(newCust);
        }
        catch (Customer.InvalidDetailException e) {
            System.out.println("Adding customer failed!");
            return false;
        }
        return true;
    }

    /**
     * Part F
     * Removes associate customer with name and email as input
     * @param custName      Customer name in String
     * @param custEmail     Customer email in String
     * @return boolean  Return true if successful, false if not
     */
    public boolean removeAssociateCustomer(String custName, String custEmail) {

        List<AssociateCustomer> cust = this.magService.getAssociateCustomers();
        for (AssociateCustomer c : cust) {
            if (c.getCustName().equals(custName) && c.getCustEmail().equals(custEmail)) {
                // Found customer to delete
                if (this.magService.remCustomer(c)) {
                    System.out.println("Successfully removed customer: " + c.getCustName() + "\n");
                    // need to find the paying customer that is paying for this customer and update as well.
                    for (PayingCustomer payer : this.magService.getMagPayingCustomers()) {  // each paying customer
                        for (Integer payerAssociateCust : payer.getAssociateCustomers()) {  // each associate customer in payer
                            if (c.getCustId() == payerAssociateCust) {
                                // remove the associate customer the payer is paying for
                                if (payer.removeAssociateCustomer(c)) {
                                    System.out.println("Updated payer: " + payer.getCustName() + " removed " + c.getCustName() + " as one if its associate customer");
                                    return true;
                                } else {
                                    System.out.println("Tried to remove associate customer: " + c.getCustName() + " from " + payer.getCustName() + " but not successful");
                                }
                            }
                        }
                    }
                    System.out.println("Associate customer: " + c.getCustName() + "is not being paid for by anyone, nothing to remove");
                    return true; // customer removal success
                } else {
                    System.out.println("Unable to remove customer: " + c.getCustName());
                    return false;
                }
            }
        }
        System.out.println("No such customer");
        return false;
    }

    /**
     * Part F
     * Removes paying customer with name and email as input
     * @param custName  Customer name in String
     * @param custEmail Customer email in String
     * @return boolean  Return true if successful, false if not
     */
    public boolean removePayingCustomer(String custName, String custEmail) {
        List<PayingCustomer> cust = this.magService.getMagPayingCustomers();
        for (PayingCustomer c : cust) {
            if (c.getCustName().equals(custName) && c.getCustEmail().equals(custEmail)) {
                // Found customer to delete
                if (this.magService.remCustomer(c)) {
                    System.out.println("Successfully removed customer: " + c.getCustName() + "\n");
                    return true; // customer removal success
                } else {
                    System.out.println("Unable to remove customer: " + c.getCustName());
                    return false;
                }
            }
        }
        System.out.println("No such customer");
        return false;
    }

    /**
     * Part F
     * Prompt Removes paying customer retrieving user name and email as input
     */
    private void promptRemovePayingCustomer() {
        String custName = "";
        String custEmail = "";
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
        // remove the customer
        removePayingCustomer(custName, custEmail);
    }

    /**
     * Part F
     * Prompt Removes associate customer retrieving user name and email as input
     */
    private void promptRemoveAssociateCustomer() {
        String custName = "";
        String custEmail = "";
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
        // remove the customer
        removeAssociateCustomer(custName, custEmail);
    }

    /**
     * Continue option that runs after each option to allow user to quit
     */
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
            if ((associateCustomer = magService.getAssociateCustomer(associateCustName)) == null) { // check if the customer exists
                System.out.println("Customer " + associateCustName + " not found! Try Again!");
                continue;
            }
            payer.setAssociateCustomer(associateCustomer);
            if (!magService.setMagPayingCustomer(payer)) {   // check if the customer has already been paid for
                // error message printed by the setMagPayingCustomer method
                payer.removeAssociateCustomer(associateCustomer);
                continue;
            }
            break;  // if all pass then break out of while loop
        }
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
     * Adds a new supplement based on magazine name and weekly cost
     * @param magName           Name of Magazine
     * @param magWeeklyCost     Weekly cost of magazine in double
     * @return boolean          True if successful addition, false if not
     */
    public boolean addNewMagazine(String magName, double magWeeklyCost) {
        // create the new supplement
        Magazine newMag = new Magazine(magName, magWeeklyCost);

        if (magService.setMagazine(newMag)) {
            System.out.println("Add Magazine Successful");
            return true;
        } else {
            System.out.println("Add Magazine not successful");
            return false;
        }
    }
    /**
     * Collects input required for adding a new magazine.
     * Part A
     * Performed by menu option [7].
     */
    private void promptAddNewMagazine() {
        String magName = "";
        double magWeeklyCost = 0.0;

        // add magazine name
        while (magName.isEmpty()) {
            try {
                System.out.print("Magazine's name: ");
                magName = reader.readLine();
            } catch (IOException e) {
                System.out.println(e);
                magName = "";
            }
        }

        // add weekly cost
        while (magWeeklyCost == 0.0) {
            try {
                System.out.print("Magazine weekly cost: ");
                magWeeklyCost = Double.parseDouble(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println(e);
                magWeeklyCost = 0.0;
            }
        }
        addNewMagazine(magName, magWeeklyCost);
    }
    /**
     * Adds a new supplement based on supplement name and supplenment cost
     * @param suppName  Name of supplement in String
     * @param suppCost  Weekly cost of supplement in double
     * @return boolean  True if successful addition, false if not
     */
    public boolean addNewSupplement(String suppName, double suppCost) {
        // create the new supplement
        Supplement newSupp = new Supplement(suppName, suppCost);

        if (magService.setSupplement(newSupp)) {
            System.out.println("Add Supplement Successful");
            return true;
        } else {
            System.out.println("Add Supplement not successful");
            return false;
        }
    }

    /**
     * Collects input required for adding a new supplement.
     * Part A
     * Performed by menu option [8].
     */
    private void promptAddNewSupplement() {
        String suppName = "";
        double suppCost = 0.0;

        // add supplement name
        while (suppName.isEmpty()) {
            try {
                System.out.print("Supplement's name: ");
                suppName = reader.readLine();
            } catch (IOException e) {
                System.out.println(e);
                suppName = "";
            }
        }

        // add supplement cost
        while (suppCost == 0.0) {
            try {
                System.out.print("Supplement's cost: ");
                suppCost = Double.parseDouble(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println(e);
                suppCost = 0.0;
            }
        }

        addNewSupplement(suppName, suppCost);
    }
    /**
     * Performs action designated to option.
     * @param {char} option
     */
    private void runOption(char option) {

        switch (option) {
            case '1':
                printWeeklyEmails();
                promptContinue();
                break;
            case '2':
                printMonthlyEmails();
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
            case '5':
                promptRemoveAssociateCustomer();
                promptContinue();
                break;
            case '6':
                promptRemovePayingCustomer();
                promptContinue();
                break;
            case '7':
                promptAddNewMagazine();
                promptContinue();
                break;
            case '8':
                promptAddNewSupplement();
                promptContinue();
                break;
            case 'q':
                System.exit(0);
                break;
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
            System.out.println("[7] Create New Magazine.");
            System.out.println("[8] Create New Supplement.");
            System.out.println("[q] Exit the system.");
            System.out.println("-------------------------------------------------------");

            System.out.println("Select option: ");
            try {
                userInput = reader.readLine().charAt(0);
            }
            catch (IOException e) {
                System.out.println(e);
                this.promptMainOptions();
            } catch (StringIndexOutOfBoundsException e) {
                this.promptMainOptions();
            }

            runOption(userInput);
        }
    }
}

