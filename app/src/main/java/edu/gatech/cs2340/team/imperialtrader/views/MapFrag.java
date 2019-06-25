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

import java.util.ArrayList;

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
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

    private RegionViewModel regionViewModel;
    private PlayerViewModel playerViewModel;

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


    private ArrayList<Region> regionList;
    private Player player;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map,
                container, false);
        regionViewModel = ViewModelProviders.of(this).get(RegionViewModel.class);
        playerViewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        regionList = regionViewModel.getRegionList();
        player = playerViewModel.getPlayer();

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

        button10.setText(regionList.get(9).getName());
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(9));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button1.setText(regionList.get(0).getName());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(0));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button2.setText(regionList.get(1).getName());
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(1));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button3.setText(regionList.get(2).getName());
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(2));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button4.setText(regionList.get(3).getName());
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(3));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button5.setText(regionList.get(4).getName());
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(4));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button6.setText(regionList.get(5).getName());
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(5));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button7.setText(regionList.get(6).getName());
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(6));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button8.setText(regionList.get(7).getName());
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(7));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        button9.setText(regionList.get(8).getName());
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setCurRegion(regionList.get(8));
                playerViewModel.updatePlayer(player);
                mapClickListener.onButtonClicked();
            }
        });

        return view;
    }
}
