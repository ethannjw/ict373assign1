
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title       Magazine
 * @desc        This class is to define a weekly magazine.
 * @filename    Magazine.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public class Magazine {
    private static AtomicInteger nextId = new AtomicInteger();
    private int magId;
    private String magName;
    private double magWeeklyCost;

    /**
     * Constructor
     * Initialises the magazine id, magazine name and magazine cost
     * @param magName           Name of magazine in String
     * @param magWeeklyCost     Weekly cost of magazine in double
     */
    public Magazine(String magName, double magWeeklyCost) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeeklyCost(magWeeklyCost);
    }

    /**
     * Retrieves the magId
     * @return magId    The magazine unique identifier
     */
    public int getMagId() {
        return magId;
    }

    /**
     * Retrieves the magazine name
     * @return magName    The magazine name string
     */
    public String getMagName() {
        return magName;
    }

    /**
     * Sets the magazine name
     * @param magName       The magazine name string
     * @return boolean      Returns true if successful, false if not
     */
    public boolean setMagName(String magName) {
        if (magName.length() > 0) {
            this.magName = magName;
            return true;
        } else {
            System.out.println("Name must be having a length of more than 1! Try again!");
            return false;
        }
    }

    /**
     * Sets the magazine cost
     * @param magazineWeeklyCost    The magazine cost double
     * @return boolean              Return successful if successful setting, false if not
     */
    public boolean setMagWeeklyCost(double magazineWeeklyCost) {
        if (magazineWeeklyCost > 0) {
            this.magWeeklyCost = magazineWeeklyCost;
            return true;
        } else {
            System.out.println("Magazine Weekly Cost cannot be negative! Try again!");
            return false;
        }
    }

    /**
     * Retrieves the magazine cost
     * @return magName    The magazine cost double
     */
    public double getMagWeeklyCost() {
        return this.magWeeklyCost;
    }

    /**
     * To string method
     * @return string    String representation of class
     */
    @Override
    public String toString() {
        return "Magazine: \n" +
                "magazine ID: " + magId + '\n' +
                "magazine Name: " + magName + '\n' +
                "magazine Weekly Cost: $" + magWeeklyCost + '\n' +
                "Customers: " + '\n';
    }

    /**
     * Overrides the equals method to check for equality by checking the Name and cost
     * @param otherMagazine     magazine class to be compared
     * @return boolean    Returns true if both are equals, false if not
     */
    @Override
    public boolean equals(Object otherMagazine) {
        Magazine magazine = (Magazine) otherMagazine;

        if (magazine.getMagWeeklyCost() != this.magWeeklyCost) {
            return false;
        }
        if (!magazine.getMagName().equalsIgnoreCase((this.magName))) {
            return false;
        }
        return true;
    }

}
