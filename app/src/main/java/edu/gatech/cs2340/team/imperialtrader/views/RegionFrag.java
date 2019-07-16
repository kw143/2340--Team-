package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.RegionViewModel;

public class RegionFrag extends Fragment {

    private RegionClickListener regionClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            regionClickListener = (RegionClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

    private PlayerViewModel viewModel;
    private RegionViewModel regionViewModel;

    private TextView regionName;
    private TextView regionHomePort;
    private TextView xCoord;
    private TextView yCoord;
    private TextView techLevel;
    private TextView resourceLevel;
    private TextView errorFuel;
    private Button buttonMap;
    private Button buttonPort;


    private Player player;
    private Region region;
    private ArrayList<Region> regionList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.region,
                container, false);
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        regionViewModel = ViewModelProviders.of(this).get(RegionViewModel.class);
        player = viewModel.getPlayer();
        region = player.getCurRegion();
        regionList = regionViewModel.getRegionList();
        errorFuel = view.findViewById(R.id.errorFuel);

        /*
         * Grab the dialog widgets so we can get info for later
         */
        regionName = view.findViewById(R.id.regionName);
        regionHomePort = view.findViewById(R.id.regionHome);
        xCoord = view.findViewById(R.id.x_coordinate);
        yCoord = view.findViewById(R.id.y_coordinate);
        techLevel = view.findViewById(R.id.techLevel);
        resourceLevel = view.findViewById(R.id.resourceLevel);
        buttonMap = view.findViewById(R.id.back);
        buttonPort = view.findViewById(R.id.tradePort);

        regionName.setText(region.getName());
        regionHomePort.setText(region.getHome());
        xCoord.setText(String.valueOf(region.getXcoord()));
        yCoord.setText(String.valueOf(region.getYcoord()));
        techLevel.setText(region.getTechLevel().toString());
        resourceLevel.setText(region.getResource().toString());

        buttonMap.setOnClickListener(v -> regionClickListener.mapClicked());

        buttonPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.getShip().getCurrentFuel() * 50 >= distanceCalc(player.getCurRegion(), regionList.get(10))) {
                    player.setCurRegion(regionList.get(10), distanceCalc(player.getCurRegion(), regionList.get(10)));
                    viewModel.updatePlayer(player);
                    regionClickListener.travelClicked();
                } else {
                    Log.d("Error", "Not enough fuel left to travel there!");
                    errorFuel.setVisibility(View.VISIBLE);
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    errorFuel.setVisibility(View.INVISIBLE);
                                }
                            },
                            2000);
                }

            }
        });

        return view;
    }
    private double distanceCalc(Region region1, Region region2) {
        return (Math.pow(
                Math.pow(region1.getXcoord() - region2.getXcoord(), 2) +
                        Math.pow(region1.getYcoord() - region2.getYcoord(), 2), .5));
    }
}
