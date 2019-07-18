package edu.gatech.cs2340.team.imperialtrader.entity;

public class PirateShip extends Ship {

    private String name;
    private int cost;
    private int speed;
    private int health;
    private int armor;
    private int currentFuel;
    private final int maxFuel = 15;
    private int weapons;
    private int cargoCapacity;

    /**
     * Constructor for a Pirate Ship
     * @param name Pirate Ship's name
     * @param cost Pirate Ship's cost
     * @param speed Pirate Ship's speed
     * @param health Pirate Ship's health
     * @param armor Pirate Ship's armor
     * @param currentFuel Pirate Ship's currentFuel
     * @param maxFuel Pirate Ship's maxFuel
     * @param weapons Pirate Ship's weapons
     * @param cargoCapacity Pirate Ship's cargoCapacity
     */
    public PirateShip(String name, int cost, int speed, int health, int armor, int currentFuel,
                      int maxFuel, int weapons, int cargoCapacity) {
        super(name, cost, speed, health, armor, currentFuel, maxFuel, weapons, cargoCapacity);
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
