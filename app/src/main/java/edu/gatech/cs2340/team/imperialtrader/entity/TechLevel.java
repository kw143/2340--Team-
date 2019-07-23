package edu.gatech.cs2340.team.imperialtrader.entity;


import android.support.annotation.NonNull;

/**
 * TechLevel enum for a region's tech-level
 */
public enum TechLevel {
    PREAGRICULTURE(0, "Preagriculture"), AGRICULTURE(1, "Agriculture"), MEDIEVAL(2, "Medieval"),
    RENAISSANCE(3, "Renaissance"), EARLYINDUSTRIAL(4, "Early Industrial"),
    INDUSTRIAL(5, "Industrial"), POSTINDUSTRIAL(6, "Post-Industrial"),
    HITECH(7, "Hi-Tech");

    private final int level;
    private final String name;
    /**
     * Constructor for TechLevel given a level
     * @param level
     */
    TechLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    /**
     * Get name method
     * @return name
     */
    private String getName() {
        return name;
    }

    @NonNull
    /**
     * toString method
     * @return name as a String
     */
    public String toString() {
        return name;
    }
}
