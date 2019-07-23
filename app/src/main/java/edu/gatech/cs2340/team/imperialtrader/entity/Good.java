package edu.gatech.cs2340.team.imperialtrader.entity;

public enum Good {
    WATER("Water", TechLevel.PREAGRICULTURE,  TechLevel.PREAGRICULTURE, TechLevel.MEDIEVAL,
            30,  3, 4,RadicalPriceEvent.DROUGHT, Resource.LOTSOFWATER, Resource.DESERT, 30, 50),
    FURS("Furs",  TechLevel.PREAGRICULTURE,  TechLevel.PREAGRICULTURE,  TechLevel.PREAGRICULTURE,
            250,10, 10,    RadicalPriceEvent.COLD, Resource.RICHFAUNA,Resource.LIFELESS,230,280),
    FOOD("Food", TechLevel.AGRICULTURE, TechLevel.PREAGRICULTURE,  TechLevel.AGRICULTURE,
            100,  5, 5,   RadicalPriceEvent.CROPFAIL, Resource.RICHSOIL,Resource.POORSOIL, 90,160),
    ORE("Ore", TechLevel.MEDIEVAL, TechLevel.MEDIEVAL,  TechLevel.RENAISSANCE,
            350,20, 10,   RadicalPriceEvent.WAR,
            Resource.MINERALRICH, Resource.MINERALPOOR,350,420),
    GAMES("Games",  TechLevel.RENAISSANCE, TechLevel.AGRICULTURE,  TechLevel.POSTINDUSTRIAL,
            250,-10, 5,   RadicalPriceEvent.BOREDOM, Resource.ARTISTIC,null,160,270),
    FIREARMS("Firearms",  TechLevel.RENAISSANCE, TechLevel.AGRICULTURE,  TechLevel.INDUSTRIAL,
            1250,-75,100,   RadicalPriceEvent.WAR, Resource.WARLIKE,null,600,1100),
    MEDICINE("Medicine",  TechLevel.EARLYINDUSTRIAL,
            TechLevel.AGRICULTURE,  TechLevel.POSTINDUSTRIAL,
            650,-20, 10,   RadicalPriceEvent.PLAGUE, Resource.LOTSOFHERBS,null,400,700),
    MACHINES("Machines",  TechLevel.EARLYINDUSTRIAL,  TechLevel.RENAISSANCE,  TechLevel.INDUSTRIAL,
            900,-30,5, RadicalPriceEvent.LACKOFWORKERS, null,null,600,800),
    NARCOTICS("Narcotics",  TechLevel.INDUSTRIAL, TechLevel.PREAGRICULTURE,  TechLevel.INDUSTRIAL,
            3500,-125,150,  RadicalPriceEvent.BOREDOM, Resource.WEIRDMUSHROOMS,null,2000,3000),
    ROBOTS("Robots",  TechLevel.POSTINDUSTRIAL,  TechLevel.EARLYINDUSTRIAL,  TechLevel.HITECH,
            5000,-150,100,RadicalPriceEvent.LACKOFWORKERS, null,null,3500,5000);

    private final String name;
    // --Commented out by Inspection (7/23/2019 12:31 AM):private int price;
    private final TechLevel MLTP;
    private final TechLevel MLTU;
    private final TechLevel TTP;
    private final int basePrice;
    private final double IPL;
    private final double var;
    private final RadicalPriceEvent IE;
    private final Resource CR;
    private final Resource ER;
    private final double MTL;
    private final double MTH;

    /**
     * Creates a Good object holding given data
     *
     * @param name name
     * @param MLTP MLTP
     * @param MLTU MLTU
     * @param TTP TTP
     * @param basePrice basePrice of Good
     * @param IPL IPL
     * @param var var
     * @param IE IE
     * @param CR CR
     * @param ER ER
     * @param MTL MTL
     * @param MTH MTH
     */
    Good(String name, TechLevel MLTP, TechLevel MLTU, TechLevel TTP, int basePrice,
         double IPL, double var, RadicalPriceEvent IE,
         Resource CR, Resource ER, double MTL, double MTH) {
        this.name = name;
        //this.price = price;
        this.MLTP = MLTP;
        this.MLTU = MLTU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.var = var;
        this.IE = IE;
        this.CR = CR;
        this.ER = ER;
        this.MTL = MTL;
        this.MTH = MTH;
    }


    /**
     * Getter for MLTP
     * @return MLTP
     */
    public TechLevel getMLTP() {
        return MLTP;
    }

    /**
     * Getter for MLTU
     * @return MLTU
     */
    public TechLevel getMLTU() {
        return MLTU;
    }

    /**
     * Getter for TTP
     * @return TTP
     */
    public TechLevel getTTP() {
        return TTP;
    }

    /**
     * Getter for base price of a good
     * @return basePrice
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * Getter for IPL
     * @return IPL
     */
    public double getIPL() {
        return IPL;
    }

    /**
     * Getter for var
     * @return var
     */
    public double getVar() {
        return var;
    }

    /**
     * Getter for IE
     * @return IE
     */
    public RadicalPriceEvent getIE() {
        return IE;
    }

    /**
     * Getter for CR
     * @return CR
     */
    public Resource getCR() {
        return CR;
    }

    /**
     * Getter for ER
     * @return ER
     */
    public Resource getER() {
        return ER;
    }

    /**
     * Getter for MTL
     * @return MTL
     */
    public double getMTL() {
        return MTL;
    }

    /**
     * Getter for MTH
     * @return MTH
     */
    public double getMTH() {
        return MTH;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return this.name;
    }
}
