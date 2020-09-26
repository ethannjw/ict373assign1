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
     * @param custName: String
     * @param custEmail: String
     */
    public AssociateCustomer(String custName, String custEmail) {
        super(custName, custEmail);
        this.supplements = new ArrayList<Integer>();
    }

    /**
     * Adds a new supplement
     * @param supplement: Supplement
     */
    public void setSupplement(Supplement supplement) {
        int addId = supplement.getSuppId();
        for (Integer custId : this.supplements) {
            if (custId == addId) {
                System.out.println("Duplicate supplement customer! Cannot insert");
                return;
            }
        }
        this.supplements.add(addId);
    }
    /**
     * Returns the list of supplements
     * @return supplements: ArrayList<Integer>
     */
    public ArrayList<Integer> getSupplements() {
        return this.supplements;
    }

}
