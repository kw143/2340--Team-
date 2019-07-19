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

        Player player = new Player("test player");
        player.setGood(WATER);
        Region testRe = new Region("test", "test", 0, 0,
                TechLevel.RENAISSANCE, Resource.DESERT);
        Inventory regInv = new Inventory(1000);
        regInv.add(WATER, 100);
        testRe.setGoodsInRegion(regInv);
        player.setCurRegion(testRe, 0);

        Inventory currentInv = player.getInventory();
        currentInv.add(WATER, 10);

        Player player2 = new Player("test not enough money");
        player2.setGood(WATER);
        player2.setCurRegion(testRe, 0);


        TradeFrag.buy(10, 200, player, currentInv, testRe.getGoodsInRegion());
        TradeFrag.buy(10, 10000, player2, currentInv, testRe.getGoodsInRegion());

        // one big assertion
        assertTrue((800 == player.getMoney())
                && (10 == player.getInventory().getCount(WATER))
                && (90 == testRe.getGoodsInRegion().getCount(WATER))
                && (1000 == player2.getMoney())
                && (0 == player2.getInventory().getCount(WATER))
                && (90 == testRe.getGoodsInRegion().getCount(WATER)));
    }

    @Test
    public void testSell() {
        Player player = new Player("test player");
        player.setGood(WATER);
        Region testRe = new Region("test", "test", 0, 0,
                TechLevel.RENAISSANCE, Resource.DESERT);
        Inventory regInv = new Inventory(1000);
        regInv.add(WATER, 100);
        testRe.setGoodsInRegion(regInv);
        player.setCurRegion(testRe, 0);

        Inventory currentInv = player.getInventory();
        currentInv.add(WATER, 50);
        currentInv.subtract(WATER, 40);

        TradeFrag.sell(40, 400, player, currentInv, testRe.getGoodsInRegion());
        // check player money
        assertEquals(1400, player.getMoney());
        // check player inventory
        assertEquals(10, player.getInventory().getCount(WATER));
        // check region inventory
        assertEquals(140, testRe.getGoodsInRegion().getCount(WATER));
    }
}