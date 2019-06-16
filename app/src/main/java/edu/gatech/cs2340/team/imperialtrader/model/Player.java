package edu.gatech.cs2340.team.imperialtrader.model;

public class Player {

    /** name of the player */
    private String name;

    /** skill points */
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;

    public Player(String name) {
        this.name = name;
    }


    /** setters and getters */
    public void setPilotPoints(int points) {
        pilotPoints = points;
    }

    public void setFighterPoints(int points) {
        fighterPoints = points;
    }

    public void setTraderPoints(int points) {
        traderPoints = points;
    }

    public void setEngineerPoints(int points) {
        engineerPoints = points;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

}