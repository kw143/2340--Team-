package edu.gatech.cs2340.team.imperialtrader.entity;

public class PlayerShip extends Ship {

    private String name = "Gnat";
    private int cost = 0;
    private int speed = 30;
    private int health = 75;
    private int armor = 10;
    private int currentFuel = 14;
    public final int maxFuel = 14;
    private int weapons = 2;
    private int cargoCapacity = 15;

    public PlayerShip(String name, int cost, int speed, int health, int armor, int currentFuel, int maxFuel, int weapons, int cargoCapacity) {
        super("Gnat",0, 30, 75, 10, 14, 14, 2, 15);
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
