package edu.gatech.cs2340.team.imperialtrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.model.Model;
import edu.gatech.cs2340.team.imperialtrader.model.RegionInteractor;

public class RegionViewModel extends AndroidViewModel {
    private RegionInteractor model;
    private ArrayList<Region> regionList;
    private Region home;

    public RegionViewModel(@NonNull Application application) {
        super(application);
        model = Model.getInstance().getRegionInteractor();
        regionList = model.getRegionList();
        home = model.getHomeRegion();
    }

    public void updateRegionList(ArrayList<Region> li) {
        model.updateRegionList(li);
    }

    public void updateHomeRegion(Region r) { model.updateHomeRegion(r); }

    public Region getHomeRegion() { return home; }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }
}
