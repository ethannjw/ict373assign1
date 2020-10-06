
/**
 * @title   Main
 * @desc    Main class that runs the menu for user navigation
 * @filename Main.java
 * @version 0.1
 * @date    01/10/2020
 * @author  Ethan Ng
 */

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        client.displayStudentDetails();
        client.promptMainOptions();
    }
}
