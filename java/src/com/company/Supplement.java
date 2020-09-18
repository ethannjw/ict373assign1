package com.company;

public class Supplement {
    private String name;
    private Double supplementWeeklyCost;
    public Supplement() {
        this.name = "";
        this.supplementWeeklyCost = 0.0;
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
}
