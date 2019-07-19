package edu.gatech.cs2340.team.imperialtrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Random;

import edu.gatech.cs2340.team.imperialtrader.model.Model;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.model.PlayerInteractor;

import static edu.gatech.cs2340.team.imperialtrader.entity.Good.FIREARMS;
import static edu.gatech.cs2340.team.imperialtrader.entity.Good.WATER;

public class EventViewModel extends AndroidViewModel {
    private PlayerInteractor model;
    private Player player;

    public EventViewModel(@NonNull Application application) {
        super(application);
        model = Model.getInstance().getPlayerInteractor();
        player = model.getPlayer();
    }

    public String randomEvent() {
        Random random = new Random();
        int number = random.nextInt(10);

        if (number == 4) {
            if (player.getInventory().hasGood(WATER)) {
                player.getInventory().subtract(WATER, player.getInventory().getCount(WATER) / 2);
            }
            updatePlayer(player);
            return "Your ship went through the Bermuda Triangle and you lost half of your water.";
        } else if (number == 5) {
            player.setMoney(player.getMoney() + 1000);
            updatePlayer(player);
            return "You discovered a treasure chest and found $1000 worth of coins inside.";
        } else if (number == 6) {
            if (player.getInventory().hasGood(FIREARMS)) {
                player.getInventory().subtract(FIREARMS, player.getInventory().getCount(FIREARMS));
            }
            updatePlayer(player);
            return "A rival ship attacked you and you had to use all "
                    + "of your firearms to fight them off.";
        } else if (number == 7) {
            player.getInventory().add(FIREARMS, 40);
            updatePlayer(player);
            return "A friendly ship approached you and gifted you 40 firearms "
                    + "to fight off other ships.";
        } else if (number > 7) {
            return "Police";
        } else {
            return "You arrived safely at your destination.";
        }
    }

    
    public void updatePlayer(Player p) {
        model.updatePlayer(p);
    }
}