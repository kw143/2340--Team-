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

        Player player = new Player();
        Region testRe = new Region("test", "test", 0, 0,
                TechLevel.RENAISSANCE, Resource.DESERT);
        Inventory inv = new Inventory();
        inv.add(WATER, 100);
        testRe.setGoodsInRegion(inv);
    }
}