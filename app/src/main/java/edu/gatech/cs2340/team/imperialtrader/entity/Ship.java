package edu.gatech.cs2340.team.imperialtrader.entity;

public abstract class Ship {

    private int cost;
    private int speed;
    private int health;
    public int armor;
    public int currentFuel;
    public int maxFuel;
    public int weapons;
    public int cargoCapacity;

    public Ship() {
        this(0, 25, 50, 5, 20, 20, 1, 5 );
    }

    public Ship(int cost, int speed, int health, int armor, int currentFuel, int maxFuel, int weapons, int cargoCapacity) {
        this.cost = cost;
        this.speed = speed;
        this.health = health;
        this.armor = armor;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
        this.weapons = weapons;
        this.cargoCapacity = cargoCapacity;
    }

    public abstract void fly();

    public abstract void shoot();

    public abstract void repair();

    public abstract void upgrade();

}
