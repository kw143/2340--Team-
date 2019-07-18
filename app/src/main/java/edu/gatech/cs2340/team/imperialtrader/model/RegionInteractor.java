package edu.gatech.cs2340.team.imperialtrader.model;

import java.util.ArrayList;

import edu.gatech.cs2340.team.imperialtrader.entity.Region;


public class RegionInteractor extends Interactor {

    /**
     * Constructor for RegionInteractor
     * @param dat Universe data
     */
    public RegionInteractor(Universe dat) {
        super(dat);
    }

    /**
     * Get a list of regions
     * @return RegionList
     */
    public ArrayList<Region> getRegionList() {
        return getUniverse().getRegionList();
    }

    /**
     * Gets the home region
     * @return Region homeRegion
     */
    public Region getHomeRegion() {
        return getUniverse().getHomeRegion();
    }

    /**
     * Method to update home region
     * @param r Region
     */
    public void updateHomeRegion(Region r) {
        getUniverse().setHomeRegion(r);
    }

    /**
     * Method to update list of regions
     * @param li list of regions
     */
    public void updateRegionList(ArrayList<Region> li) {
        getUniverse().setRegionList(li);
    }
}