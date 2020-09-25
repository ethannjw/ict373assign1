import java.lang.reflect.Array;
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
        //need to check if there are duplicates
        this.magBillCustomers.add(PayingCustomer);
    }

    public void printWeeklyEmail() {
        /**
         * Prints out the weekly email for all magazine and customer
         * @param AssociateCustomer customer
         */
        //loop through all magazines
        for (Magazine m : this.mags) {
            //loop through all customers
            for (AssociateCustomer customer : this.magCustomers) {
                System.out.println("Customers name: " + customer.getCustName());
                System.out.println("Your magazine: " + m.getMagName() + " is ready.");
                System.out.println("Along with your supplements: ");

                // for each index in customer.supplement
                for (Integer idx : customer.getSupplements()) {
                    // for each available supplement
                    System.out.println(this.supplements.get(idx).getName());

                }
            }
            System.out.println("\n");
        }
    }

    public void printWeeklyEmail(int magId) {
        /**
         * Prints out the weekly email for all magazine and customer
         * @param AssociateCustomer customer
         * @param int magWeek
         */
        String magName = "";
        try {
            magName = mags.get(magId).getMagName();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to find specified Magazine");
            return;
        }
        for (AssociateCustomer customer : this.magCustomers) {
            System.out.println("Customers name: " + customer.getCustName());
            System.out.println("Your magazine: " + magName + " is ready.");
            System.out.println("Along with your supplements: ");

            // for each index in customer.supplement
            for (Integer idx : customer.getSupplements()) {
                // for each available supplement
                System.out.println(this.supplements.get(idx).getName());

            }
            System.out.println("\n");
        }
    }

    public void printMonthlyEmail() {

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
