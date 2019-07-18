package edu.gatech.cs2340.team.imperialtrader.entity;

import java.util.Random;

public class Region {

    private String name;
    private String home;
    private int xCoord;
    private int yCoord;
    private TechLevel techLevel;
    private Resource resource;
    private RadicalPriceEvent curEvent;



    private Inventory goodsInRegion = new Inventory(10000);
    Random rand = new Random();

    /**
     * Constructor for Region
     * @param name Region name
     * @param home Region home
     * @param xCoord Region's x-coordinate
     * @param yCoord Region's y-coordinate
     * @param techLevel Region's techLevel
     * @param resource Region's resource
     */
    public Region(String name, String home, int xCoord, int yCoord,
                  TechLevel techLevel, Resource resource) {
        this.name = name;
        this.home = home;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.techLevel = techLevel;
        this.resource = resource;
        rollEvent();
        restockInventory();
    }

    /**
     * Constructor for region with randomly-generated values
     */
    public Region(String name, String home) {

        int x = rand.nextInt(150);
        int y = rand.nextInt(100);
        int t = rand.nextInt(8);
        int r = rand.nextInt(13);

        this.name = name;
        this.home = home;
        this.xCoord = x;
        this.yCoord = y;
        this.techLevel = TechLevel.values()[t];
        this.resource = Resource.values()[r];
        rollEvent();
        restockInventory();
    }

    /**
     * Random event generator
     */
    public void rollEvent() {
        curEvent = RadicalPriceEvent.getRandomEvent();
    }

    /**
     * Method to restock Region's Inventory
     */
    public void restockInventory() {
        for (int x = 0; x < 4; x++) {
            Good newGood = Good.values()[rand.nextInt(10)];
            if (newGood.getMLTP().ordinal() > techLevel.ordinal()) {
                x--;
            } else {
                goodsInRegion.add(newGood, (newGood.getTTP().ordinal() == curEvent.ordinal())
                        ? rand.nextInt((goodsInRegion.getCapacity()
                        - goodsInRegion.getCurCapacity())) :
                        rand.nextInt((goodsInRegion.getCapacity()
                        - goodsInRegion.getCurCapacity())) / 2);
            }
        }
    }

    /**
     * Getter for goods in the Region
     * @return goodsInRegion
     */
    public Inventory getGoodsInRegion() {
        return goodsInRegion;
    }

    /**
     * Setter for Region's inventory
     * @param goodsInRegion Region's inventory
     */
    public void setGoodsInRegion(Inventory goodsInRegion) {
        this.goodsInRegion = goodsInRegion;
    }

    /**
     * Setter for Region name
     * @param n Region name
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Setter for Region's home
     * @param h Region's home
     */
    public void setHome(String h) {
        home = h;
    }

    /**
     * Setter for Region's x-coordinate
     * @param x x-coordinate
     */
    public void setXcoord(int x) {
        xCoord = x;
    }

    /**
     * Setter for Region's y-coordinate
     * @param y y-coordinate
     */
    public void setYcoord(int y) {
        yCoord = y;
    }

    /**
     * Setter for Region's tech level
     * @param t Region's tech level
     */
    public void setTechLevel(TechLevel t) {
        techLevel = t;
    }

    /**
     * Settter for Region's resource
     * @param r resource
     */
    public void setResource(Resource r) {
        resource = r;
    }

    /**
     * Setter for current event
     * @param curEvent current event
     */
    public void setCurEvent(RadicalPriceEvent curEvent) {
        this.curEvent = curEvent;
    }

    /**
     * Getter for Region's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Region's home
     * @return home
     */
    public String getHome() {
        return home;
    }

    /**
     * Getter for Region's x-coordinate
     * @return x-coordinate
     */
    public int getXcoord() {
        return xCoord;
    }

    /**
     * Getter for Region's y-coordinate
     * @return y-coordinate
     */
    public int getYcoord() {
        return yCoord;
    }

    /**
     * Getter for Region's tech level
     * @return techLevel
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Getter for Region's resource
     * @return resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Getter for current event
     * @return curEvent
     */
    public RadicalPriceEvent getCurEvent() {
        return curEvent;
    }




}


