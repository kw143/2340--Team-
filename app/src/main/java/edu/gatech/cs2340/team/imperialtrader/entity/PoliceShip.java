package edu.gatech.cs2340.team.imperialtrader.entity;

/**
 * PoliceShip for NPC Police encounters
 */

public class PoliceShip extends Ship {

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
        this.setHealth(100);
    }

    @Override
    /**
     * Upgrade method
     */
    public void upgrade() {
        this.setArmor(getArmor() + 5);
        this.setWeapons(getWeapons() + 1);
        this.setCargoCapacity(getCargoCapacity() + 2);
    }


}
