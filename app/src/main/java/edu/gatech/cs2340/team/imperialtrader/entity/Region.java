package edu.gatech.cs2340.team.imperialtrader.model;

import java.util.Random;

public class Region {

    private String name;
    private String home;
    private int xcoord;
    private int ycoord;
    private int techLevel;
    private int resource;


    public Region(String name, String home, int xcoord, int ycoord, int techLevel, int resource) {
        this.name = name;
        this.home = home;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.techLevel = techLevel;
        this.resource = resource;
    }

    /** constructor chain */
    public Region(String name, String home) {
        Random rand = new Random();

        int x = rand.nextInt(150);
        int y = rand.nextInt(100);
        int t = rand.nextInt(8);
        int r = rand.nextInt(13);

        this.name = name;
        this.home = home;
        this.xcoord = x;
        this.ycoord = y;
        this.techLevel = t;
        this.resource = r;
    }

    public void setName(String n) { name = n; }

    public void setHome(String h) { home = h; }

    public void setXcoord(int x) { xcoord = x; }

    public void setYcoord(int y) { ycoord = y; }

    public void setTechLevel(int t) { techLevel = t; }

    public void setResource(int r) { resource = r; }

    public String getName() { return name; }

    public String getHome() { return home; }

    public int getXcoord() { return xcoord; }

    public int getYcoord() { return ycoord; }

    public int getTechLevel() { return techLevel; }

    public int getResource() { return resource; }
}


/**
new Region("Georgia", "Savannah");
new Region("Portugal", "Lisbon");
new Region("Spain", "Barcelona");
new Region("Italy", "Naples");
new Region("Ireland", "Dublin");
new Region("Netherlands", "Amsterdam");
new Region("Belgium", "Antwerp");
new Region("Denmark", "Copenhagen");
new Region("Sweden", "Stockholm");
new Region("Russia", "St. Petersburg");
new Region("Greece", "Athens");
new Region("Singapore", "Singapore");
new Region("Indonesia", "Jakarta");
new Region("Australia", "Sydney");
new Region("China", "Shanghai");
new Region("Japan", "Tokyo");
new Region("Hong Kong", "Hong Kong");
new Region("Canada", "Vancouver");
new Region("Alaska", "Anchorage");
new Region("Argentina", "Buenos Aires");
new Region("Uruguay", "Montevideo");
new Region("Brazil", "Rio de Janeiro");
new Region("Peru", "Lima");
new Region("California", "San Francisco");
new Region("Panama", "Panama City");
new Region("South Africa", "Capetown");
new Region("Morocco", "Rabat");
new Region("Algeria", "Algers");
new Region("Liberia", "Monrovia");
new Region("Ghana", "Accra");
new Region("India", "Mumbai");
new Region("United Arab Emirates", "Dubai");
new Region("Oman", "Muscat");
new Region("Kuwait", "Kuwait City");
new Region("Israel", "Tel Aviv");
new Region("South Korea", "Busan");
new Region("Finland", "Helsinki");
new Region("United Kingdom", "Dover");
new Region("Florida", "Miami");
new Region("Taiwan", "Kaohsiung");
new Region("New York", "New York City");
new Region("Washington", "Seattle");
new Region("Vietnam", "Ho Chi Minh City");
*/