package edu.gatech.cs2340.team.imperialtrader.model;

/**
 * Interface for our concrete interactors
 */
abstract class Interactor {

    private final Universe gameData;

    /**
     * Interactor constructor given a Universe
     * @param dat
     */
    Interactor(Universe dat) {
        gameData = dat;
    }

    /**
     * Getter for Universe's data
     * @return Universe's data
     */
    Universe getUniverse() {
        return gameData;
    }
}
