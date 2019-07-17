package edu.gatech.cs2340.team.imperialtrader.views;

import org.junit.Test;

import edu.gatech.cs2340.team.imperialtrader.entity.Inventory;
import edu.gatech.cs2340.team.imperialtrader.entity.Player;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.entity.Resource;
import edu.gatech.cs2340.team.imperialtrader.entity.TechLevel;

import static edu.gatech.cs2340.team.imperialtrader.entity.Good.WATER;
import static org.junit.Assert.*;

public class TradeFragTest {

    @Test
    public void testBuy() {

        TradeFrag underTest = new TradeFrag();

        Player player = new Player("test player");
        player.setGood(WATER);
        Region testRe = new Region("test", "test", 0, 0,
                TechLevel.RENAISSANCE, Resource.DESERT);
        Inventory inv = new Inventory();
        inv.add(WATER, 100);
        testRe.setGoodsInRegion(inv);
        player.setCurRegion(testRe, 0);

        Inventory currentInv = player.getInventory();
        currentInv.add(WATER, 10);

        TradeFrag.buy(10, 200, player, currentInv, testRe.getGoodsInRegion());
        // check player money
        assertEquals(800, player.getMoney());
        // check player inventory
        assertEquals(10, player.getInventory().getCount(WATER));
        // check region inventory
        assertEquals(90, testRe.getGoodsInRegion().getCount(WATER));
    }

    @Test

}