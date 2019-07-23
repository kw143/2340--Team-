package edu.gatech.cs2340.team.imperialtrader.entity;

import android.support.annotation.NonNull;

import java.util.Random;

/**
 * Random price inflation/deflation event creator
 */
public enum RadicalPriceEvent {
    DROUGHT("Drought"),
    COLD("Cold"),
    CROPFAIL("Crop fail"),
    WAR("War"),
    BOREDOM("Boredom"),
    PLAGUE("Plague"),
    LACKOFWORKERS("Lack of Workers");

    private final String event;

    /**
     * Constructor for a RadicalPriceEvent
     * @param event Random event
     */
    RadicalPriceEvent(String event) {
        this.event = event;
    }

    @Override
    @NonNull
    /**
     * Overriding object toString method
     * @return event
     */
    public String toString() {
        return event;
    }

    /**
     * Getter for a random event
     * @return random events
     */
    public static RadicalPriceEvent getRandomEvent() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
