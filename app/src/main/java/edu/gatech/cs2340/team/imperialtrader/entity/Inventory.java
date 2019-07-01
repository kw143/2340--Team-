package edu.gatech.cs2340.team.imperialtrader.entity;

import java.util.HashMap;

import edu.gatech.cs2340.team.imperialtrader.entity.Good;

public class Inventory {
    HashMap<Good, Integer> inventoryMap;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurCapacity() {
        return curCapacity;
    }

    public void setCurCapacity(int curCapacity) {
        this.curCapacity = curCapacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int capacity;
    private int curCapacity;
    private int size;

    public Inventory(int capacity) {
        this.capacity = capacity;
        curCapacity = 0;
        size = 0;
        inventoryMap = new HashMap<>();
    }

    public Inventory() {
        this(100);
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

    public boolean hasGood(Good good) {
        return (inventoryMap.get(good) != null);
    }

    public int add(Good good, int count) {
        if (count + curCapacity < capacity) {
            if (inventoryMap.get(good) != null) {
                inventoryMap.put(good, inventoryMap.get(good) + count);
                return count;
            } else {
                inventoryMap.put(good, count);
                size++;
                return count;
            }
        }
        return 0; // add failed

    }

    public int subtract(Good good, int count) {
        if (count < inventoryMap.get(good)) {
            inventoryMap.put(good, inventoryMap.get(good) - count);
            return count;
        } else if (count == inventoryMap.get(good)) {
            inventoryMap.remove(good);
            size--;
            return count;
        } else if (count >= inventoryMap.get(good)) {
            return 0;
        }
        return 0; // subtract failed
    }
}
