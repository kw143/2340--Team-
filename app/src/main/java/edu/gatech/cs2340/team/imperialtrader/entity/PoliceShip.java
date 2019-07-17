package edu.gatech.cs2340.team.imperialtrader.entity;

public class PoliceShip extends Ship {

    private String name = "Police";
    private int cost;
    private int speed = 50;
    private int health = 100;
    private int armor = 25;
    private int currentFuel = 15;
    private final int maxFuel = 15;
    private int weapons = 2;
    private int cargoCapacity = 10;

    public PoliceShip(String name, int cost, int speed, int health, int armor, int currentFuel,
                      int maxFuel, int weapons, int cargoCapacity) {
        super("Police", 0, 50, 100, 25, 15, 15, 2, 10);
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
