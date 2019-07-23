package edu.gatech.cs2340.team.imperialtrader.entity;


import android.support.annotation.NonNull;

/**
 * TechLevel enum for a region's tech-level
 */
public enum TechLevel {
    PREAGRICULTURE("Preagriculture"), AGRICULTURE("Agriculture"), MEDIEVAL("Medieval"),
    RENAISSANCE( "Renaissance"), EARLYINDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"), POSTINDUSTRIAL("Post-Industrial"),
    HITECH("Hi-Tech");

    private final String name;
    /**
     * Constructor for TechLevel given a level
     * @param name
     */
    TechLevel(String name) {
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
