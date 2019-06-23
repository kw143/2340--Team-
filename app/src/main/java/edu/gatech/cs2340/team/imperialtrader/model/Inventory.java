package edu.gatech.cs2340.team.imperialtrader.model;

import java.util.HashMap;

public class Inventory {
    HashMap<Good, Integer> inventoryMap;
    private int capacity;
    private int size;
    public Inventory(int capacity) {
        this.capacity = capacity;
        size = 0;
        inventoryMap = new HashMap<>();
    }

    public Inventory() {
        //PlayerInteractor interactor = new PlayerInteractor();
        //TODO idk how the contructor works lol
        //this(interactor.getPlayer().getShip().getCargoCap());
        //TODO this depends on ship being implemented
    }

    public int getCount(Good good) {
        try {
            return inventoryMap.get(good);
        } catch (Exception e) {
            return 0;
        }
    }
    public boolean hasCount(Good good, int count) {
        if (inventoryMap.get(good) >= count) {
            return true;
        } else {
            return false;
        }

    }
    public void add(Good good, int count) {
        if (count + size < capacity) {
            if (inventoryMap.get(good) != null) {
                inventoryMap.put(good, inventoryMap.get(good) + count);
            } else if (count < capacity){
                inventoryMap.put(good, count);
            } else {
                //TODO something idk what
            }

        }
    }
    public int subtract(Good good, int count) {
        if (count <= inventoryMap.get(good)) {
            inventoryMap.put(good, inventoryMap.get(good) - count);
            return count;
        } else if (count >= inventoryMap.get(good)){
            return 0;
        }
        return 0;
    }
}
