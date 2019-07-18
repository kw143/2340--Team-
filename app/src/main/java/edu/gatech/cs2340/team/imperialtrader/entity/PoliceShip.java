package edu.gatech.cs2340.team.imperialtrader.entity;

public class PoliceShip extends Ship {

    private String name = "Police Ship";
    private int cost;
    private int speed;
    private int health;
    private int armor;
    private int currentFuel;
    private final int maxFuel = 15;
    private int weapons;
    private int cargoCapacity;

    /**
     * Constructor for a Police Ship
     * @param name Police Ship's name
     * @param cost Police Ship's cost
     * @param speed Police Ship's speed
     * @param health Police Ship's health
     * @param armor Police Ship's armor
     * @param currentFuel Police Ship's currentFuel
     * @param maxFuel Police Ship's maxFuel
     * @param weapons Police Ship's weapons
     * @param cargoCapacity Police Ship's cargoCapacity
     */
    public PoliceShip(String name, int cost, int speed, int health, int armor, int currentFuel,
                      int maxFuel, int weapons, int cargoCapacity) {
        super("Police", 0, 50, 100, 25, 15, 15, 2, 10);
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
