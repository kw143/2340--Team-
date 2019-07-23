package edu.gatech.cs2340.team.imperialtrader.entity;

public abstract class Ship {

    private String name;
    private int cost;
    private int speed;
    private int health;
    private int armor;
    private int currentFuel;
    private int maxFuel;
    private int weapons;
    private int cargoCapacity;

    /**
     * Default Ship Constructor
     */
    public Ship() {
        this("", 0, 25, 50, 5, 20, 20, 1,5 );
    }

    /**
     * Ship constructor with given data
     * @param name Ship's name
     * @param cost Ship's cost
     * @param speed Ship's speed
     * @param health Ship's health
     * @param armor Ship's armor
     * @param currentFuel Ship's currentFuel
     * @param maxFuel Ship's maxFuel
     * @param weapons Ship's weapons
     * @param cargoCapacity Ship's cargoCapacity
     */
    public Ship(String name, int cost, int speed, int health, int armor, int currentFuel,
                int maxFuel, int weapons, int cargoCapacity) {
        this.name = name;
        this.cost = cost;
        this.speed = speed;
        this.health = health;
        this.armor = armor;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
        this.weapons = weapons;
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Getter for Ship's name
     * @return name
     */
    public String getName() {
        return name;
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
        this.cost = cost;
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
        this.speed = speed;
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
     * Get Ship's armor
     * @return armor
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Set Ship's armor
     * @param armor
     */
    public void setArmor(int armor) {
        this.armor = armor;
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
     * Get Ship's maxFuel
     * @return maxFuel
     */
    public int getMaxFuel() {
        return maxFuel;
    }

    /**
     * Set Ship's maxFuel
     * @param maxFuel
     */
    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    /**
     * Get Ship's weapons
     * @return weapons
     */
    public int getWeapons() {
        return weapons;
    }

    /**
     * Set Ship's weapons
     * @param weapons
     */
    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    /**
     * Get Ship's cargoCapacity
     * @return cargoCapacity
     */
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Set Ship's cargoCapacity
     * @param cargoCapacity
     */
    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Abstract fly Method
     */
    public abstract void fly();

    /**
     * Abstract shoot method
     */
    public abstract void shoot();

    /**
     * Abstract repair method
     */
    public abstract void repair();

    /**
     * Abstract upgrade method
     */
    public abstract void upgrade();

}
