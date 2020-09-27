
import java.time.LocalDate;
import java.util.List;

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
    private MagazineService magService;

    /**
     * Generates a new MagazineService with 7 customers and 4 supplements
     */
    public Client() {

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

        // Part A: Construct Magazine
        Magazine mag1 = new Magazine("Programming Magazine", 12.20);
        Magazine mag2 = new Magazine("Cooking Magazine", 12.20);
        Magazine mag3 = new Magazine("Exercise Magazine", 12.20);
        Magazine mag4 = new Magazine("Empty Magazine", 12.20);
        MagazineService s = new MagazineService();
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

        AssociateCustomer newCust = new AssociateCustomer(custName, custEmail);
        this.magService.setAssociateCustomer(newCust);
    }
    /**
     * Part E
     * Adds new paying customer with name and email as input
     * @param custName: String
     * @param custEmail: String
     */
    public void addNewPayingCustomer(String custName, String custEmail) {

        PayingCustomer newCust = new PayingCustomer(custName, custEmail);
        this.magService.setMagPayingCustomer(newCust);
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

}

