package edu.gatech.cs2340.team.imperialtrader.entity;

public class PlayerShip extends Ship {

    private String name = "Gnat";
    private int cost;
    private int speed = 30;
    private int health = 75;
    private int armor = 10;
    private int currentFuel = 14;
    private final int maxFuel = 14;
    private int weapons = 2;
    private int cargoCapacity = 15;

    /**
     * Constructor for PlayerShip
     * @param name ship's name
     * @param cost ship's cost
     * @param speed ship's speed
     * @param health ship's health
     * @param armor ship's armor
     * @param currentFuel ship's currentFuel
     * @param maxFuel ship's maxFuel
     * @param weapons ship's weapon
     * @param cargoCapacity ship's cargoCapacity
     */
    public PlayerShip(String name, int cost, int speed, int health, int armor, int currentFuel,
                      int maxFuel, int weapons, int cargoCapacity) {
        super("Gnat",0, 30, 75, 10, 14, 14, 2, 15);
    }

    /**
     * Getter for currentFuel
     * @return currentFuel
     */
    public int getCurrentFuel() {
        return currentFuel;
    }

    /**
     * Setter for currentFuel
     * @param currentFuel currentFuel
     */
    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    /**
     * Setter for ship's name
     * @param name ship's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for ship's cost
     * @return ship's cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Setter for ship's cost
     * @param cost ship's cost
     */
    public void setCost(int cost) {
        if(cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost is less than zero.");
        }
    }

    /**
     * Getter for ship's speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Setter for ship's speed
     * @param speed ship's speed
     */
    public void setSpeed(int speed) {
        if(speed > 0) {
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Speed is less than or equal to zero.");
        }

    }

    /**
     * Getter for ship's health
     * @return ship's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setter for ship's health
     * @param health ship's health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Setter for ship's name
     * @return ship's name
     */
    public String getName() {
        return name;
    }

    @Override
    /**
     * Fly method
     */
    public void fly() {
    }

    @Override
    /**
     * Shoot method
     */
    public void shoot() {
    }

    @Override
    /**
     * Repair method
     */
    public void repair() {
        this.health = 100;
    }

    @Override
    /**
     * Upgrade method
     */
    public void upgrade() {
        armor += 5;
        weapons += 1;
        cargoCapacity += 2;
    }
}
