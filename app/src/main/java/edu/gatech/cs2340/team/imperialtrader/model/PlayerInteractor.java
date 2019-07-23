package edu.gatech.cs2340.team.imperialtrader.model;

import android.arch.lifecycle.ViewModelProviders;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;

import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.views.MainActivity;


public class PlayerInteractor extends Interactor {

    /**
     * Constructor for PlayerInteractor
     * @param dat Universe data
     */
    public PlayerInteractor(Universe dat) {
        super(dat);
    }


    /**
     * Method to create a player
     * @param p Player
     */
    public void createPlayer (Player p) {

        getUniverse().createPlayer(p);

        writeToFile(p);
    }

    private void writeToFile (Player p) {
        Gson gson;
        gson = new Gson();

        //make object and JSON
        Player playerState = p;
        Log.d("APP", ""+playerState);
        String json = gson.toJson(playerState);
        Log.d("CurrentFile", json);


        //Make file
        File file = new File(MainActivity.path, "Player.json");

        //write to file
        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(json.getBytes());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter for player
     * @return Player
     */
    public Player getPlayer () {
        return getUniverse().getPlayer();
    }

    /**
     * Method to update a player
     * @param p Player
     */
    public void updatePlayer(Player p) {
        getUniverse().updatePlayer(p);
        Log.d("APP", "Interactor: updating player: " + p);

        writeToFile(p);
    }
}
