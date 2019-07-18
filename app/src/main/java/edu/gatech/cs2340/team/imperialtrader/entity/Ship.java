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
        this("", 0, 25, 50, 5, 20, 20, 1, 5 );
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
