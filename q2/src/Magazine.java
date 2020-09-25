import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Magazine {
    private static AtomicInteger nextId = new AtomicInteger();
    private int magId;
    private int magWeek;
    private String magName;
    private EmailContent magEmailContent;
    private double magWeeklyCost;

    public Magazine() {
        this.magId = nextId.incrementAndGet();
        this.setMagName("");
    }

    public Magazine(String magName, int magWeek) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeek(magWeek);
    }

    public Magazine(String magName, int magWeek, double magWeeklyCost) {
        this.magId = nextId.incrementAndGet();
        this.setMagName(magName);
        this.setMagWeek(magWeek);
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

    // magWeek
    public int getMagWeek() {
        return magWeek;
    }

    public void setMagWeek(int magWeek) {
        this.magWeek = magWeek;
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
                "magazine Week: " + magWeek + '\n' +
                "magezine Email Content: " + magEmailContent + '\n' +
                "magazine Weekly Cost: $" + magWeeklyCost + '\n' +
                "Customers: " + '\n';
        return str;
    }

}
