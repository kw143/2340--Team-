package edu.gatech.cs2340.team.imperialtrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.model.Model;
import edu.gatech.cs2340.team.imperialtrader.model.RegionInteractor;

public class RegionViewModel extends AndroidViewModel {
    private final ArrayList<Region> regionList;
    private final Region home;

    /**
     * Constructor for RegionViewModel
     * @param application Application
     */
    public RegionViewModel(@NonNull Application application) {
        super(application);
        RegionInteractor model = Model.getInstance().getRegionInteractor();
        regionList = model.getRegionList();
        home = model.getHomeRegion();
    }

    /**
     * Method to update Region list
     * @param li regionList
    public void updateRegionList(ArrayList<Region> li) {
        model.updateRegionList(li);
    }

    *//**
     * Method to update home region
     * @param r Region
     *//*
    public void updateHomeRegion(Region r) { model.updateHomeRegion(r); }*/


    /**
     * Getter for home region
     * @return homeRegion
     */
    public Region getHomeRegion() { return home; }

    /**
     * Getter for regionList
     * @return regionList
     */
    public ArrayList<Region> getRegionList() {
        return regionList;
    }
}
