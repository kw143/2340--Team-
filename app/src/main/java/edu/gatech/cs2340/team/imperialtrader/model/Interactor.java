package edu.gatech.cs2340.team.imperialtrader.model;

/**
 * Interface for our concrete interactors
 */
abstract class Interactor {

    private final Universe gameData;

    Interactor(Universe dat) {
        gameData = dat;
    }

    Universe getUniverse() {
        return gameData;
    }
}
