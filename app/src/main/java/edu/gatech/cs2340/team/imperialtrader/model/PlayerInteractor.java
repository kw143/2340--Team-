package edu.gatech.cs2340.team.imperialtrader.model;

import android.util.Log;


public class PlayerInteractor extends Interactor {
    public PlayerInteractor(Database dat) {
        super(dat);
    }


    public void createPlayer (Player p) {
        getData().createPlayer(p);
    }

    public void updatePlayer(Player p) {
        getData().updatePlayer(p);
        Log.d("APP", "Interactor: updating player: " + p);
    }
}
