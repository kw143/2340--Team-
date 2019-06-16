package edu.gatech.cs2340.team.imperialtrader.views;

import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import edu.gatech.cs2340.team.imperialtrader.R;
import edu.gatech.cs2340.team.imperialtrader.model.Database;
import edu.gatech.cs2340.team.imperialtrader.model.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class PlayerStatusActivity extends AppCompatActivity {

    private PlayerViewModel viewModel;

    private TextView nameField;
    private TextView pilotField;
    private TextView fighterField;
    private TextView traderField;
    private TextView engineerField;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_current_status);
        player = viewModel.getPlayer();

        /*
         * Grab the dialog widgets so we can get info for later
         */
        nameField = findViewById(R.id.playerName);
        pilotField = findViewById(R.id.pilotPoints);
        fighterField = findViewById(R.id.fighterPoints);
        traderField = findViewById(R.id.traderPoints);
        engineerField = findViewById(R.id.engineerPoints);

        nameField.setText(player.getName());
        pilotField.setText(player.getPilotPoints());
        fighterField.setText(player.getFighterPoints());
        traderField.setText(player.getTraderPoints());
        engineerField.setText(player.getEngineerPoints());

        viewModel = ViewModelProviders.of(this).get(PlayerViewModel.class);
    }
}
