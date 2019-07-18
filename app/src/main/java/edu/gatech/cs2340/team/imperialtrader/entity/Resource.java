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
    private int resourseKey;

    private String name;
    private String getName() {
        return name;
    }
    public String toString() {
        return this.getName();
    }
    private Resource(int resourseKey, String name) {
        this.resourseKey = resourseKey;
        this.name = name;
    }
}
