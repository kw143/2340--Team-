package edu.gatech.cs2340.team.imperialtrader.model;

public class Player {

    /** name of the player */
    private String name;

    /** skill points */
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private String difficulty;
    private int totalPoints;

    public Player(String name) { this(name, 0, 0, 0, 0, "easy"); }

    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints, String dif) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.difficulty = dif;
        this.totalPoints = pilotPoints + fighterPoints + traderPoints + engineerPoints;
    }


    /** setters and getters */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
        totalPoints = this.pilotPoints + fighterPoints + traderPoints + engineerPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
        totalPoints = pilotPoints + this.fighterPoints + traderPoints + engineerPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
        totalPoints = pilotPoints + fighterPoints + this.traderPoints + engineerPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
        totalPoints = pilotPoints + fighterPoints + traderPoints + this.engineerPoints;
    }

    public void setName(String n) { name = n; }

    public void setDifficulty (String d) {difficulty = d; }

    public String getDifficulty () { return difficulty; }

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

    public int getTotalPoints(){ return totalPoints; }

}