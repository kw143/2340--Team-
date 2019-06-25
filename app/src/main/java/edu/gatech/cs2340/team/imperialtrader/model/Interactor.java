package edu.gatech.cs2340.team.imperialtrader.model;

/**
 * Interface for our concrete interactors
 */
public abstract class Interactor {

    private Universe gameData;

    protected Interactor(Universe dat) {
        gameData = dat;
    }

    protected Universe getUniverse() {
        return gameData;
    }
}
