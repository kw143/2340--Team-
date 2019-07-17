package edu.gatech.cs2340.team.imperialtrader.views;

import android.arch.lifecycle.ViewModelProviders;

import org.junit.Test;

import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.viewmodels.PlayerViewModel;

public class TradeFragTest {

    @Test
    public void testBuy() {

        TradeFrag underTest = new TradeFrag();

        PlayerViewModel playerViewModel = ViewModelProviders.of(underTest).get(PlayerViewModel.class);
        Player player = playerViewModel.getPlayer();
        assertEquals();
    }
}