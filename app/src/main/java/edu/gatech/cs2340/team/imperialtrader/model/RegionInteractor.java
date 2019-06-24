package edu.gatech.cs2340.team.imperialtrader.model;

import java.util.ArrayList;

import edu.gatech.cs2340.team.imperialtrader.entity.Region;


public class RegionInteractor extends Interactor {
    public RegionInteractor(Universe dat) {
        super(dat);
    }

    public ArrayList<Region> getRegionList() {
        return getUniverse().getRegionList();
    }

    public Region getHomeRegion() {
        return getUniverse().getHomeRegion();
    }

    public void updateHomeRegion(Region r) {
        getUniverse().setHomeRegion(r);
    }

    public void updateRegionList(ArrayList<Region> li) {
        getUniverse().setRegionList(li);
    }
}