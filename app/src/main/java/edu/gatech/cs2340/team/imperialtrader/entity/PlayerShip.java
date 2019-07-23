package edu.gatech.cs2340.team.imperialtrader.entity;

public class PlayerShip {

    private String name;
    private int cost;
    private int speed;
    private int health;
    private int currentFuel;
    private int maxFuel;

    public PlayerShip(String name, int cost, int speed, int health, int currentFuel,
                      int maxFuel) {
        this.name = name;
        this.cost = cost;
        this.speed = speed;
        this.health = health;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
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
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost is less than zero.");
        }
    }


    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        if (speed > 0) {
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


    public void repair() {
        final int totalHealth = 50;
        this.health = totalHealth;
    }

    public void refuel() {
        currentFuel = maxFuel;
    }
}
