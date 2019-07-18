package edu.gatech.cs2340.team.imperialtrader.entity;

public class Player {

    private String name;

    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private int money;
    private String difficulty;
    private PlayerShip ship;
    private int totalPoints;
    private Inventory inventory;
    private Region curRegion;
    private Good curGood;

    /**
     * Creates a new Player object with given name and default data
     * @param name name of Player
     */
    public Player(String name) { this(name, 0, 0, 0, 0,
            "Easy", 1000, new PlayerShip("Gnat",0, 30, 75, 10,
                    14, 14, 2, 15)); }

    /**
     * Creates a new Player object with given data
     * @param name name of Player
     * @param pilotPoints pilotPoints of Player
     * @param fighterPoints fighterPoints of Player
     * @param traderPoints traderPoints of Player
     * @param engineerPoints engineerPoints of Player
     * @param dif difficulty of game
     * @param money money owned by Player
     * @param ship ship owned by Player
     */
    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints,
                  int engineerPoints, String dif, int money, PlayerShip ship) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.difficulty = dif;
        this.totalPoints = pilotPoints + fighterPoints + traderPoints + engineerPoints;
        this.money = money;
        this.ship = ship;
        inventory = new Inventory();
    }


    /**
     * Setter for pilotPoints
     * @param pilotPoints pilotPoints of Player
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
        totalPoints = this.pilotPoints + fighterPoints + traderPoints + engineerPoints;
    }

    /**
     * Setter for fighterPoints
     * @param fighterPoints fighterPoints of Player
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
        totalPoints = pilotPoints + this.fighterPoints + traderPoints + engineerPoints;
    }

    /**
     * Setter for traderPoints
     * @param traderPoints traderPoints of Player
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
        totalPoints = pilotPoints + fighterPoints + this.traderPoints + engineerPoints;
    }

    /**
     * setter for engineerPointss
     * @param engineerPoints engineerPoints of Player
     */
    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
        totalPoints = pilotPoints + fighterPoints + traderPoints + this.engineerPoints;
    }

    /**
     * Setter for current region
     * @param r region
     * @param distance distance from current region
     */
    public void setCurRegion(Region r, double distance) {
        if (distance > 0) {
            this.getShip().setCurrentFuel((int) ((this.getShip().getCurrentFuel() * 50) - distance)
                    / 50);
        }
        curRegion = r;
    }

    /**
     * Setter for name
     * @param n name of Player
     */
    public void setName(String n) { name = n; }

    /**
     * Setter for difficulty
     * @param d difficulty
     */
    public void setDifficulty (String d) {difficulty = d; }

    /**
     * Setter for Player's money
     * @param m money
     */
    public void setMoney (int m) { money = m; }

    /**
     * Setter for Player's ship
     * @param s ship
     */
    public void setShip (PlayerShip s) { ship = s; }

    /**
     * Setter for Inventory
     * @param i inventory
     */
    public void setInventory(Inventory i) {
        this.inventory = i;
    }

    /**
     * Setter for Good
     * @param g good
     */
    public void setGood(Good g) { curGood = g; }

    /**
     * Getter for game difficulty
     * @return difficulty
     */
    public String getDifficulty () { return difficulty; }

    /**
     * Getter for Player name
     * @return name
     */
    public String getName() { return name; }

    /**
     * Getter for Player ship
     * @return ship
     */
    public PlayerShip getShip() { return ship;}

    /**
     * Getter for Player's money
     * @return money
     */
    public int getMoney() { return money;}

    /**
     * Getter for pilotPoints
     * @return pilotPoints
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Getter for fighterPoints
     * @return fighterPoints
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Getter for traderPoints
     * @return traderPoints
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Getter for engineerPoints
     * @return engineerPoints
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Getter for totalPoints
     * @return totalPoints
     */
    public int getTotalPoints(){ return totalPoints; }

    /**
     * Getter for Inventory
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Gettter for current region
     * @return curRegion
     */
    public Region getCurRegion() { return curRegion; }

    /**
     * Getter for current good
     * @return curGood
     */
    public Good getGood() { return curGood; }

}