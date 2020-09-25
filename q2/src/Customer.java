import java.util.concurrent.atomic.AtomicInteger;

public abstract class Customer {
    protected static AtomicInteger nextId = new AtomicInteger();
    protected int custId;
    protected String custName;
    protected String custEmail;

    protected Customer() {
        this.custId = nextId.incrementAndGet();
        this.setCustName("");
        this.setCustEmail("");
    }
    protected Customer(String custName, String custEmail) {
        this.custId = nextId.incrementAndGet();
        this.setCustName(custName);
        this.setCustEmail(custEmail);
    }

    protected int getCustId() {
        return this.custId;
    }

    protected void setCustName(String name) {
        this.custName = name;
    }

    protected String getCustName() {
        return this.custName;
    }

    protected void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    protected String getCustEmail() {
        return this.custEmail;
    }
}
