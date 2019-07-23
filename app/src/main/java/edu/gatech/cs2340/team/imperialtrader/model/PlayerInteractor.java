package edu.gatech.cs2340.team.imperialtrader.model;

import android.util.Log;

import edu.gatech.cs2340.team.imperialtrader.entity.Player;

/**
 * Class for our Player interactors
 */

public class PlayerInteractor extends Interactor {

    /**
     * Constructor for PlayerInteractor
     * @param dat Universe data
     */
    public PlayerInteractor(Universe dat) {
        super(dat);
    }


    /**
     * Method to create a player
     * @param p Player
     */
    public void createPlayer (Player p) {
        getUniverse().createPlayer(p);
    }

    /**
     * Getter for player
     * @return Player
     */
    public Player getPlayer () {
        return getUniverse().getPlayer();
    }

    /**
     * Method to update a player
     * @param p Player
     */
    public void updatePlayer(Player p) {
        getUniverse().updatePlayer(p);
        Log.d("APP", "Interactor: updating player: " + p);
    }
}
