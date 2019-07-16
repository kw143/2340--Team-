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

    public Ship() {
        this("", 0, 25, 50, 5, 20, 20, 1, 5 );
    }

    public Ship(String name, int cost, int speed, int health, int armor, int currentFuel, int maxFuel, int weapons, int cargoCapacity) {
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

    public abstract void fly();

    public abstract void shoot();

    public abstract void repair();

    public abstract void upgrade();

}
