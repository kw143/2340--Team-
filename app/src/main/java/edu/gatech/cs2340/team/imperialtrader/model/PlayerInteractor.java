package edu.gatech.cs2340.team.imperialtrader.model;

import android.util.Log;

import edu.gatech.cs2340.team.imperialtrader.entity.Player;


public class PlayerInteractor extends Interactor {
    public PlayerInteractor(Universe dat) {
        super(dat);
    }


    public void createPlayer (Player p) {
        getUniverse().createPlayer(p);
    }

    public Player getPlayer () {
        return getUniverse().getPlayer();
    }

    public void updatePlayer(Player p) {
        getUniverse().updatePlayer(p);
        Log.d("APP", "Interactor: updating player: " + p);
    }
}
