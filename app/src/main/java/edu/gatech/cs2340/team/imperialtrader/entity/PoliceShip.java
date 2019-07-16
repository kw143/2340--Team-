package edu.gatech.cs2340.team.imperialtrader.entity;

public class PoliceShip extends Ship {

    private String name = "Police";
    private int cost = 0;
    private int speed = 50;
    private int health = 100;
    public int armor = 25;
    public int currentFuel = 15;
    public final int maxFuel = 15;
    public int weapons = 2;
    public int cargoCapacity = 10;

    public PoliceShip(String name, int cost, int speed, int health, int armor, int currentFuel,
                      int maxFuel, int weapons, int cargoCapacity) {
        super("Police", 0, 50, 100, 25, 15, 15, 2, 10);
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
