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

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

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

    private TextView regionName;
    private TextView regionHomePort;
    private TextView xCoord;
    private TextView yCoord;
    private TextView techLevel;
    private TextView resourceLevel;
    private Button buttonMap;
    private Button buttonPort;

    private Player player;
    private Region region;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.region,
                container, false);
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = viewModel.getPlayer();
        region = player.getCurRegion();

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

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionClickListener.mapClicked();
            }
        });

        buttonPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regionClickListener.tradeClicked();
            }
        });

        return view;
    }
}
