package edu.gatech.cs2340.team.imperialtrader.entity;

public class PlayerShip {

    private String name;
    private int cost;
    private int speed;
    private int health;
    private int currentFuel;
    private final int maxFuel;

    /**
     * Constructor for PlayerShip
     * @param name ship's name
     * @param cost ship's cost
     * @param speed ship's speed
     * @param health ship's health
     * @param currentFuel ship's currentFuel
     * @param maxFuel ship's maxFuel
     */
    public PlayerShip(String name, int cost, int speed, int health, int currentFuel,
                      int maxFuel) {
        this.name = name;
        this.cost = cost;
        this.speed = speed;
        this.health = health;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }

    /**
     * Get Ship's currentFuel
     * @return currentFuel
     */
    public int getCurrentFuel() {
        return currentFuel;
    }

    /**
     * Set Ship's currentFuel
     * @param currentFuel
     */
    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }
    /**
     * Setter for Ship's name
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Ship's cost
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Set Ship's cost
     * @param cost
     */
    public void setCost(int cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost is less than zero.");
        }
    }

    /**
     * Get Ship's speed
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set Ship's speed
     * @param speed
     */
    public void setSpeed(int speed) {
        if (speed > 0) {
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Speed is less than or equal to zero.");
        }
    }

    /**
     * Get Ship's health
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set Ship's health
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Getter for Ship's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Repair ship's health
     */
    public void repair() {
        final int totalHealth = 50;
        this.health = totalHealth;
    }

    /**
     * Refuel the ship
     */
    public void refuel() {
        currentFuel = maxFuel;
    }
}
