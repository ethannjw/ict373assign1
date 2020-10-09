
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title       MagazineService
 * @desc        This class is to define the magazine service system and its attributes.
 * @filename    MagazineService.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 * @// TODO: 9/27/2020 Add functionality to remove supplement, first checking for usages
 */

public class MagazineService {
    private static AtomicInteger nextId = new AtomicInteger();
    private int serviceId;
    private List<Magazine> mags;
    private List<AssociateCustomer> magCustomers;
    private List<PayingCustomer> magPayingCustomers;
    private List<Supplement> supplements;
    private static Total total;
    /**
     * Empty Constructor
     * Initialises the service id, a list of Magaazines, a list of AssociateCustomers, a list of PayingCustomers and a
     * list of supplements
     *
     */
    public MagazineService() {
        serviceId = nextId.incrementAndGet();
        mags = new ArrayList<Magazine>();
        magCustomers = new ArrayList<AssociateCustomer>();
        magPayingCustomers = new ArrayList<PayingCustomer>();
        supplements = new ArrayList<Supplement>();
        total = new Total();
    }

    /**
     * Retrieves the serviceId
     * @return serviceId    The magazine service unique identifier
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * Adds a Magazine to the list of magazines
     * @param mag       A new instance of Magazine
     * @return boolean  Return true if successful addition, false if unsuccessful
     */
    public boolean setMagazine(Magazine mag) {
        if (this.mags.contains(mag)) {
            System.out.println("Cannot insert duplicate magazine!");
            return false;
        }
        this.mags.add(mag);
        return true;
    }

    /**
     * Returns the list of magazines currently present in the class
     * @return mag   The list of of Magazines currently present
     */
    public List<Magazine> getMagazines() {
        return mags;
    }

    /**
     * Returns the list of Paying customers currently present in the class
     * @return payingCustomers   The list of of paying customers currently present
     */
    public List<PayingCustomer> getMagPayingCustomers() {
        return magPayingCustomers;
    }

    /**
     * Returns the Paying customer with name pass in as parameter
     * @param custName          The name of the customer
     * @return payingCustomers  The list of of paying customers currently present, empty list or null if not found
     */
    public PayingCustomer getMagPayingCustomer(String custName) {
        for (PayingCustomer customer: this.magPayingCustomers) {
            if (customer.getCustName().equalsIgnoreCase(custName)) {
                return customer;
            }
        }
        return null;
    }


    /**
     * Adds a supplement to the list of supplements
     * @param supplement    A new instance of supplement
     * @return boolean      True if the supplement is successfully added, false if not
     */
    public boolean setSupplement(Supplement supplement) {
        if (this.supplements.contains(supplement)) {
            System.out.println("Cannot insert duplicate supplement!");
            return false;
        }
        this.supplements.add(supplement);
        return true;
    }

    /**
     * Get the list of supplements
     * @return The list of supplements
     */
    public List<Supplement> getSupplements() {
        return this.supplements;
    }

    /**
     * Get a supplement based on supplement ID
     * @param supplementId  The ID of the supplement
     * @return supplement   The requested supplement object. Null if not found
     */
    public Supplement getSupplement(int supplementId) {
        for (Supplement s : this.supplements) {
            if (s.getSuppId() == supplementId) {
                return s;
            }
        }
        return null;
    }

    /**
     * inserts a specified paying customer
     * @param payingCustomer    PayingCustomer
     * @return boolean          true if successful insertion false if not
     */
    public boolean setMagPayingCustomer(PayingCustomer payingCustomer) {
        //check if there are duplicates and check if the Paying customer is already paying for someone that is being paid for
        if (this.magPayingCustomers.contains(payingCustomer)) {
            System.out.println("Cannot insert duplicate customer!");
            return false;
        }
        // for the incoming paying customer each associate customers it is paying for
        for (int a : payingCustomer.getAssociateCustomers()) {
            // get the paying customers from this.magBillCustomers
            for (PayingCustomer c: magPayingCustomers) {
                // for each associate customer the current paying customers are paying for
                for (int paidFor: c.getAssociateCustomers()) {
                    // if any customer is found to be paid for
                    if (paidFor == a ) {
                        System.out.println(c.getCustName() + " has already been paid for! Cannot insert!");
                        return false;
                    }
                }
            }
        }
        this.magPayingCustomers.add(payingCustomer);
        return true;
    }

