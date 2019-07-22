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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.entity.Resource;
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
            throw new ClassCastException(context.toString() +
                    " must implement OnHeadlineSelectedListener");
        }
    }

    private PlayerViewModel viewModel;

    private TextView errorFuel;



    private Player player;
    private ArrayList<Region> regionList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.region,
                container, false);
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        RegionViewModel regionViewModel = ViewModelProviders.of(this).get(RegionViewModel.class);
        player = viewModel.getPlayer();
        Region region = player.getCurRegion();
        regionList = regionViewModel.getRegionList();
        //errorFuel = view.findViewById(R.id.errorFuel);

        /*
         * Grab the dialog widgets so we can get info for later
         */

        ImageView regionLine = view.findViewById(R.id.regionLine);
        ImageView regionLine2 = view.findViewById(R.id.regionLine2);
        TextView regionName = view.findViewById(R.id.regionName);
        TextView regionHomePort = view.findViewById(R.id.regionHome);
        TextView xCoord = view.findViewById(R.id.x_coordinate);
        TextView yCoord = view.findViewById(R.id.y_coordinate);
        TextView techLevel = view.findViewById(R.id.techLevel);
        TextView resourceLevel = view.findViewById(R.id.resourceLevel);
        Button buttonMap = view.findViewById(R.id.back);
        Button buttonPort = view.findViewById(R.id.tradePort);

        regionName.setText(regionList.get(10).getName());
        regionHomePort.setText(regionList.get(10).getHome());
        xCoord.setText((String.format("Region x-coordinate: \n %d",
                regionList.get(10).getXcoord())));
        yCoord.setText((String.format("Region y-coordinate: \n %d",
                regionList.get(10).getYcoord())));
        techLevel.setText(String.format("Region Tech Level:\n%s",
                regionList.get(10).getTechLevel().toString()));
        if (regionList.get(10).getResource() != Resource.NOSPECIALRESOURCES) {
            resourceLevel.setText(String.format("Special Resource:\n%s",
                    regionList.get(10).getResource().toString()));
        }
        //img.setMinimumWidth(regionList.get(10).getName().length() * 20);
        //img.setMaxWidth(regionList.get(10).getName().length() * 20);
        regionLine.getLayoutParams().width = regionList.get(10).getName().length() * 50;
        regionLine2.getLayoutParams().width = regionList.get(10).getHome().length() * 30;

        buttonMap.setOnClickListener(v -> regionClickListener.mapClicked());

        buttonPort.setOnClickListener(v -> {
            if ((player.getShip().getCurrentFuel() * 50) >= distanceCalc(player.getCurRegion(),
                    regionList.get(10))) {
                if (regionList.get(10) != player.getCurRegion()) {
                    player.setCurRegion(regionList.get(10), distanceCalc(player.getCurRegion(),
                            regionList.get(10)));
                    viewModel.updatePlayer(player);
                    regionClickListener.toEventClicked();
                } else {
                    regionClickListener.toPortClicked();
                }
            } else {
                Log.d("Error", "Not enough fuel left to travel there!");
                Context context = getActivity().getApplicationContext();
                Toast noFuel = Toast.makeText(context, "Not enough fuel to travel that far!",
                Toast.LENGTH_LONG);
                noFuel.show();
                /*errorFuel.setVisibility(View.VISIBLE);
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                errorFuel.setVisibility(View.INVISIBLE);
                            }
                        },
                        2000);*/

            }

        });

        return view;
    }
    private static double distanceCalc(Region region1, Region region2) {
        return (Math.pow(
                Math.pow(region1.getXcoord() - region2.getXcoord(), 2) +
                        Math.pow(region1.getYcoord() - region2.getYcoord(), 2), .5));
    }

}
