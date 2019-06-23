package edu.gatech.cs2340.team.imperialtrader.model;

import android.util.Log;

import edu.gatech.cs2340.team.imperialtrader.entity.Player;


public class PlayerInteractor extends Interactor {
    public PlayerInteractor(Database dat) {
        super(dat);
    }


    public void createPlayer (Player p) {
        getData().createPlayer(p);
    }

    public Player getPlayer () {
        return getData().getPlayer();
    }

    public void updatePlayer(Player p) {
        getData().updatePlayer(p);
        Log.d("APP", "Interactor: updating player: " + p);
    }
}
