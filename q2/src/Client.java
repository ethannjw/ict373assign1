
import java.time.LocalDate;
import java.util.ArrayList;
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
    private Scanner scanner;
    private MagazineService magService;

    /**
     * Generates a new MagazineService with 7 customers and 4 supplements
     */
    public Client() {
        runSystem = true;
        userInput = '\0';
        magService = generateMagazineService();
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
        catch (Customer.InvalidDetailException e) {
            System.out.println("Adding customer failed!");
            System.exit(1);
        }
        return s;
    }
    /**
     * Part C
     * Prints weekly emails for all magazines and customers
     */
    public void printWeeklyEmails() {

        System.out.println("---------------------All Weekly Emails--------------------");
        System.out.println(magService.printWeeklyEmails());
        System.out.println("--------------------Done Weekly Emails--------------------");
    }

    /**
     * Part D
     * Prints bill emails for all paying customers
     */
    public void printMonthlyEmails() {

        System.out.println("--------------------Print Monthly Emails------------------");
        System.out.println(magService.printMonthlyEmails());
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

    private void promptAddCustomer() {
        System.out.println("Adding an associate customer");
        promptAddAssociateCustomer();
    }

    private void promptContinue() {

        System.out.println("Press enter to continue, 'q' to quit");
        String choice = scanner.nextLine();
        while (!choice.equalsIgnoreCase("q")) {
            promptMainOptions();
        }

        System.exit(0);

    }
    /**
     * Performs action designated to option.
     * @param {char} option
     */
    private void runOption(char option) {
        // reset line from input from options prompt, otherwise nextLine is skipped.
        scanner.nextLine();

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
                promptAddCustomer();
                promptContinue();
                break;
//            case '4':
//                promptRemoveCustomer();
//                promptContinue();
//                break;
//            case '5':
//                listCustomers();
//                promptContinue();
//                break;
//            case '6':
//                System.out.println(magService.printAllSupplements());
//                promptContinue();
//                break;
//            case 'q':
//                exitSystem();
//                break;
            default:
                System.out.println("** Invalid option selected.");
                break;
        }
    }
