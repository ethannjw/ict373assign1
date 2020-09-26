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
 */

public class MagazineService {
    private static AtomicInteger nextId = new AtomicInteger();
    private int serviceId;
    private List<Magazine> mags;
    private List<AssociateCustomer> magCustomers;
    private List<PayingCustomer> magBillCustomers;
    private List<Supplement> supplements;

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
        magBillCustomers = new ArrayList<PayingCustomer>();
        supplements = new ArrayList<Supplement>();
    }

    /**
     * Retrieves the serviceId
     * @return serviceId
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * Adds a Magazine to the list of magazines
     * @param mag: Magazine
     */
    public void setMags(Magazine mag) {
        this.mags.add(mag);
    }

    public List<Magazine> getMagazines() {
        return mags;
    }

    public void setSupplements(Supplement supplement) {
        this.supplements.add(supplement);
    }

    // customers
    public void setAssociateCustomer(AssociateCustomer magCustomer) {
        if (!this.magCustomers.contains(magCustomer)) {
            this.magCustomers.add(magCustomer);
        } else {
            System.out.println("Cannot insert duplicate customer!");
        }

    }

    public List<AssociateCustomer> getAssociateCustomers() {
        return this.magCustomers;
    }

    public boolean remCustomer(int custId){
        return this.magCustomers.removeIf(c -> c.getCustId() == custId);
    }

    public void remCustomer(AssociateCustomer magCustomers){
        try {
            this.magCustomers.remove(magCustomers);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error removing customer: " + magCustomers.getCustName() + '\n');
        }
    }

    // paying customers
    public void setMagBillCustomer(PayingCustomer PayingCustomer) {
        //need to check if there are duplicates and check if the Paying customer is already paying for someone that is being paid for
        this.magBillCustomers.add(PayingCustomer);
    }
    /**
     * Returns the weekly email for all magazines
     * @return weeklyEmail: String
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
     * @param magName
     * @return weeklyEmail: String
     */
    private String printWeeklyEmail(String magName) {
        String str = "";
        for (AssociateCustomer customer : this.magCustomers) {
            str = str.concat("From: customerservice@scammagazines.com" + "\n");
            str = str.concat("Recipient: " + customer.getCustEmail() + "\n");
            str = str.concat("Subject:" + "\n");
            str = str.concat("\t" + customer.getCustName() + ", your Weekly Magazine " + magName + " is ready for viewing!" + "\n");
            str = str.concat("Content:" + "\n");
            str = str.concat("Dear " + customer.getCustName() + "," + "\n");
            str = str.concat("\tPlease follow the following link to view your magazine: " + "\n");
            str = str.concat("\twww.tinyurl.com/fakeurl " + "\n");
            str = str.concat("\tAlong with your supplements: " + "\n");

            // for each index in customer.supplement
            for (Integer idx : customer.getSupplements()) {
                // for each available supplement
                for (Supplement s: this.supplements){
                    // check if the supplement has in customer
                    if (s.getSuppId() == idx){
                        str = str.concat("\t\t" + s.getName() + "\n");
                    }
                }
            }
            str = str.concat("\n");
        }
        return str; // return printWeeklyEmail(String magName)
    }
    /**
     * Get the monthly bill that sums all the subscription costs of each magazine
     * @return total: double
     */
    private double getBillsForMonth() {
        double total = 0.0;
        for (Magazine m : mags) {
            total += m.getMagWeeklyCost();
        }
        return total;
    }
    /**
     * Generates the monthly email for specified paying customer
     * @return monthly email: String
     */
    public String printMonthlyEmail(PayingCustomer payingCustomer) {
        String str = "";
        double magSubTotal = getBillsForMonth();
        Supplement currentSupp;
        double total = 0.0;
        int numAssociateCustomer = payingCustomer.getAssociateCustomers().size();
        str = str.concat("From: billing@scammagazines.com\n");
        str = str.concat("Recipient: " + payingCustomer.getCustEmail() + "\n");
        str = str.concat("Subject:\n");
        str = str.concat("\t" + payingCustomer.getCustName() + ", your bill for this month is ready for viewing!\n");
        str = str.concat("Content:\n");
        str = str.concat("Dear " + payingCustomer.getCustName() + ",\n");
        str = str.concat("\tHere is a list of customers you paying for: \n");
        // for each associate customer in paying customer
        for (Integer associateCustomerId : payingCustomer.getAssociateCustomers()) {
            // search for mag customer based on id
            for (AssociateCustomer associateCustomer : this.magCustomers) {
                if (associateCustomer.getCustId() == associateCustomerId) {
                    // Prints the customer name
                    str = str.concat("\tCustomer: " + associateCustomer.getCustName() + "\n");
                    for (Integer supplementId : associateCustomer.getSupplements()) {
                        for (Supplement s: this.supplements){
                            if (s.getSuppId() == supplementId) {
                                // prints each supplement and their cost
                                str = str.concat("\t\t" + s.getName() + " Cost: $" + s.getSupplementWeeklyCost() + "\n");
                                // add each subscription cost to total
                                total += s.getSupplementWeeklyCost();
                            }
                        }
                    }
                }
            }
        }
        // add to the total the total subscription for a month times total number of associate customers
        double subscriptionTotal = magSubTotal * numAssociateCustomer;
        total += subscriptionTotal;

        // prints the total bill
        str = str.concat("\tFor this month: \n");
        str = str.concat("\tTotal subscription bill (main magazine part): $" + subscriptionTotal + "\n");
        str = str.concat("\tTotal Bill: $" + total + "\n");
        //print out the payment details
        PaymentMethod paymentMethod = payingCustomer.getPaymentMethod();
        if (paymentMethod instanceof BankAccount) {
            str = str.concat("\tPayment will be deducted end of the month from bank account:" + "\n");
            str = str.concat("\t\tAccount Holder Name: " + paymentMethod.getPaymentName() + "\n");
            str = str.concat("\t\tBank Name: " + ((BankAccount) paymentMethod).getBank() + "\n");
            str = str.concat("\t\tBank Account Number: " + ((BankAccount) paymentMethod).getAccountNumber() + "\n");
        } else if (paymentMethod instanceof CreditCard) {
            str = str.concat("\tPayment will be deducted end of the month from credit card:" + "\n");
            str = str.concat("\t\tCredit Card Holder Name: " + paymentMethod.getPaymentName() + "\n");
            str = str.concat("\t\tCredit Card Number: " + ((CreditCard) paymentMethod).getCreditCardNumber() + "\n");
            str = str.concat("\t\tCredit Card Expiry: " + ((CreditCard) paymentMethod).getExpiry() + "\n");
        }
        str = str.concat("\n");
        return str; // printMonthlyEmails(PayingCustomer payingCustomer)
    }

    /**
     * Generates the monthly email for all paying customers
     * @return monthly email: String
     */
    public String printMonthlyEmails() {
        String str = "";
        // for each paying customer
        for (PayingCustomer payingCustomer : magBillCustomers) {
            str = str.concat(this.printMonthlyEmail(payingCustomer));
        }
        return str; // return printMonthlyEmail()
    }

    @Override
    public String toString() {
        String str = "";
        str = str.concat(this.printMonthlyEmails());
        str = str.concat(this.printWeeklyEmails());

        return str;
    }
}
