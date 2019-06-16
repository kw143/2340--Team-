package edu.gatech.cs2340.team.imperialtrader.model;

public class Player {

    /** name of the player */
    private String name;

    /** skill points */
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;

    public Player(String name) { this(name, 0, 0, 0, 0); }

    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
    }


    /** setters and getters */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public void setTraderPoints(int traderPoints) { this.traderPoints = traderPoints; }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    public void setName(String n) { name = n; }

    public String getName() { return name; }

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