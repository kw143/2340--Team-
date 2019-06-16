package edu.gatech.cs2340.team.imperialtrader.model;


public class Database {
    private Player player;

    public void createPlayer(Player p) {
        player = p;
    }

    public Player getPlayer() { return player; }

    public void updatePlayer(Player p) {
        player.setPilotPoints(p.getPilotPoints());
        player.setName(p.getName());
        player.setFighterPoints(p.getFighterPoints());
        player.setTraderPoints(p.getTraderPoints());
        player.setEngineerPoints(p.getEngineerPoints());
    }
}