//    /**
//     * Collects input required for adding a new customer.
//     * Part E
//     * Performed by menu option [4].
//     */
//    public void promptRemoveCustomer() {
//        private void promptAddCustomer() {
//            String paying = "";
//            String paymentMethodOption = "";
//            String name = "";
//            String email = "";
//            String paymentMethod = "";
//            String paymentNumber = "";
//            String existingCustomerID = "";
//            String supplementID;
//            List<String> supplements = new ArrayList<String>();
//
//            while (name.isEmpty()) {
//                System.out.print("Customer's name: ");
//                name = scanner.nextLine();
//            }
//
//            while (email.isEmpty()) {
//                System.out.print("Customer's email: ");
//                email = scanner.nextLine();
//            }
//
//            while (!paying.equals("y") && !paying.equals("n")) {
//                System.out.print("Is the customer paying? (y/n) ");
//                paying = scanner.nextLine();
//            }
//
//            // change questions based on whether the customer is paying or an associate
//            if (paying.equals("y")) {
//                while (!paymentMethodOption.equals("0") && !paymentMethodOption.equals("1")) {
//                    System.out.println("Select customer's payment method:");
//                    System.out.println("[0] Credit");
//                    System.out.println("[1] Debit");
//                    System.out.print("Select option: ");
//                    paymentMethodOption = scanner.nextLine();
//                }
//
//                if (paymentMethodOption.equals("0")) {
//                    paymentMethod = "Credit";
//                } else {
//                    paymentMethod = "Debit";
//                }
//
//                while (paymentNumber.isEmpty()) {
//                    System.out.print("Customer's payment number: ");
//                    paymentNumber = scanner.nextLine();
//                }
//            } else {
//                while (true) {
//                    System.out.print("ID of existing customer paying for new customer: ");
//                    existingCustomerID = scanner.nextLine();
//
//                    if (customers.isValidPayer(existingCustomerID)) {
//                        break;
//                    } else {
//                        System.out.printf("\"%s\" is not a valid paying customer ID.\n", existingCustomerID);
//                    }
//                }
//            }
//
//            // select supplement(s) that customer will subscribe to
//            while (true) {
//                System.out.printf("Enter a supplement ID or an empty entry to skip/continue: ");
//                supplementID = scanner.nextLine();
//
//                if (supplementID.equals("")) {
//                    break;
//                } else {
//                    if (mag.hasSupplement(supplementID)) {
//                        System.out.printf("** \"%s\" added.\n", supplementID);
//                        supplements.add(supplementID);
//                    } else {
//                        System.out.printf("\"%s\" is not a valid supplement.\n", supplementID);
//                    }
//                }
//            }
//
//            customers.add(
//                    name,
//                    email,
//                    supplements,
//                    paying.equals("y"),
//                    paymentMethod,
//                    paymentNumber,
//                    existingCustomerID
//            );
//
//            System.out.println("** Customer added.");
//        }
//    }

    /**
     * Collects input required for adding a new customer.
     * Part E
     * Performed by menu option [3].
     */
    private void promptAddAssociateCustomer() {
        String custName = "";
        String custEmail = "";
        String supplementID;
        Supplement supp;
        int suppId;
        List<String> supplements = new ArrayList<String>();
        AssociateCustomer associateCustomer = new AssociateCustomer();

        // add customer name
        while (custName.isEmpty()) {
            try {
                System.out.print("Customer's name: ");
                custName = scanner.nextLine();
                associateCustomer.setCustName(custName);
            } catch (Customer.InvalidDetailException e) {
                System.out.println(e);
                custName = "";
            }
        }

        // add customer email
        while (custEmail.isEmpty()) {
            try {
                System.out.print("Customer's email: ");
                custEmail = scanner.nextLine();
                associateCustomer.setCustEmail(custEmail);
            } catch (Customer.InvalidDetailException e) {
                System.out.println(e);
                custEmail = "";
            }
        }


        // select supplement(s) that customer will subscribe to
        while (true) {
            System.out.print("Would you like to subscribe to additional supplements? Enter a supplement ID or an empty entry to skip: ");
            System.out.println(magService.printAllSupplements());

            supplementID = scanner.nextLine();

            if (supplementID.equals("")) {
                break;
            } else {
                try {
                    suppId = Integer.parseInt(supplementID);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entry! Please try again!");
                    continue;
                }
                if ((supp = magService.getSupplement(suppId)) != null) {
                    System.out.println("Congratulations! You have subscribed to: " + supp.getSuppName());

                } else {
                    System.out.println(supplementID + " is not a valid supplement. Please try again!");
                }
            }
        }
//
//
//        while (!paying.equals("y") && !paying.equals("n")) {
//            System.out.print("Is the customer paying? (y/n) ");
//            paying = scanner.nextLine();
//        }
//
//        // change questions based on whether the customer is paying or an associate
//        if (paying.equals("y")) {
//            while (!paymentMethodOption.equals("0") && !paymentMethodOption.equals("1")) {
//                System.out.println("Select customer's payment method:");
//                System.out.println("[0] Credit");
//                System.out.println("[1] Debit");
//                System.out.print("Select option: ");
//                paymentMethodOption = scanner.nextLine();
//            }
//
//            if (paymentMethodOption.equals("0")) {
//                paymentMethod = "Credit";
//            } else {
//                paymentMethod = "Debit";
//            }
//
//            while (paymentNumber.isEmpty()) {
//                System.out.print("Customer's payment number: ");
//                paymentNumber = scanner.nextLine();
//            }
//        } else {
//            while (true) {
//                System.out.print("ID of existing customer paying for new customer: ");
//                existingCustomerID = scanner.nextLine();
//
//                if (customers.isValidPayer(existingCustomerID)) {
//                    break;
//                } else {
//                    System.out.printf("\"%s\" is not a valid paying customer ID.\n", existingCustomerID);
//                }
//            }
//        }
//
//
//        customers.add(
//                custName,
//                custEmail,
//                supplements,
//                paying.equals("y"),
//                paymentMethod,
//                paymentNumber,
//                existingCustomerID
//        );
//
//        System.out.println("** Customer added.");
    }

    /**
     * Display program's main options.
     */
    public void promptMainOptions() {
        while (runSystem) {
            System.out.println("-------------------------------------------------------");
            System.out.printf("Welcome to the \"%s\" management system.\n", "Scam Magazines");
            System.out.println("Please select an option below:");
            System.out.println("[1] Show weekly email for all customers.");
            System.out.println("[2] Show monthly email for paying customers.");
            System.out.println("[3] Add a customer.");
            System.out.println("[4] Remove a customer.");
            System.out.println("[5] List all customers.");
            System.out.println("[6] List all supplements.");
            System.out.println("[q] Exit the system.");
            System.out.println("-------------------------------------------------------");

            System.out.print("Select option: ");
            userInput = scanner.next().charAt(0);

            runOption(userInput);
        }
    }
}

