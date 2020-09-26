import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Client client = new Client();
        client.displayStudentDetails();
        System.out.println(client.getMagService()); // checking to String mtd in magservice class
        client.printWeeklyEmails();
        client.printMonthlyEmails();
        client.addNewAssociateCustomer("Jonathan New", "Jonathan@email.com");
        client.addNewAssociateCustomer("Jonathan New", "Jonathan@email.com");   // check if the check duplicate is working
        client.printWeeklyEmails();
        client.removeAssociateCustomer("Jonathan New", "Jonathan@email.com");
        client.removeAssociateCustomer("Jonathan New", "Jonathan@email.com");   // check if remove missing customer is working
        client.printWeeklyEmails();

        client.addNewPayingCustomer("Kenneth New", "kenneth@email.com");
        client.addNewPayingCustomer("Kenneth New", "kenneth@email.com");    // check duplicate check
        client.removePayingCustomer("Kenneth New", "kenneth@email.com");
        client.removePayingCustomer("Kenneth New", "kenneth@email.com");    // check duplicate check






    }
}
