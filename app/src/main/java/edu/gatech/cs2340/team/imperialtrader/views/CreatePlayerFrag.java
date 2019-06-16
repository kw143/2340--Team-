package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.model.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class CreatePlayerFrag extends Fragment {

    /**
     * reference to our view model
     */
    private ConfigurationViewModel viewModel;



    /* ************************
        Widgets we will need for binding and getting information
     */
    private EditText nameField;
    private EditText pilotField;
    private EditText fighterField;
    private EditText traderField;
    private EditText engineerField;

    /* ***********************
       Data for player being edited.
     */
    private Player player;

    /* ***********************
       flag for whether this is a new player being created or an existing player being edited;
     */
    private boolean editing;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.create_player,
                container, false);
        /*
         * Grab the dialog widgets so we can get info for later
         */
        nameField = view.findViewById(R.id.playerName);
        pilotField = view.findViewById(R.id.pilotPoints);
        fighterField = view.findViewById(R.id.fighterPoints);
        traderField = view.findViewById(R.id.traderPoints);
        engineerField = view.findViewById(R.id.engineerPoints);
        Button button = view.findViewById(R.id.createPlayer);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        player = new Player("default");

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("Create", "Create Player Pressed");

                player.setName(nameField.getText().toString());
                player.setPilotPoints(Integer.parseInt(pilotField.getText().toString()));
                player.setFighterPoints(Integer.parseInt(fighterField.getText().toString()));
                player.setTraderPoints(Integer.parseInt(traderField.getText().toString()));
                player.setEngineerPoints(Integer.parseInt(engineerField.getText().toString()));

                Log.d("Edit", "Got new player data: " + player);

                viewModel.createPlayer(player);
            }
        });
        return view;
    }
}
