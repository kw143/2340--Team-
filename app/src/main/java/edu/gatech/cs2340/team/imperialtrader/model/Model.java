package edu.gatech.cs2340.team.imperialtrader.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the interface to the domain/business classes from anywhere else in the application
 *
 *
 * This class provides all the interactors for the application.
 *
 * It is a Singleton so that it can be accessed from anywhere in the application
 */

public final class Model {

    /** the data repository */
    private final Universe gameDat;

    private final Map<String, Object> interactorMap;

    /** Singleton Pattern Code
     *  this allows us to get access to this class
     *  anywhere, which will allow our View models to access
     *  the "back end"  more easily
     */
    private static final Model instance = new Model();

    /**
     * Getter for Instance
     * @return instance
     */
    public static Model getInstance() { return instance; }

    /**
     * Make a new Model instance
     */
    private Model() {
        gameDat = new Universe();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    // end Singleton Pattern

    /**
     * Create a set of interactors to be used by the application
     */
    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(gameDat));
        interactorMap.put("Region", new RegionInteractor(gameDat));
    }


    /**
     * Get a PlayerInteractor
     * @return PlayerInteractor
     */
    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Player");
    }

    /**
     * Get a RegionInteractor
     * @return RegionInteractor
     */
    public RegionInteractor getRegionInteractor() {
        return (RegionInteractor) interactorMap.get("Region");
    }
}
