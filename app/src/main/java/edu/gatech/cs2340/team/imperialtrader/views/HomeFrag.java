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


import com.google.gson.Gson;

import java.io.File;

import edu.gatech.cs2340.team.imperialtrader.R;

import java.io.File;
import java.io.FileOutputStream;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

/**
 * Fragment for Home region
 */
public class HomeFrag extends Fragment {

    private HomeClickListener homeClickListener;

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
            homeClickListener = (HomeClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnHeadlineSelectedListener");
        }
    }
    @Nullable
    @Override
    /**
     * Method for onCreateView
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,
                container, false);
        Button btn1 = view.findViewById(R.id.ex);
        Button btnNewPlayer = view.findViewById(R.id.np);


        btn1.setOnClickListener(v -> homeClickListener.onExitClick());
        btnNewPlayer.setOnClickListener(v -> homeClickListener.onNpClick());
        return view;
    }
}