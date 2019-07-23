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
                    new Region("UAE", "Dubai"),
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

    /**
     * Default Universe constructor
     */
    public Universe() {
        homeRegion = new Region("HomeCountry", "Home Port");
        regionList.add(homeRegion);
        for(int x = 0; x < 9; x++) {
            int index = rand.nextInt(startingRegions.size());
            for(int y = 0; y < regionList.size(); y++){
                if(regionList.get(y).getXcoord() == startingRegions.get(index).getXcoord()){
                    if(regionList.get(y).getYcoord() == startingRegions.get(index).getYcoord()){
                        boolean checker = false;
                        while(!checker){
                            startingRegions.set(index,
                                    new Region(startingRegions.get(index).getName(),
                                    startingRegions.get(index).getHome()));
                            checker = true;
                            if(regionList.get(y).getXcoord() ==
                                    startingRegions.get(index).getXcoord()) {
                                if (regionList.get(y).getYcoord() ==
                                        startingRegions.get(index).getYcoord()) {
                                    checker = false;
                                    y = 0;
                                }
                            }

                        }
                    }
                }
            }
            regionList.add(startingRegions.get(index));
            startingRegions.remove(index);
        }
        regionList.add(new Region("temp", "orary"));
        player.setCurRegion(homeRegion, -1);
    }

    /**
     * homeRegion setter
     * @param homeRegion homeRegion
     */
    public void setHomeRegion(Region homeRegion) {
        this.homeRegion = homeRegion;
    }

    /**
     * Region list setter
     * @param regionList list of regions
     */
    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }

    /**
     * Method to add region to regionList
     * @param r Region
     */
    public void addRegion(Region r) {
        regionList.add(r);
    }

    /**
     * Method to remove region from regionLits
     * @param r Region
     */
    public void removeRegion(Region r) {
        regionList.remove(r);
    }

    /**
     * Getter for regionList
     * @return regionList
     */
    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    /**
     * Getter for homeRegion
     * @return homeRegion
     */
    public Region getHomeRegion() {
        return homeRegion;
    }

    /**
     * Method to create a new Player
     * @param p Player
     */
    public void createPlayer(Player p) {
        player = p;
    }

    /**
     * Getter for Player
     * @return Player
     */
    public Player getPlayer() { return player; }

    /**
     * Method to update a player
     * @param p Player
     */
    public void updatePlayer(Player p) {
        player = p;
    }

}
