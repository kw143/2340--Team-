package edu.gatech.cs2340.team.imperialtrader.entity;

import android.support.annotation.NonNull;

public enum Resource {
    NOSPECIALRESOURCES("No Special Resources"), MINERALRICH("Mineral Rich"),
    MINERALPOOR("Mineral Poor"),
    DESERT("Desert"), LOTSOFWATER("Abundant Water"),
    RICHSOIL("Rich Soil"), POORSOIL("Poor Soil"),
    RICHFAUNA("Rich in Fauna"), LIFELESS("Lifeless"),
    WEIRDMUSHROOMS("Weird Mushrooms"),
    LOTSOFHERBS("Abundant Herbs"), ARTISTIC("Artistic"),
    WARLIKE("Warlike");
    // --Commented out by Inspection (7/23/2019 12:33 AM):private final int resourceKey;

    private final String name;

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
        return this.getName();
    }

    /**
     * Constructor for Resource
     * @param name name of the resource.
     */
    Resource(String name) {
        this.name = name;
    }
}
