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
import edu.gatech.cs2340.team.imperialtrader.entity.PlayerShip;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class StatusFrag extends Fragment {

    private StatusClickListener statusClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            statusClickListener = (StatusClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    " must implement OnHeadlineSelectedListener");
        }
    }

    private PlayerViewModel viewModel;

    private TextView nameField;
    private TextView pilotField;
    private TextView fighterField;
    private TextView traderField;
    private TextView engineerField;
    private TextView difficulty;
    private TextView ship;
    private TextView money;
    private TextView currentFuel;

    private Player player;

    private Button invButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_current_status,
                container, false);
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        player = viewModel.getPlayer();

        /*
         * Grab the dialog widgets so we can get info for later
         */
        nameField = view.findViewById(R.id.playerName);
        pilotField = view.findViewById(R.id.pilotPoints);
        fighterField = view.findViewById(R.id.fighterPoints);
        traderField = view.findViewById(R.id.traderPoints);
        engineerField = view.findViewById(R.id.engineerPoints);
        difficulty = view.findViewById(R.id.dif);
        ship = view.findViewById(R.id.ship);
        money = view.findViewById(R.id.mon);
        currentFuel = view.findViewById(R.id.currentFuel);

        invButton = view.findViewById(R.id.invbutton);

        nameField.setText(player.getName());
        pilotField.setText(String.valueOf(player.getPilotPoints()));
        fighterField.setText(String.valueOf(player.getFighterPoints()));
        traderField.setText(String.valueOf(player.getTraderPoints()));
        engineerField.setText(String.valueOf(player.getEngineerPoints()));
        difficulty.setText(String.format("Difficulty: %s", player.getDifficulty()));
        ship.setText(String.valueOf(player.getShip().getName()));
        money.setText(String.valueOf(player.getMoney()));
        currentFuel.setText(String.valueOf(player.getShip().getCurrentFuel()));


        invButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusClickListener.toInvClicked();
            }
        });

        return view;
    }
}