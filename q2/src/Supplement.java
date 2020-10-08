import java.util.concurrent.atomic.AtomicInteger;

/**
 * @title       Supplement
 * @desc        This class is to define a magazine supplement.
 * @filename    Supplement.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public class Supplement {
    private static AtomicInteger nextId = new AtomicInteger();
    private int suppId;
    private String suppName;
    private Double supplementWeeklyCost;

    /**
     * Constructor
     * Initialises the supplement id, supplement name and cost
     * @param suppName              Name of supplement in String
     * @param supplementWeeklyCost  Weekly cost of supplement in double
     */
    public Supplement(String suppName, Double supplementWeeklyCost) {
        this.suppId = nextId.incrementAndGet();
        this.setSuppName(suppName);
        this.setSupplementWeeklyCost(supplementWeeklyCost);
    }

    /**
     * Retrieves the supplement Id
     * @return suppId    The supplement unique identifier
     */
    public int getSuppId() {
        return suppId;
    }

    /**
     * Gets the supplement name.
     * @return supplementName    The supplement name string
     */
    public String getSuppName() {
        return this.suppName;
    }

    /**
     * Sets the supplement name. Name cannot have length zero
     * @param suppName       The magazine name string
     * @return boolean      Returns true if successful, false if not
     */
    public boolean setSuppName(String suppName) {
        if (suppName.length() > 0) {
            this.suppName = suppName;
            return true;
        } else {
            System.out.println("Name must be having a length of more than 1! Try again!");
            return false;
        }
    }

    /**
     * Gets the supplement cost.
     * @return supplementWeeklyCost    The supplement cost in double
     */
    public Double getSupplementWeeklyCost() {
        return this.supplementWeeklyCost;
    }

    /**
     * Sets the supplement cost. Cost cannot be less than zero
     * @param supplementWeeklyCost       The supplement cost double
     * @return boolean      Returns true if successful, false if not
     */
    public Boolean setSupplementWeeklyCost(Double supplementWeeklyCost) {
        if (supplementWeeklyCost > 0) {
            this.supplementWeeklyCost = supplementWeeklyCost;
            return true;
        } else {
            System.out.println("Supplement Weekly Cost cannot be negative or zero!");
            return false;
        }
    }

    /**
     * To string method
     * @return string    String representation of class
     */
    @Override
    public String toString() {
        return "Supplement: " + suppName + '\n' +
                "Cost: $" + supplementWeeklyCost +
                "\n";
    }

    /**
     * Overrides the equals method to check for equality by checking the Name and cost
     * @param otherSupplement     supplement class to be compared
     * @return boolean    Returns true if both are equals, false if not
     */
    @Override
    public boolean equals(Object otherSupplement) {
        Supplement supplement = (Supplement) otherSupplement;

        if (!supplement.getSupplementWeeklyCost().equals(this.supplementWeeklyCost)) {
            return false;
        }
        if (!supplement.getSuppName().equalsIgnoreCase((this.suppName))) {
            return false;
        }
        return true;
    }
}
