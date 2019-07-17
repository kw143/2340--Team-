package edu.gatech.cs2340.team.imperialtrader.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void get_count_test1() {
        Inventory inventory = new Inventory(50);
        inventory.add(Good.FIREARMS, 5);
        assertEquals(5, inventory.getCount(Good.FIREARMS));
    }
    @Test
    public void get_count_test2() {
        Inventory inventory = new Inventory(50);
        assertEquals(0, inventory.getCount(Good.FIREARMS));
    }
    @Test
    public void get_count_test3() {
        Inventory inventory = new Inventory(50);
        inventory.add(Good.FIREARMS, 5);
        assertEquals(0, inventory.getCount(Good.FOOD));
    }
    @Test
    public void get_count_test4() {
        Inventory inventory = new Inventory(50);
        inventory.add(Good.FIREARMS, 0);
        assertEquals(0, inventory.getCount(Good.FIREARMS));
    }
}