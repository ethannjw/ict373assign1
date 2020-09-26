import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Client client = new Client();
        client.displayStudentDetails();
        System.out.println(client.getMagService());
        client.printWeeklyEmails();
        client.printMonthlyEmails();
        client.addNewAssociateCustomer("Jonathan New", "Jonathan@email.com");
        client.addNewAssociateCustomer("Jonathan New", "Jonathan@email.com");
        client.printWeeklyEmails();








    }
}
