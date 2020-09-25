import java.util.ArrayList;


public class AssociateCustomer extends Customer{

    private ArrayList<Integer> supplements = new ArrayList<Integer>();
    private PayingCustomer payingCustomer = new PayingCustomer();

    public AssociateCustomer() {
        super();
    }

    public AssociateCustomer(String custName, String custEmail) {
        super(custName, custEmail);
    }

    public int getCustId() {
        return this.custId;
    }

    public void setCustName(String name) {
        this.custName = name;
    }

    public String getCustName() {
        return this.custName;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustEmail() {
        return this.custEmail;
    }

    public void setSupplement(ArrayList<Integer> supplements) {
        this.supplements = supplements;
    }

    public void setSupplement(Integer supplementId) {
        this.supplements.add(supplementId);
    }

    public ArrayList<Integer> getSupplements() {
        return this.supplements;
    }

    public PayingCustomer getPayingCustomer() {
        return this.payingCustomer;
    }

    public void setPayingCustomer(PayingCustomer payingCustomer) {
        this.payingCustomer = payingCustomer;
    }

    public String toString() {
        String str = ("Customer: " + this.custName + "\n" +
                "Email: " + this.custEmail + "\n" +
                "Payer: " + this.payingCustomer + "\n" +
                "Supplements: \n");
        for (Integer s : this.supplements) {
            str = str.concat(s.toString());
            str = str.concat("\n");
        }
        return str;
    }
}
