import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Magazine {
    private static AtomicInteger nextId = new AtomicInteger();
    private int magId;
    private String magName;
    private EmailContent magEmailContent;
    private double magWeeklyCost;

    public Magazine() {
        this.magId = nextId.incrementAndGet();
        this.setMagName("");
    }

    public Magazine(String magName, double magWeeklyCost) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
    }

    // magId
    public int getMagId() {
        return magId;
    }

    // magName
    public String getMagName() {
        return magName;
    }

    public void setMagName(String magName) {
        this.magName = magName;
    }

    // magEmailContent
    public EmailContent getMagEmailContent() {
        return magEmailContent;
    }

    public void setMagEmailContent(EmailContent magEmailContent) {
        this.magEmailContent = magEmailContent;
    }

    // magWeeklyCost
    public void setMagWeeklyCost(double magazineWeeklyCost) {
        this.magWeeklyCost = magazineWeeklyCost;
    }

    public double getMagWeeklyCost() {
        return this.magWeeklyCost;
    }

    @Override
    public String toString() {
        String str = "Magazine: \n" +
                "magazine ID: " + magId + '\n' +
                "magazine Name: " + magName + '\n' +
                "magezine Email Content: " + magEmailContent + '\n' +
                "magazine Weekly Cost: $" + magWeeklyCost + '\n' +
                "Customers: " + '\n';
        return str;
    }

}
