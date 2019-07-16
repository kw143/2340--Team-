package edu.gatech.cs2340.team.imperialtrader.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;

public class Universe {
    private Player player = new Player("Default");
    private Random rand = new Random();
    private Region homeRegion;
    private ArrayList<Region> regionList = new ArrayList<>();
    ArrayList<Region> startingRegions = new ArrayList<>(
            Arrays.asList(new Region("Georgia", "Savannah"),
                    new Region("Portugal", "Lisbon"),
                    new Region("Spain", "Barcelona"),
                    new Region("Italy", "Naples"),
                    new Region("Ireland", "Dublin"),
                    new Region("Netherlands", "Amsterdam"),
                    new Region("Belgium", "Antwerp"),
                    new Region("Denmark", "Copenhagen"),
                    new Region("Sweden", "Stockholm"),
                    new Region("Russia", "St. Petersburg"),
                    new Region("Greece", "Athens"),
                    new Region("Singapore", "Singapore"),
                    new Region("Indonesia", "Jakarta"),
                    new Region("Australia", "Sydney"),
                    new Region("China", "Shanghai"),
                    new Region("Japan", "Tokyo"),
                    new Region("Hong Kong", "Hong Kong"),
                    new Region("Canada", "Vancouver"),
                    new Region("Alaska", "Anchorage"),
                    new Region("Argentina", "Buenos Aires"),
                    new Region("Uruguay", "Montevideo"),
                    new Region("Brazil", "Rio de Janeiro"),
                    new Region("Peru", "Lima"),
                    new Region("California", "San Francisco"),
                    new Region("Panama", "Panama City"),
                    new Region("South Africa", "Capetown"),
                    new Region("Morocco", "Rabat"),
                    new Region("Algeria", "Algers"),
                    new Region("Liberia", "Monrovia"),
                    new Region("Ghana", "Accra"),
                    new Region("India", "Mumbai"),
                    new Region("United Arab Emirates", "Dubai"),
                    new Region("Oman", "Muscat"),
                    new Region("Kuwait", "Kuwait City"),
                    new Region("Israel", "Tel Aviv"),
                    new Region("South Korea", "Busan"),
                    new Region("Finland", "Helsinki"),
                    new Region("United Kingdom", "Dover"),
                    new Region("Florida", "Miami"),
                    new Region("Taiwan", "Kaohsiung"),
                    new Region("New York", "New York City"),
                    new Region("Washington", "Seattle"),
                    new Region("Vietnam", "Ho Chi Minh City")));

    public Universe() {
        homeRegion = new Region("HomeCountry", "Home Port");
        regionList.add(homeRegion);
        for(int x = 0; x < 9; x++) {
            int index = rand.nextInt(startingRegions.size());
            regionList.add(startingRegions.get(index));
            startingRegions.remove(index);
        }
        regionList.add(new Region("temp", "orary"));
        player.setCurRegion(homeRegion, -1);
    }

    public void setHomeRegion(Region homeRegion) {
        this.homeRegion = homeRegion;
    }

    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }

    public void addRegion(Region r) {
        regionList.add(r);
    }

    public void removeRegion(Region r) {
        regionList.remove(r);
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    public Region getHomeRegion() {
        return homeRegion;
    }

    public void createPlayer(Player p) {
        player = p;
    }


    public Player getPlayer() { return player; }

    public void updatePlayer(Player p) {
        player = p;
    }

}
