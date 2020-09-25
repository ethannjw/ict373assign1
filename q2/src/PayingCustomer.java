import java.util.ArrayList;

public class PayingCustomer extends Customer {

    private PaymentMethod paymentMethod;
    private ArrayList<Integer> associateCustomers = new ArrayList<Integer>();
    public PayingCustomer() {
        super();
    }

    public PayingCustomer(String payerName, String payerEmail) {
        super(payerName, payerEmail);
        this.setPaymentMethod(new PaymentMethod());
    }


    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAssociateCustomer(AssociateCustomer associateCustomer) {
        this.associateCustomers.add(associateCustomer.getCustId()) ;
    }

    public void setAssociateCustomers(ArrayList<Integer> custIds) {
        this.associateCustomers = custIds;
    }

    public void setAssociateCustomer(Integer custIds) {
        this.associateCustomers.add(custIds);
    }
    public ArrayList<Integer> getAssociateCustomers() {
        return associateCustomers;
    }

    @Override
    public String toString() {
        String str = "PayingCustomer: \n" +
                "payerName:" + custName + '\n' +
                "payerEmail: " + custEmail + '\n' +
                "paymentMethod: \n" + paymentMethod + '\n' +
                "associateCustomers: \n";
        for (Integer c : this.associateCustomers) {
            str = str.concat(c.toString());
            str = str.concat("\n");
        }
        return str;
    }
}
