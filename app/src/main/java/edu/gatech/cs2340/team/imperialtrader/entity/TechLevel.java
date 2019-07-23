package edu.gatech.cs2340.team.imperialtrader.entity;

public enum TechLevel {
    PREAGRICULTURE(0, "Preagriculture"), AGRICULTURE(1, "Agriculture"), MEDIEVAL(2, "Medieval"),
    RENAISSANCE(3, "Renaissance"), EARLYINDUSTRIAL(4, "Early Industrial"),
    INDUSTRIAL(5, "Industrial"), POSTINDUSTRIAL(6, "Post-Industrial"),
    HITECH(7, "Hi-Tech");
    private final String name;
    TechLevel(int level, String name) {
        this.name = name;
    }
    private String getName() {
        return name;
    }
    public String toString() {
        return name;
    }
}
