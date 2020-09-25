import java.util.concurrent.atomic.AtomicInteger;

public class Supplement {
    private static AtomicInteger nextId = new AtomicInteger();
    private int suppId;
    private String name;
    private Double supplementWeeklyCost;

    public Supplement(String name, Double supplementWeeklyCost) {
        this.suppId = nextId.incrementAndGet();
        this.setName(name);
        this.setSupplementWeeklyCost(supplementWeeklyCost);
    }

    public int getSuppId() {
        return suppId;
    }

    public String getName() {
        return this.name;
    }

    public Boolean setName(String name) {
        this.name = name;
        return true;
    }

    public Double getSupplementWeeklyCost() {
        return this.supplementWeeklyCost;
    }

    public Boolean setSupplementWeeklyCost(Double supplementWeeklyCost) {
        this.supplementWeeklyCost = supplementWeeklyCost;
        return true;
    }

    @Override
    public String toString() {
        return "Supplement: " + name + '\n' +
                "Cost: $" + supplementWeeklyCost +
                "\n";
    }
}
