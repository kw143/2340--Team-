package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.RegionViewModel;

public class MapFrag extends Fragment {

    private MapClickListener mapClickListener;

    @Override
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

    private ArrayList<Region> regionList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map,
                container, false);
        RegionViewModel regionViewModel = ViewModelProviders.of(this).get(RegionViewModel.class);
        PlayerViewModel playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        regionList = regionViewModel.getRegionList();
        Player player = playerViewModel.getPlayer();


        TextView currentFuel = view.findViewById(R.id.currentFuel);

        currentFuel.setText(String.valueOf(player.getShip().getCurrentFuel()));

        /*
         * Grab the dialog widgets so we can get info for later
         */
        Button helpButton = view.findViewById(R.id.helpButton);


        Context context = Objects.requireNonNull(getActivity()).getApplicationContext();
        Toast helpToast = Toast.makeText(context, "Tap a region to preview or travel to it",
                Toast.LENGTH_SHORT);
        helpButton.setText("?");
        helpButton.setOnClickListener(v -> helpToast.show());

        Button button1 = view.findViewById(R.id.buttonI);
        Button button2 = view.findViewById(R.id.buttonII);
        Button button3 = view.findViewById(R.id.buttonIII);
        Button button4 = view.findViewById(R.id.buttonIV);
        Button button5 = view.findViewById(R.id.buttonV);
        Button button6 = view.findViewById(R.id.buttonVI);
        Button button7 = view.findViewById(R.id.buttonVII);
        Button button8 = view.findViewById(R.id.buttonVIII);
        Button button9 = view.findViewById(R.id.buttonIX);
        Button button10 = view.findViewById(R.id.buttonX);

        TextView textView1 = view.findViewById(R.id.textViewI);
        TextView textView2 = view.findViewById(R.id.textViewII);
        TextView textView3 = view.findViewById(R.id.textViewIII);
        TextView textView4 = view.findViewById(R.id.textViewIV);
        TextView textView5 = view.findViewById(R.id.textViewV);
        TextView textView6 = view.findViewById(R.id.textViewVI);
        TextView textView7 = view.findViewById(R.id.textViewVII);
        TextView textView8 = view.findViewById(R.id.textViewVIII);
        TextView textView9 = view.findViewById(R.id.textViewIX);
        TextView textView10 = view.findViewById(R.id.textViewX);

        button1.setText(regionList.get(0).getName());
        button1.setOnClickListener(v -> {
            regionList.set(10, regionList.get(0));
            mapClickListener.onButtonClicked();
        });

        button2.setText(regionList.get(1).getName());
        button2.setOnClickListener(v -> {
            regionList.set(10, regionList.get(1));
            mapClickListener.onButtonClicked();
        });

        button3.setText(regionList.get(2).getName());
        button3.setOnClickListener(v -> {
            regionList.set(10, regionList.get(2));
            mapClickListener.onButtonClicked();
        });

        button4.setText(regionList.get(3).getName());
        button4.setOnClickListener(v -> {
            regionList.set(10, regionList.get(3));
            mapClickListener.onButtonClicked();
        });

        button5.setText(regionList.get(4).getName());
        button5.setOnClickListener(v -> {

            regionList.set(10, regionList.get(4));
            mapClickListener.onButtonClicked();
        });

        button6.setText(regionList.get(5).getName());
        button6.setOnClickListener(v -> {
            regionList.set(10, regionList.get(5));
            mapClickListener.onButtonClicked();
        });

        button7.setText(regionList.get(6).getName());
        button7.setOnClickListener(v -> {
            regionList.set(10, regionList.get(6));
            mapClickListener.onButtonClicked();
        });

        button8.setText(regionList.get(7).getName());
        button8.setOnClickListener(v -> {
            regionList.set(10, regionList.get(7));
            mapClickListener.onButtonClicked();
        });

        button9.setText(regionList.get(8).getName());
        button9.setOnClickListener(v -> {
            regionList.set(10, regionList.get(8));
            mapClickListener.onButtonClicked();
        });

        button10.setText(regionList.get(9).getName());
        button10.setOnClickListener(v -> {
            regionList.set(10, regionList.get(9));
            mapClickListener.onButtonClicked();
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
        final double pow = .5;
        return (Math.pow(
                Math.pow(region1.getXcoord() - region2.getXcoord(), 2) +
                        Math.pow(region1.getYcoord() - region2.getYcoord(), 2), pow));
    }
}
