package edu.gatech.cs2340.team.imperialtrader.entity;

public enum Resource {
    NOSPECIALRESOURCES(0, "No Special Resources"), MINERALRICH(1, "Mineral Rich"),
    MINERALPOOR(2, "Mineral Poor"),
    DESERT(3, "Desert"), LOTSOFWATER(4, "Abundant Water"),
    RICHSOIL(5, "Rich Soil"), POORSOIL(6, "Poor Soil"),
    RICHFAUNA(7, "Rich in Fauna"), LIFELESS(8, "Lifeless"),
    WEIRDMUSHROOMS(9, "Weird Mushrooms"),
    LOTSOFHERBS(10, "Abundant Herbs"), ARTISTIC(11, "Artistic"),
    WARLIKE(12, "Warlike");
    // --Commented out by Inspection (7/23/2019 12:33 AM):private final int resourseKey;

    private final String name;
    private String getName() {
        return name;
    }
    public String toString() {
        return this.getName();
    }
    Resource(int resourceKey, String name) {
        this.name = name;
    }
}
