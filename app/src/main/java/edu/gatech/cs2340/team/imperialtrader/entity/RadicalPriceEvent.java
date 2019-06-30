package edu.gatech.cs2340.team.imperialtrader.entity;

import java.util.Random;

public enum RadicalPriceEvent {
    DROUGHT("Drought"),
    COLD("Cold"),
    CROPFAIL("Crop fail"),
    WAR("War"),
    BOREDOM("Boredom"),
    PLAGUE("Plague"),
    LACKOFWORKERS("Lack of Workers");

    private final String event;

    RadicalPriceEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return event;
    }

    public static RadicalPriceEvent getRandomEvent() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
