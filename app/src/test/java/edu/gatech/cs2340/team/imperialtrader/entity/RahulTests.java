package edu.gatech.cs2340.team.imperialtrader.entity;

import edu.gatech.cs2340.team.imperialtrader.entity.Good;
import edu.gatech.cs2340.team.imperialtrader.entity.Inventory;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RahulTests {

    @Test
    public void inventory_addTest() {

        Inventory actualInventory = new Inventory(10);

        actualInventory.add(Good.NARCOTICS, 9);
        assertEquals(9, actualInventory.getCount(Good.NARCOTICS));

        actualInventory.add(Good.NARCOTICS, 1);
        assertEquals(10, actualInventory.getCount(Good.NARCOTICS));

        actualInventory.add(null, 2);
        assertEquals(10, actualInventory.getCount(Good.NARCOTICS));

        actualInventory.add(Good.FIREARMS, 7);
        assertEquals(0, actualInventory.getCount(Good.FIREARMS));
    }

    @Test
    public void inventory_removeTest() {

        Inventory actualInventory = new Inventory(25);
        actualInventory.add(Good.NARCOTICS, 15);
        actualInventory.add(Good.FIREARMS, 10);


        actualInventory.subtract(Good.NARCOTICS, 1);
        assertEquals(14, actualInventory.getCount(Good.NARCOTICS));

        actualInventory.subtract(Good.NARCOTICS, 4);
        assertEquals(10, actualInventory.getCount(Good.NARCOTICS));

        actualInventory.subtract(null, 1);
        assertEquals(10, actualInventory.getCount(Good.NARCOTICS));

        actualInventory.subtract(Good.NARCOTICS, 10);
        assertEquals(0, actualInventory.getCount(Good.NARCOTICS));

        actualInventory.subtract(Good.FIREARMS, 25);
        assertEquals(10, actualInventory.getCount(Good.FIREARMS));

    }
}