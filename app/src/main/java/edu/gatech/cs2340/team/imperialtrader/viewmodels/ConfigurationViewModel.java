package edu.gatech.cs2340.team.imperialtrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.team.imperialtrader.model.Model;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.model.PlayerInteractor;

/**
 * View model to create a new player
 */
public class ConfigurationViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;

    /**
     * Constructor for ConfigurationViewModel
     * @param application Application
     */
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    /**
     * Method to create a player
     * @param p Player
     */
    public void createPlayer(Player p) {
        interactor.createPlayer(p);
    }
}

