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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_current_status,
                container, false);
        PlayerViewModel viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
        Player player = viewModel.getPlayer();

        /*
         * Grab the dialog widgets so we can get info for later
         */
        TextView nameField = view.findViewById(R.id.playerName);
        TextView pilotField = view.findViewById(R.id.pilotPoints);
        TextView fighterField = view.findViewById(R.id.fighterPoints);
        TextView traderField = view.findViewById(R.id.traderPoints);
        TextView engineerField = view.findViewById(R.id.engineerPoints);
        TextView difficulty = view.findViewById(R.id.dif);
        TextView ship = view.findViewById(R.id.ship);
        TextView money = view.findViewById(R.id.mon);
        TextView currentFuel = view.findViewById(R.id.currentFuel);

        Button invButton = view.findViewById(R.id.invbutton);

        nameField.setText(player.getName());
        pilotField.setText(String.valueOf(player.getPilotPoints()));
        fighterField.setText(String.valueOf(player.getFighterPoints()));
        traderField.setText(String.valueOf(player.getTraderPoints()));
        engineerField.setText(String.valueOf(player.getEngineerPoints()));
        difficulty.setText(player.getDifficulty());
        ship.setText(String.valueOf(player.getShip().getName()));
        money.setText(String.valueOf(player.getMoney()));
        currentFuel.setText(String.valueOf(player.getShip().getCurrentFuel()));


        invButton.setOnClickListener(v -> statusClickListener.toInvClicked());

        return view;
    }
}