    /**
     * inserts a specified associate customer
     * @param magCustomer   Insert an Associate Customer into the service
     */
    public boolean setAssociateCustomer(AssociateCustomer magCustomer) {
        if (this.magCustomers.contains(magCustomer)) {
            System.out.println("Cannot insert duplicate customer!");
            return false;
        }
        this.magCustomers.add(magCustomer);
        return true;

    }

    /**
     * Returns the list of AssociateCustomer
     * @return associateCustomer    Returns the List of Associate Customers currently present
     */
    public List<AssociateCustomer> getAssociateCustomers() {
        return this.magCustomers;
    }

    /**
     * Returns the AssociateCustomer based on name
     * @param custName              Name of customer in String
     * @return associateCustomer    Returns the List of Associate Customers currently present
     */
    public AssociateCustomer getAssociateCustomer(String custName) {
        for (AssociateCustomer customer: this.magCustomers) {
            if (customer.getCustName().equalsIgnoreCase(custName)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Removes a specified customer the weekly email for all magazines based on customer ID
     * @param custId: int
     * @return boolean  true if successful removal
     */
    public boolean remCustomer(int custId){
        return this.magCustomers.removeIf(c -> c.getCustId() == custId);
    }

    /**
     * Removes a specified customer the weekly email for all magazines
     * @param magCustomer   Associate Customer class instance to be removed
     * @return boolean  true if successful removal
     */
    public boolean remCustomer(AssociateCustomer magCustomer){
        try {
            this.magCustomers.remove(magCustomer);
            return true;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error removing customer: " + magCustomer.getCustName() + '\n');
            return false;
        }
    }

    /**
     * Removes a specified customer the weekly email for all magazines
     * @param magPayingCustomer     Instance of PayingCustomer to be removed
     * @return boolean  true if successful removal
     */
    public boolean remCustomer(PayingCustomer magPayingCustomer){
        try {
            this.magPayingCustomers.remove(magPayingCustomer);
            return true;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error removing customer: " + magPayingCustomer.getCustName() + '\n');
            return false;
        }
    }

    /**
     * Public method that returns the weekly email for a specified magazine
     * @param magazine      Magazine object which the email is to be generated
     * @return weeklyEmail  String of weekly email for magazine
     */
    public String printWeeklyEmail(Magazine magazine) {
        String str = "";
        //loop through all magazines
        for (Magazine m : this.mags) {
            if (m.equals(magazine)) {
                str = str.concat("Magazine: " + m.getMagName() + "\n\n");
                //loop through all customers
                str = str.concat(this.printWeeklyEmail(m.getMagName()));
            }
        }
        return str;
    }

    /**
     * Public method that returns the weekly email for all magazines in string format
     * @return weeklyEmail  String of all weekly email
     */
    public String printWeeklyEmails() {
        String str = "";
        //loop through all magazines
        for (Magazine m : this.mags) {
            str = str.concat("Magazine: " + m.getMagName() + "\n\n");
            //loop through all customers
            str = str.concat(this.printWeeklyEmail(m.getMagName()));
        }
        return str;
    }

    /**
     * Prints out the weekly email for a magazine and all its customers
     * @param magName   Specified Magazine name string
     * @return weeklyEmail: String
     */
    private String printWeeklyEmail(String magName) {
        String str = "";
        for (AssociateCustomer associateCustomer : this.magCustomers) {
            str = str.concat("From: customerservice@scammagazines.com" + "\n");
            str = str.concat("Recipient: " + associateCustomer.getCustEmail() + "\n");
            str = str.concat("Subject:" + "\n");
            str = str.concat("\t" + associateCustomer.getCustName() + ", your Weekly Magazine " + magName + " is ready for viewing!" + "\n");
            str = str.concat("Content:" + "\n");
            str = str.concat("Dear " + associateCustomer.getCustName() + "," + "\n");
            str = str.concat("\tPlease follow the following link to view your magazine: " + "\n");
            str = str.concat("\twww.tinyurl.com/fakeurl " + "\n");
            str = str.concat("\tAlong with your supplements: " + "\n");

            // print the supplement for the associate customer
            str = str.concat(printCustomerListOfSupplements(associateCustomer, false));

            str = str.concat("\n");
        }
        return str; // return printWeeklyEmail(String magName)
    }

    /**
     * Wrapper class that allows storing of a subscription and supplement totals assessable within this class.
     * Used for calculating and displaying customer costs
     * Consists of number of week (default 4) and number of associate customer (default 1) with corresponding set methods
     * Consists of get and set method for subscriptions and supplements double variables
     * Consists of .zero() to reset the values back to zero
     */
    private class Total {
        private int numAssociateCustomers = 1;
        private double subscriptions;
        private int numWeek = 4;
        private double supplements;

        public Total() {
            subscriptions = 0;
            supplements = 0;
        }
        public double getTotalSupplements() {
            return (supplements*numWeek);
        }
        public double getTotalSubscriptions() {
            return (subscriptions*numAssociateCustomers);
        }
        public double getTotal() {
            return getTotalSubscriptions() + getTotalSupplements();
        }
        public void setNumWeek(int numWeek){
            this.numWeek = numWeek;
        }
        public void setNumAssociateCustomers(int numAssociateCustomers){
            this.numAssociateCustomers = numAssociateCustomers;
        }
        public void addSubscription(double subscriptionCost) {
            this.subscriptions += subscriptionCost;
        }
        public void addSupplement(double supplementCost) {
            this.supplements += (supplementCost);
        }
        public void zero(){
            this.subscriptions = 0.0;
            this.supplements = 0.0;
        }
    }

    /**
     * Adds the bills for last month that sums all the subscription costs of each magazine
     * This is meant for calculating the total cost for each paying customer in printMonthlyEmail(PayingCustomer payingCustomer)
     * @return total number of weeks of last month
     */
    private int getSubscriptionsForLastMonth() {
        double subscriptionTotal = 0.0;
        int numWeeks = 0;
        LocalDate today = LocalDate.now();
        for (Magazine m : mags) {
            if (m.getMagMonth() == (today.getMonthValue()-1)) { // loop through only last month emails
                subscriptionTotal += (m.getMagWeeklyCost());
                numWeeks += 1;
            }
        }
        total.addSubscription(subscriptionTotal);
        return numWeeks;
    }
    /**
     * Generates the monthly email for specified paying customer
     * @param payingCustomer    Paying Customer for which the monthly email is to be generated
     * @return String           Monthly Email in String
     */
    public String printMonthlyEmail(PayingCustomer payingCustomer) {
        String str = "";
        Supplement currentSupp;
        int numWeeks = 0;
        // initialise the global variable total to zero to start
        total.zero();
        total.setNumAssociateCustomers(payingCustomer.getAssociateCustomers().size());
        // add to the total the total subscription for a month times total number of associate customers
        numWeeks = getSubscriptionsForLastMonth();
        total.setNumWeek(numWeeks);

        str = str.concat("From: billing@scammagazines.com\n");
        str = str.concat("Recipient: " + payingCustomer.getCustEmail() + "\n");
        str = str.concat("Subject:\n");
        str = str.concat("\t" + payingCustomer.getCustName() + ", your bill for this month is ready for viewing!\n");
        str = str.concat("Content:\n");
        str = str.concat("Dear " + payingCustomer.getCustName() + ",\n");
        str = str.concat("\tHere is a list of customers you paying for: \n");

        // print the paying customer supplement, and also add the supplement cost
        str = str.concat(printPayingCustomerSupplement(payingCustomer));

        // prints the total bill
        str = str.concat("\tFor this month: \n");
        str = str.concat("\tTotal subscription bill (main magazine part): $" + String.format("%.2f", total.getTotalSubscriptions()) + "\n");
        str = str.concat("\tTotal subscription bill (supplements): $" + String.format("%.2f", total.getTotalSupplements()) + "\n");
        str = str.concat("\tTotal Bill: $" + String.format("%.2f", total.getTotal()) + "\n");
        //print out the payment details
        PaymentMethod paymentMethod = payingCustomer.getPaymentMethod();
        if (paymentMethod instanceof BankAccount) {
            str = str.concat("\tPayment will be deducted end of the month from bank account:" + "\n");
            str = str.concat("\t\tAccount Holder Name: " + paymentMethod.getPayerName() + "\n");
            str = str.concat("\t\tBank Name: " + ((BankAccount) paymentMethod).getBankName() + "\n");
            str = str.concat("\t\tBank Account Number: " + ((BankAccount) paymentMethod).getAccountNumber() + "\n");
        } else if (paymentMethod instanceof CreditCard) {
            str = str.concat("\tPayment will be deducted end of the month from credit card:" + "\n");
            str = str.concat("\t\tCredit Card Holder Name: " + paymentMethod.getPayerName() + "\n");
            str = str.concat("\t\tCredit Card Number: " + ((CreditCard) paymentMethod).getCreditCardNumber() + "\n");
            str = str.concat("\t\tCredit Card Expiry: " + ((CreditCard) paymentMethod).getExpiry() + "\n");
        }
        str = str.concat("\n");
        return str; // printMonthlyEmails(PayingCustomer payingCustomer)
    }
    /**
     * Generates the supplements for each associate customer for specified paying customer
     * @param payingCustomer
     * @return text of all associate customers supplements in String
     */
    private String printPayingCustomerSupplement(PayingCustomer payingCustomer) {
        String str = "";
        // for each associate customer in paying customer
        for (Integer associateCustomerId : payingCustomer.getAssociateCustomers()) {
            for (AssociateCustomer associateCustomer : this.magCustomers) {
                // search for mag customer based on id
                if (associateCustomer.getCustId() == associateCustomerId) {
                    // Prints the customer name
                    str = str.concat("\tCustomer: " + associateCustomer.getCustName() + "\n");
                    // for each customer
                    str = str.concat(printCustomerListOfSupplements(associateCustomer, true));
                }
            }
        }
        return str;
    }
    /**
     * Generates the supplements for each associate customer for specified paying customer, while also adding the
     * supplement cost into total
     * @param associateCustomer associate customer to print
     * @param printCost     true/false sums up the cost to the total private class and prints the cost of supplement for each
     * @return text of all associate customer supplements in String
     */
    private String printCustomerListOfSupplements(AssociateCustomer associateCustomer, boolean printCost) {
        String str = "";
        // for each customer
        for (Integer supplementId : associateCustomer.getSupplements()) {
            for (Supplement s : this.supplements) {
                if (s.getSuppId() == supplementId) {
                    // prints each supplement and their cost
                    if (printCost) {
                        str = str.concat("\t\t" + s.getSuppName() + " Cost: $" + String.format("%.2f", s.getSupplementWeeklyCost()) + "\n");
                        // add each subscription cost to total
                        total.addSupplement(s.getSupplementWeeklyCost());
                    } else {
                        str = str.concat("\t\t" + s.getSuppName() + "\n");
                    }
                }
            }
        }
        return str;
    }
    /**
     * Generates the monthly email for all paying customers
     * @return monthly email: String
     */
    public String printMonthlyEmails() {
        String str = "";
        // for each paying customer
        for (PayingCustomer payingCustomer : magPayingCustomers) {
            str = str.concat(this.printMonthlyEmail(payingCustomer));
        }
        return str; // return printMonthlyEmail()
    }

    /**
     * Generates the list of available supplements with ID and name
     * @return list of supplements in String
     */
    public String printAllSupplements() {
        String str = "";
        for (Supplement s : this.supplements) {
            str = str.concat("Supplement ID: " + s.getSuppId() + " Name: " + s.getSuppName() + "\n");
        }
        return str;
    }

    /**
     * check if supplement ID exists
     * @param supplementId  in int
     * @return true if such ID exists, false if not
     */
    public boolean hasSupplement(int supplementId) {
        for (Supplement s : this.supplements) {
            if (s.getSuppId() == supplementId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        str = str.concat(this.printMonthlyEmails());
        str = str.concat(this.printWeeklyEmails());

        return str;
    }
}
