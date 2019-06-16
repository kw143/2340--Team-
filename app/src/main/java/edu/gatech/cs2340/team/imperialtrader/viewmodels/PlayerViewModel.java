package edu.gatech.cs2340.team.imperialtrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.team.imperialtrader.model.Model;
import edu.gatech.cs2340.team.imperialtrader.model.Player;
import edu.gatech.cs2340.team.imperialtrader.model.PlayerInteractor;


/**
 * This viewmodel would support activities that need to interact with player
 *
 */
public class PlayerViewModel extends AndroidViewModel {
    private PlayerInteractor model;
    private Player player;

    public PlayerViewModel(@NonNull Application application) {
        super(application);
        model = Model.getInstance().getPlayerInteractor();
        player = model.getPlayer();
    }

    public void updatePlayer(Player p) {
        model.updatePlayer(p);
    }

    public Player getPlayer() { return player; }
}
