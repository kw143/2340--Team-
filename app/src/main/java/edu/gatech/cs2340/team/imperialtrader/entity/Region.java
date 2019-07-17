package edu.gatech.cs2340.team.imperialtrader.entity;

import java.util.Random;

public class Region {

    private String name;
    private String home;
    private int xcoord;
    private int ycoord;
    private TechLevel techLevel;
    private Resource resource;
    private RadicalPriceEvent curEvent;



    private Inventory goodsInRegion = new Inventory(10000);
    Random rand = new Random();


    public Region(String name, String home, int xcoord, int ycoord,
                  TechLevel techLevel, Resource resource) {
        this.name = name;
        this.home = home;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.techLevel = techLevel;
        this.resource = resource;
        rollEvent();
        restockInventory();
    }

    /**
     * constructor chain
     */
    public Region(String name, String home) {

        int x = rand.nextInt(150);
        int y = rand.nextInt(100);
        int t = rand.nextInt(8);
        int r = rand.nextInt(13);

        this.name = name;
        this.home = home;
        this.xcoord = x;
        this.ycoord = y;
        this.techLevel = TechLevel.values()[t];
        this.resource = Resource.values()[r];
        rollEvent();
        restockInventory();
    }

    public void rollEvent() {
        curEvent = RadicalPriceEvent.getRandomEvent();
    }

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

    public Inventory getGoodsInRegion() {
        return goodsInRegion;
    }

    public void setGoodsInRegion(Inventory goodsInRegion) {
        this.goodsInRegion = goodsInRegion;
    }

    public void setName(String n) {
        name = n;
    }

    public void setHome(String h) {
        home = h;
    }

    public void setXcoord(int x) {
        xcoord = x;
    }

    public void setYcoord(int y) {
        ycoord = y;
    }

    public void setTechLevel(TechLevel t) {
        techLevel = t;
    }

    public void setResource(Resource r) {
        resource = r;
    }

    public void setCurEvent(RadicalPriceEvent curEvent) {
        this.curEvent = curEvent;
    }

    public String getName() {
        return name;
    }

    public String getHome() {
        return home;
    }

    public int getXcoord() {
        return xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public Resource getResource() {
        return resource;
    }

    public RadicalPriceEvent getCurEvent() {
        return curEvent;
    }




}


