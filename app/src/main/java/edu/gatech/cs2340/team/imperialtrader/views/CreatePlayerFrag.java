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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.ConfigurationViewModel;

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
    private Spinner  difficultySpinner;
    private TextView errorText;
    private TextView errorNumText;
    private TextView successfulText;

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
        difficultySpinner = view.findViewById(R.id.difficulty_spinner);
        errorText = view.findViewById(R.id.pointError);
        errorNumText = view.findViewById(R.id.numError);
        successfulText = view.findViewById(R.id.successfulIndicator);
        Button button = view.findViewById(R.id.createPlayer);

        List<String> dif = new ArrayList<>();
        dif.add("easy");
        dif.add("normal");
        dif.add("hard");
        dif.add("suicidal");

        /*
          Set up the adapter to display the allowable difficulty in the spinner
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, dif);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        player = new Player("default");

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("Create", "Create Player Pressed");
                player.setName(nameField.getText().toString());
                if (pilotField.getText().toString().equals("") || fighterField.getText().toString().equals("") || traderField.getText().toString().equals("") || engineerField.getText().toString().equals("")) {
                    errorNumText.setVisibility(View.VISIBLE);
                } else {
                    errorNumText.setVisibility(View.INVISIBLE);
                    player.setPilotPoints(Integer.parseInt(pilotField.getText().toString()));
                    player.setFighterPoints(Integer.parseInt(fighterField.getText().toString()));
                    player.setTraderPoints(Integer.parseInt(traderField.getText().toString()));
                    player.setEngineerPoints(Integer.parseInt(engineerField.getText().toString()));
                    player.setDifficulty((String) difficultySpinner.getSelectedItem());

                    if (player.getTotalPoints() != 16) {
                        errorText.setVisibility(View.VISIBLE);
                        successfulText.setVisibility(View.INVISIBLE);
                    } else {
                        Log.d("Edit", "Got new player data: " + player);
                        errorText.setVisibility(View.INVISIBLE);
                        successfulText.setVisibility(View.VISIBLE);
                        viewModel.createPlayer(player);
                    }
                }
            }
        });
        return view;
    }
}
