package com.company;

public class Supplement {
    private String name;
    private Double supplementWeeklyCost;
    public Supplement() {
        this.setName("");
        this.setSupplementWeeklyCost(0.0);
    }

    public Supplement(String name, Double supplementWeeklyCost) {
        this.setName(name);
        this.setSupplementWeeklyCost(supplementWeeklyCost);
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
