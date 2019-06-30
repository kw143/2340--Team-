package edu.gatech.cs2340.team.imperialtrader.entity;

public enum Good {
    WATER("Water", TechLevel.PREAGRICULTURE,  TechLevel.PREAGRICULTURE, TechLevel.MEDIEVAL,   30,  3, 4,RadicalPriceEvent.DROUGHT, Resource.LOTSOFWATER, Resource.DESERT, 30, 50),
    FURS("Furs",  TechLevel.PREAGRICULTURE,  TechLevel.PREAGRICULTURE,  TechLevel.PREAGRICULTURE, 250,10, 10,    RadicalPriceEvent.COLD, Resource.RICHFAUNA,Resource.LIFELESS,230,280),
    FOOD("Food", TechLevel.AGRIULTURE, TechLevel.PREAGRICULTURE,  TechLevel.AGRIULTURE, 100,  5, 5,   RadicalPriceEvent.CROPFAIL, Resource.RICHSOIL,Resource.POORSOIL, 90,160),
    ORE("Ore", TechLevel.MEDIEVAL, TechLevel.MEDIEVAL,  TechLevel.RENAISSANCE, 350,20, 10,   RadicalPriceEvent.WAR, Resource.MINERALRICH, Resource.MINERALPOOR,350,420),
    GAMES("Games",  TechLevel.RENAISSANCE, TechLevel.AGRIULTURE,  TechLevel.POSTINDUSTRIAL, 250,-10, 5,   RadicalPriceEvent.BOREDOM, Resource.ARTISTIC,null,160,270),
    FIREARMS("Firearms",  TechLevel.RENAISSANCE, TechLevel.AGRIULTURE,  TechLevel.INDUSTRIAL,1250,-75,100,   RadicalPriceEvent.WAR, Resource.WARLIKE,null,600,1100),
    MEDICINCE("Medicine",  TechLevel.EARLYINDUSTRIAL, TechLevel.AGRIULTURE,  TechLevel.POSTINDUSTRIAL, 650,-20, 10,   RadicalPriceEvent.PLAGUE, Resource.LOTSOFHERBS,null,400,700),
    MACHINES("Machines",  TechLevel.EARLYINDUSTRIAL,  TechLevel.RENAISSANCE,  TechLevel.INDUSTRIAL, 900,-30,5, RadicalPriceEvent.LACKOFWORKERS, null,null,600,800),
    NARCOTICS("Narcotics",  TechLevel.INDUSTRIAL, TechLevel.PREAGRICULTURE,  TechLevel.INDUSTRIAL,3500,-125,150,  RadicalPriceEvent.BOREDOM, Resource.WEIRDMUSHROOMS,null,2000,3000),
    ROBOTS("Robots",  TechLevel.POSTINDUSTRIAL,  TechLevel.EARLYINDUSTRIAL,  TechLevel.HITECH,5000,-150,100,RadicalPriceEvent.LACKOFWORKERS, null,null,3500,5000);
    private String name;
    private int price;
    Good(String name, TechLevel MLTP, TechLevel MLTU, TechLevel TTP, int basePrice,
         double IPL, double var, RadicalPriceEvent IE,
         Resource CR, Resource ER, double MTL, double MTH) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return price;
    }
}
