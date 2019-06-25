package edu.gatech.cs2340.team.imperialtrader.entity;

public class Player {

    /** name of the player */
    private String name;

    /** skill points */
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int money;
    private String difficulty;
    private String ship;
    private int totalPoints;
    private Inventory inventory;
    private Region curRegion;

    public Player(String name) { this(name, 0, 0, 0, 0, "easy", 1000, "Gnat Spcaeship"); }

    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints, String dif, int mon, String sh) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.difficulty = dif;
        this.totalPoints = pilotPoints + fighterPoints + traderPoints + engineerPoints;
        money = mon;
        ship = sh;
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

    public void setCurRegion(Region r) { curRegion = r; }

    public void setName(String n) { name = n; }

    public void setDifficulty (String d) {difficulty = d; }

    public void setMoney (int m) { money = m; }

    public void setShip (String s) { ship = s; }

    public void setInventory(Inventory i) {
        this.inventory = i;
    }

    public String getDifficulty () { return difficulty; }

    public String getName() { return name; }

    public String getShip() { return ship;}

    public int getMoney() { return money;}

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

    public Inventory getInventory() {
        return inventory;
    }

    public Region getCurRegion() { return curRegion; }

}