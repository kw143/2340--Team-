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

public class MapFrag extends Fragment {

    private MapClickListener mapClickListener;

    @Override
    /**
     * onAttach method
     * @param context Context
     */
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mapClickListener = (MapClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnHeadlineSelectedListener");
        }
    }

    private RegionViewModel regionViewModel;
    private PlayerViewModel playerViewModel;
    private TextView currentFuel;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;



    private ArrayList<Region> regionList;
    private Player player;

    /**
     * Method for onCreateView
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map,
                container, false);
        regionViewModel = ViewModelProviders.of(this).get(RegionViewModel.class);
        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        regionList = regionViewModel.getRegionList();
        player = playerViewModel.getPlayer();

        currentFuel = view.findViewById(R.id.currentFuel);
        currentFuel.setText(String.valueOf(player.getShip().getCurrentFuel()));

        /*
         * Grab the dialog widgets so we can get info for later
         */
        button1 = view.findViewById(R.id.buttonI);
        button2 = view.findViewById(R.id.buttonII);
        button3 = view.findViewById(R.id.buttonIII);
        button4 = view.findViewById(R.id.buttonIV);
        button5 = view.findViewById(R.id.buttonV);
        button6 = view.findViewById(R.id.buttonVI);
        button7 = view.findViewById(R.id.buttonVII);
        button8 = view.findViewById(R.id.buttonVIII);
        button9 = view.findViewById(R.id.buttonIX);
        button10 = view.findViewById(R.id.buttonX);

        textView1 = view.findViewById(R.id.textViewI);
        textView2 = view.findViewById(R.id.textViewII);
        textView3 = view.findViewById(R.id.textViewIII);
        textView4 = view.findViewById(R.id.textViewIV);
        textView5 = view.findViewById(R.id.textViewV);
        textView6 = view.findViewById(R.id.textViewVI);
        textView7 = view.findViewById(R.id.textViewVII);
        textView8 = view.findViewById(R.id.textViewVIII);
        textView9 = view.findViewById(R.id.textViewIX);
        textView10 = view.findViewById(R.id.textViewX);
        

        button1.setText(regionList.get(0).getName());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(0));
                mapClickListener.onButtonClicked();
            }
        });

        button2.setText(regionList.get(1).getName());
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(1));
                mapClickListener.onButtonClicked();
            }
        });

        button3.setText(regionList.get(2).getName());
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(2));
                mapClickListener.onButtonClicked();
            }
        });

        button4.setText(regionList.get(3).getName());
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(3));
                mapClickListener.onButtonClicked();
            }
        });

        button5.setText(regionList.get(4).getName());
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regionList.set(10, regionList.get(4));
                mapClickListener.onButtonClicked();
            }
        });

        button6.setText(regionList.get(5).getName());
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(5));
                mapClickListener.onButtonClicked();
            }
        });

        button7.setText(regionList.get(6).getName());
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(6));
                mapClickListener.onButtonClicked();
            }
        });

        button8.setText(regionList.get(7).getName());
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(7));
                mapClickListener.onButtonClicked();
            }
        });

        button9.setText(regionList.get(8).getName());
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(8));
                mapClickListener.onButtonClicked();
            }
        });

        button10.setText(regionList.get(9).getName());
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionList.set(10, regionList.get(9));
                mapClickListener.onButtonClicked();
            }
        });

        textView1.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(0))));
        textView2.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(1))));
        textView3.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(2))));
        textView4.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(3))));
        textView5.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(4))));
        textView6.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(5))));
        textView7.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(6))));
        textView8.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(7))));
        textView9.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(8))));
        textView10.setText(String.format("Distance: %.2f", distanceCalc(player.getCurRegion(),
                regionList.get(9))));
        return view;
    }
    public static double distanceCalc(Region region1, Region region2) {
        return (Math.pow(
                Math.pow(region1.getXcoord() - region2.getXcoord(), 2) +
                        Math.pow(region1.getYcoord() - region2.getYcoord(), 2), .5));
    }
}
