package edu.gatech.cs2340.team.imperialtrader.views;

import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.model.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.ConfigurationViewModel;

/**
 * This class acts as the code behind for editing a player or creating a new player
 */
public class ConfigurationActivity extends AppCompatActivity {

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
    private TextView errorText;


    /* ***********************
       Data for player being edited.
     */
    private Player player;

    /* ***********************
       flag for whether this is a new player being created or an existing player being edited;
     */
    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_player);


        /*
         * Grab the dialog widgets so we can get info for later
         */
        nameField = findViewById(R.id.playerName);
        pilotField = findViewById(R.id.pilotPoints);
        fighterField = findViewById(R.id.fighterPoints);
        traderField = findViewById(R.id.traderPoints);
        engineerField = findViewById(R.id.engineerPoints);
        errorText = findViewById(R.id.pointError);
        Button button = findViewById(R.id.createPlayer);



        nameField.setText(player.getName());

        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
    }

    /**
     * Button handler for the create new player button
     *
     * @param view the button that was pressed
     */
    public void onCreate(View view) {
        Log.d("Create", "Create Player Pressed");

        player.setName(nameField.getText().toString());
        player.setPilotPoints(Integer.parseInt(pilotField.getText().toString()));
        player.setFighterPoints(Integer.parseInt(fighterField.getText().toString()));
        player.setTraderPoints(Integer.parseInt(traderField.getText().toString()));
        player.setEngineerPoints(Integer.parseInt(engineerField.getText().toString()));
        if(player.getTotalPoints() != 16){
            errorText.setVisibility(View.VISIBLE);
        } else {

            Log.d("Edit", "Got new player data: " + player);
            viewModel.createPlayer(player);

            finish();
        }
    }
}
