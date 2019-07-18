package edu.gatech.cs2340.team.imperialtrader.entity;

public class PlayerShip extends Ship {

    private String name;
    private int cost;
    private int speed;
    private int health;
    private int armor;
    private int currentFuel;
    private final int maxFuel = 14;
    private int weapons;
    private int cargoCapacity;

    public PlayerShip(String name, int cost, int speed, int health, int armor, int currentFuel,
                      int maxFuel, int weapons, int cargoCapacity) {
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
        if(cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost is less than zero.");
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed > 0) {
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Speed is less than or equal to zero.");
        }

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

    @Override
    public void fly() {
    }

    @Override
    public void shoot() {
    }

    @Override
    public void repair() {
        this.health = 100;
    }

    @Override
    public void upgrade() {
        armor += 5;
        weapons += 1;
        cargoCapacity += 2;
    }
}
