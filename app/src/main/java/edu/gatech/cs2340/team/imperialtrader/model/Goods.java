package edu.gatech.cs2340.team.imperialtrader.model;

public enum Good {
    WATER("Water", 42), FURS("Furs",285),
    FOOD("Food",120), ORE("Ore",440),
    GAMES("Games", 210), FIREARMS("Firearms", 950),
    MEDICINCE("Medicine", 570), MACHINES("Machines", 750),
    NARCOTICS("Narcotics", 3112), ROBOTS("Robots", 4225);
    private String name;
    private int price;
    private Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }
    /** A method that gets the name on the Drink
     * @return A string of the name of the drink
     */
    public String getName() {
        return this.name;
    }
    /** A method that gets the price of the drink
     * @return A double of the price of the drink
     */
    public double getPrice() {
        return price;
    }
}
