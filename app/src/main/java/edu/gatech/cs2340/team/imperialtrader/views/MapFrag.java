package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
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
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.RegionViewModel;

public class MapFrag extends Fragment {

    private RegionViewModel viewModel;

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

    private ArrayList<Button> buttonArrayList = new ArrayList<>();

    private ArrayList<Region> regionList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map,
                container, false);
        viewModel = ViewModelProviders.of(this).get(RegionViewModel.class);
        regionList = viewModel.getRegionList();

        /*
         * Grab the dialog widgets so we can get info for later
         */
        buttonArrayList.add(view.findViewById(R.id.buttonI));
        buttonArrayList.add(view.findViewById(R.id.buttonII));
        buttonArrayList.add(view.findViewById(R.id.buttonIII));
        buttonArrayList.add(view.findViewById(R.id.buttonIV));
        buttonArrayList.add(view.findViewById(R.id.buttonV));
        buttonArrayList.add(view.findViewById(R.id.buttonVI));
        buttonArrayList.add(view.findViewById(R.id.buttonVII));
        buttonArrayList.add(view.findViewById(R.id.buttonVIII));
        buttonArrayList.add(view.findViewById(R.id.buttonIX));
        buttonArrayList.add(view.findViewById(R.id.buttonX));

        for (int x = 0; x < 10; x++) {
            buttonArrayList.get(x).setText(regionList.get(x).getName());
        }

        return view;
    }
}
