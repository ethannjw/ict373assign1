public class PaymentMethod {
    private String paymentName;

    public PaymentMethod() {
        this.setPaymentName("");
    }
    public PaymentMethod(String paymentName){
        this.setPaymentName(paymentName);
    }
    public String getPaymentName() {
        return this.paymentName;
    }
    public Boolean setPaymentName(String paymentName) {
        this.paymentName = paymentName;
        return true;
    }

    @Override
    public String toString() {
        return "Payer Name: " + paymentName + '\n';
    }
}
