import java.util.ArrayList;

/**
 * @title       AssociateCustomer
 * @desc        This class is a on implementation of customer class that adds a list of supplements
 * @filename    AssociateCustomer.java
 * @version     0.1
 * @date        01/10/2020
 * @author      Ethan Ng
 */

public class AssociateCustomer extends Customer{

    private ArrayList<Integer> supplements;

    /**
     * Constructor constructs the customer name and email
     * @param custName  String
     * @param custEmail String
     */
    public AssociateCustomer(String custName, String custEmail) {
        super(custName, custEmail);
        this.supplements = new ArrayList<Integer>();
    }

    /**
     * Adds a new supplement
     * @param supplement    Supplement to be added
     * @return boolean  Returns true if successful, false if not
     */
    public boolean setSupplement(Supplement supplement) {
        int addId = supplement.getSuppId();
        for (Integer custId : this.supplements) {
            if (custId == addId) {
                System.out.println("Duplicate supplement customer! Cannot insert");
                return false;
            }
        }
        this.supplements.add(addId);
        return true;
    }
    /**
     * Returns the list of supplements
     * @return supplements  ArrayList<Integer> list of supplements
     */
    public ArrayList<Integer> getSupplements() {
        return this.supplements;
    }

}
