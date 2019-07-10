package edu.gatech.cs2340.team.imperialtrader.entity;

public class PlayerShip extends Ship {

    private String name = "Gnat";
    private int cost = 0;
    private int speed = 30;
    private int health = 75;
    public int armor = 10;
    public int currentFuel = 14;
    public final int maxFuel = 14;
    public int weapons = 2;
    public int cargoCapacity = 15;

    public PlayerShip(String name, int cost, int speed, int health, int armor, int currentFuel, int maxFuel, int weapons, int cargoCapacity) {
        super("Gnat",0, 30, 75, 10, 14, 14, 2, 15);
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public String getName() {
        return name;
    }

    public void fly() {
    }

    public void shoot() {
    }

    public void repair() {
        this.health = 100;
    }

    public void upgrade() {
        armor += 5;
        weapons += 1;
        cargoCapacity += 2;
    }
}
