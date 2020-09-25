import java.rmi.NoSuchObjectException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private MagazineService magService;

    public Client() {
        /**
         * Generates a new MagazineService with 7 customers and 4 supplements
         */
        magService = generateMagazineService();
    }

    public MagazineService getMagService() {
        return magService;
    }

    public static void displayStudentDetails() {
        System.out.println("----------------------------------------------------------");
        System.out.println("Name: Ethan Ng");
        System.out.println("Student Number: 33804877");
        System.out.println("Mode of Enrolment: External");
        System.out.println("Tutor Name: Chong Siew Cheong");
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }

    public static MagazineService generateMagazineService() {
        /**
         * Generates a new MagazineService with 7 customers and 4 supplements
         * @return MagazineService
        */
        Magazine mag1 = new Magazine("Magazine", 12.20);
        // Part A: Construct Magazine
        MagazineService s = new MagazineService();
        s.setMags(mag1);
        Supplement sup1 = new Supplement("Java Rocks", 32.32);
        Supplement sup2 = new Supplement("Go Lang!", 2.34);
        Supplement sup3 = new Supplement("WooHoo", 12.3);
        Supplement sup4 = new Supplement("The Grind", 2.50);
        s.setSupplements(sup1);
        s.setSupplements(sup2);
        s.setSupplements(sup3);
        s.setSupplements(sup4);
        // Part B: Construct Customers
        AssociateCustomer cust1 = new AssociateCustomer("John Lim", "john.lim@email.com");
        cust1.setSupplement(1);
        cust1.setSupplement(3);
        AssociateCustomer cust2 = new AssociateCustomer("Jayne Petersen", "john.lim@email.com");
        cust2.setSupplement(1);
        cust2.setSupplement(0);
        AssociateCustomer cust3 = new AssociateCustomer("Brian Meadows", "john.lim@email.com");
        cust3.setSupplement(1);
        cust3.setSupplement(2);
        cust3.setSupplement(3);
        cust3.setSupplement(0);
        AssociateCustomer cust4 = new AssociateCustomer("Chloe-Ann Manning", "john.lim@email.com");
        cust4.setSupplement(3);
        s.setAssociateCustomer(cust1);
        s.setAssociateCustomer(cust2);
        s.setAssociateCustomer(cust3);
        s.setAssociateCustomer(cust4);

        PayingCustomer payer1 = new PayingCustomer("John Lim", "john.doe@email.com");
        PayingCustomer payer2 = new PayingCustomer("Jayne Petersen", "john.doe@email.com");
        PayingCustomer payer3 = new PayingCustomer("Alan Burnett", "john.doe@email.com");
        CreditCard cc1 = new CreditCard("Lim Swee Keat", "1234 5678 9102 1234", LocalDate.of(2023, 5, 1));
        CreditCard cc2 = new CreditCard("Tim Petersen", "1234 9851 4592 1984", LocalDate.of(2024, 1, 1));
        BankAccount ba1 = new BankAccount("Alan Burnett", "123-56784-981", "ABC Bank");

        payer1.setPaymentMethod(cc1);
        payer1.setAssociateCustomer(cust1);
        payer2.setPaymentMethod(cc2);
        payer2.setAssociateCustomer(cust2);
        payer3.setPaymentMethod(ba1);
        payer3.setAssociateCustomer(cust3);
        payer3.setAssociateCustomer(cust4);

        s.setMagBillCustomer(payer1);
        s.setMagBillCustomer(payer2);
        s.setMagBillCustomer(payer3);

        return s;
    }

    public void printWeeklyEmails() {
        // Part C
        magService.printWeeklyEmail();
    }

    public void printWeeklyEmails(int magId) {
        // Part C
        magService.printWeeklyEmail(magId);
    }

    public static void printMonthlyEmails() {
        // Part D
    }

    public void addNewAssociateCustomer(String custName, String custEmail) {
        /**
         * Part E
         * Adds new associate customer with name and email as input
         * @param String custName
         * @param String custEmail
         */
        AssociateCustomer newCust = new AssociateCustomer(custName, custEmail);
        this.magService.setAssociateCustomer(newCust);
    }

    public void addNewPayingCustomer(String custName, String custEmail) {
        /**
         * Part E
         * Adds new paying customer with name and email as input
         * @param custName: String
         * @param custEmail: String
         */
        PayingCustomer newCust = new PayingCustomer(custName, custEmail);
        this.magService.setMagBillCustomer(newCust);
    }

    public void removeAssociateCustomer(String custName) {
        /**
         * Part F
         * Removes the first customer that matches the custName
         * @param custName: String
         */
        List<AssociateCustomer> cust = this.magService.getAssociateCustomers();
        for (AssociateCustomer c : cust) {
            if (c.getCustName().equals(custName)) {
                // Found customer to delete
                if (this.magService.remCustomer(c.custId)) {
                    System.out.println("Successfully removed customer: " + c.getCustName() + "\n");
                    return; // customer removal success
                } else {
                    System.out.println("Unable to remove customer: " + c.getCustName());
                }
            }
        }
        System.out.println("No such customer");
    }

}

