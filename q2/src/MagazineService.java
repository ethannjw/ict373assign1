
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
        total = new Total(0.0);
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
    public void setAssociateCustomer(AssociateCustomer magCustomer) {
        if (!this.magCustomers.contains(magCustomer)) {
            this.magCustomers.add(magCustomer);
        } else {
            System.out.println("Cannot insert duplicate customer!");
        }

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
     * Wrapper class that allows storing of a total variable assessable within this class.
     * Used for calculating the total cost of the customers
     * Consists of get and set method for a double variable
     * Consists of .add() method to add and .zero() to reset the total back to zero
     */
    private class Total {
        private double total;
        public Total(double total) {
            this.total = total;
        }
        public String toString(){
            return String.valueOf(this.total);
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public double getTotal() {
            return total;
        }

        public void add(double otherDouble) {
            this.total += otherDouble;
        }
        public void zero(){
            this.total = 0.0;
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
     * Get the monthly bill that sums all the subscription costs of each magazine
     * @return total: double
     */
    private double getBillsForMonth() {
        double magWeeklyCost = 0.0;
        for (Magazine m : mags) {
            magWeeklyCost += m.getMagWeeklyCost();
        }
        return magWeeklyCost;
    }
    /**
     * Generates the monthly email for specified paying customer
     * @param payingCustomer    Paying Customer for which the monthly email is to be generated
     * @return String           Monthly Email in String
     */
    public String printMonthlyEmail(PayingCustomer payingCustomer) {
        String str = "";
        Supplement currentSupp;
        // initialise the global variable total to zero to start
        total.zero();
        int numAssociateCustomer = payingCustomer.getAssociateCustomers().size();
        str = str.concat("From: billing@scammagazines.com\n");
        str = str.concat("Recipient: " + payingCustomer.getCustEmail() + "\n");
        str = str.concat("Subject:\n");
        str = str.concat("\t" + payingCustomer.getCustName() + ", your bill for this month is ready for viewing!\n");
        str = str.concat("Content:\n");
        str = str.concat("Dear " + payingCustomer.getCustName() + ",\n");
        str = str.concat("\tHere is a list of customers you paying for: \n");

        // print the paying customer supplement
        str = str.concat(printPayingCustomerSupplement(payingCustomer));

        // add to the total the total subscription for a month times total number of associate customers
        double subscriptionTotal = getBillsForMonth() * numAssociateCustomer;
        total.add(subscriptionTotal);

        // prints the total bill
        str = str.concat("\tFor this month: \n");
        str = str.concat("\tTotal subscription bill (main magazine part): $" + subscriptionTotal + "\n");
        str = str.concat("\tTotal Bill: $" + total + "\n");
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
     * Generates the supplements for each associate customer for specified paying customer
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
                        str = str.concat("\t\t" + s.getSuppName() + " Cost: $" + s.getSupplementWeeklyCost() + "\n");
                        // add each subscription cost to total
                        total.add(s.getSupplementWeeklyCost());
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
