package edu.gatech.cs2340.team.imperialtrader.model;

/**
 * Interface for our concrete interactors
 */
public abstract class Interactor {

    private Database gameData;

    protected Interactor(Database dat) {
        gameData = dat;
    }

    protected Database getData() {
        return gameData;
    }
}
