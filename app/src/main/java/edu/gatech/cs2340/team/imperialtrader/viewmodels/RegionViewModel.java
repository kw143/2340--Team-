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

    public RegionViewModel(@NonNull Application application) {
        super(application);
        RegionInteractor model = Model.getInstance().getRegionInteractor();
        regionList = model.getRegionList();
        home = model.getHomeRegion();
    }

// --Commented out by Inspection START (7/23/2019 12:32 AM):
//    public void updateRegionList(ArrayList<Region> li) {
//        model.updateRegionList(li);
//    }
// --Commented out by Inspection STOP (7/23/2019 12:32 AM)

    // public void updateHomeRegion(Region r) { model.updateHomeRegion(r); }

    public Region getHomeRegion() { return home; }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }
}
