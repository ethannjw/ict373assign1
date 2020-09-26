import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MagazineService {
    private static AtomicInteger nextId = new AtomicInteger();
    private int serviceId;
    private List<Magazine> mags;
    private List<AssociateCustomer> magCustomers;
    private List<PayingCustomer> magBillCustomers;
    private List<Supplement> supplements;

    public MagazineService() {
        serviceId = nextId.incrementAndGet();
        mags = new ArrayList<Magazine>();
        magCustomers = new ArrayList<AssociateCustomer>();
        magBillCustomers = new ArrayList<PayingCustomer>();
        supplements = new ArrayList<Supplement>();
    }

    public int getServiceId() {
        return serviceId;
    }

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
    public void setAssociateCustomer(ArrayList<AssociateCustomer> magCustomers) {
        this.magCustomers = magCustomers;
    }

    public void setAssociateCustomer(AssociateCustomer magCustomer) {
        this.magCustomers.add(magCustomer);
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
     * Prints out the weekly email for all magazine and customer
     */
    public void printWeeklyEmails() {

        //loop through all magazines
        for (Magazine m : this.mags) {
            //loop through all customers
            this.printWeeklyEmail(m.getMagName());
        }
    }
    /**
     * Prints out the weekly email for magazine
     * @param magName
     */
    private void printWeeklyEmail(String magName) {

        for (AssociateCustomer customer : this.magCustomers) {
            System.out.println("From: customerservice@scammagazines.com");
            System.out.println("Recipient: " + customer.getCustEmail());
            System.out.println("Subject:");
            System.out.println("\t" + customer.getCustName() + ", your Weekly Magazine " + magName + " is ready for viewing!");
            System.out.println("Content:");
            System.out.println("Dear " + customer.getCustName() + ",");
            System.out.println("\tPlease follow the following link to view your magazine: ");
            System.out.println("\twww.tinyurl.com/fakeurl ");
            System.out.println("\tAlong with your supplements: ");

            // for each index in customer.supplement
            for (Integer idx : customer.getSupplements()) {
                // for each available supplement
                System.out.println("\t\t" + this.supplements.get(idx).getName());

            }
            System.out.println("\n");
        }
    }
    /**
     * Calculates the bill for each customer
     */
    private double printAndCalculateBills(PayingCustomer payingCustomer) {
        double total = 0.0;
        Supplement currentSupp;
        // for each associate customer in paying customer
        for (Integer associateCustomerId : payingCustomer.getAssociateCustomers()) {
            // search for mag customer based on id
            for (AssociateCustomer associateCustomer : this.magCustomers){
                if (associateCustomer.getCustId() == associateCustomerId) {
                    // Prints the customer name
                    System.out.println("\tCustomer: " + associateCustomer.getCustName());
                    for (Integer supplementId : associateCustomer.getSupplements()) {
                        currentSupp = this.supplements.get(supplementId);
                        // prints each supplement and their cost
                        System.out.println("\t\t" + currentSupp.getName() + " Cost: $" + currentSupp.getSupplementWeeklyCost());
                        total += currentSupp.getSupplementWeeklyCost();
                    }
                }
            }
        }
        return total;
    }
    private double getBillsForMonth() {
        double total = 0.0;
        for (Magazine m : mags) {
            total += m.getMagWeeklyCost();
        }
        return total;
    }
    /**
     *
     */
    public void printMonthlyEmail() {
        String str = "";
        double magSubTotal = getBillsForMonth();
        Supplement currentSupp;
        // for each paying customer
        for (PayingCustomer payingCustomer : magBillCustomers) {
            double total = 0.0;
            int numAssociateCustomer = payingCustomer.getAssociateCustomers().size();
            System.out.println("From: billing@scammagazines.com");
            System.out.println("Recipient: " + payingCustomer.getCustEmail());
            System.out.println("Subject:");
            System.out.println("\t" + payingCustomer.getCustName() + ", your bill for this month is ready for viewing!");
            System.out.println("Content:");
            System.out.println("Dear " + payingCustomer.getCustName() + ",");
            System.out.println("\tThere is a list of customers you paying for: ");
            // for each associate customer in paying customer
            for (Integer associateCustomerId : payingCustomer.getAssociateCustomers()) {
                // search for mag customer based on id
                for (AssociateCustomer associateCustomer : this.magCustomers) {
                    if (associateCustomer.getCustId() == associateCustomerId) {
                        // Prints the customer name
                        System.out.println("\tCustomer: " + associateCustomer.getCustName());
                        for (Integer supplementId : associateCustomer.getSupplements()) {
                            currentSupp = this.supplements.get(supplementId);
                            // prints each supplement and their cost
                            System.out.println("\t\t" + currentSupp.getName() + " Cost: $" + currentSupp.getSupplementWeeklyCost());
                            // add each subscription cost to total
                            total += currentSupp.getSupplementWeeklyCost();
                        }
                    }
                }
            }
            // add to the total the total subscription for a month times total number of associate customers
            double subscriptionTotal = magSubTotal * numAssociateCustomer;
            total += subscriptionTotal;

            // prints the total bill
            System.out.println("For this month:");
            System.out.println("Total subscription bill (main magazine part): $" + subscriptionTotal);
            System.out.println("Total Bill: $" + total);
            //print out the payment details
            PaymentMethod paymentMethod = payingCustomer.getPaymentMethod();
            if (paymentMethod instanceof BankAccount) {
                System.out.println("Payment will be deducted end of the month from bank account:");
                System.out.println("\tAccount Holder Name: " + paymentMethod.getPaymentName());
                System.out.println("\tBank Name: " + ((BankAccount) paymentMethod).getBank());
                System.out.println("\tBank Account Number: " + ((BankAccount) paymentMethod).getAccountNumber());
            } else if (paymentMethod instanceof CreditCard) {
                System.out.println("Payment will be deducted end of the month from credit card:");
                System.out.println("\tCredit Card Holder Name: " + paymentMethod.getPaymentName());
                System.out.println("\tCredit Card Number: " + ((CreditCard) paymentMethod).getCreditCardNumber());
                System.out.println("\tCredit Card Expiry: " + ((CreditCard) paymentMethod).getExpiry());
            }

            System.out.println();

        }
    }

    @Override
    public String toString() {
        String str = "";
        // Customers
        for (AssociateCustomer c : this.magCustomers) {
            str = str.concat(c.getCustName());
            str = str.concat("\n");
        }
        return "MagazineService{" +
                "serviceId=" + serviceId +
                ", mags=" + mags +
                ", magCustomers=" + magCustomers +
                ", magBillCustomers=" + magBillCustomers +
                ", supplements=" + supplements +
                '}';
    }
}
