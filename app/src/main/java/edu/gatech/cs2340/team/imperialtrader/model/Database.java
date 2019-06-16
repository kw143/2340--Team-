package edu.gatech.cs2340.team.imperialtrader.model;

import android.util.Log;

public class Database {
    private Player player;

    public void createPlayer(Player p) {
        player = p;
    }

    public void updatePlayer(Player p) {
        player.setPilotPoints(p.getPilotPoints());
        player.setName(p.getName());
        player.setFighterPoints(p.getFighterPoints());
        player.setTraderPoints(p.getTraderPoints());
        player.setEngineerPoints(p.getEngineerPoints());
    }
}
