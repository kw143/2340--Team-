package edu.gatech.cs2340.team.imperialtrader.entity;

import java.util.HashMap;

import edu.gatech.cs2340.team.imperialtrader.entity.Good;

/**
 * Inventory class that holds the Player's goods
 */

public class Inventory {
    private final HashMap<Good, Integer> inventoryMap;

    /**
     * Getter for Inventory capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter for Inventory capacity
     * @param capacity capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter for current capacity
     * @return curCapacity
     */
    public int getCurCapacity() {
        return curCapacity;
    }

    /**
     * Setter for current capacity
     * @param curCapacity
     */
    public void setCurCapacity(int curCapacity) {
        this.curCapacity = curCapacity;
    }

    /**
     * Getter for Inventory size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Setter for Inventory size
     * @param size size of Inventory
     */
    public void setSize(int size) {
        this.size = size;
    }

    private int capacity;
    private int curCapacity;
    private int size;

    /**
     * Creates a new Inventory object with given capacity
     * @param capacity
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
        curCapacity = 0;
        size = 0;
        inventoryMap = new HashMap<>();
    }

    /**
     * Creates a new Inventory object with default capacity
     */
    public Inventory() {
        this(100);
    }

    /**
     * Getter for count of certain good in Inventory
     * @param good Good to get count for
     * @return count of a certain good in Inventory
     */
    public int getCount(Good good) {
        if (inventoryMap.containsKey(good)) {
            return inventoryMap.get(good);
        } else {
            return 0;
        }
    }

    /**
     * Method to return whether or not a certain amount of a Good is contained in Inventory
     * @param good good to find count for
     * @param count count to test for
     * @return boolean if there are greater than or equal to a certain amount of good
     */
    public boolean hasCount(Good good, int count) {
        return (inventoryMap.get(good) >= count);
    }

    /**
     * Method to determine if a good is contained in Inventory
     * @param good Good to find in Inventory
     * @return boolean t/f depending on if given good is in Inventory
     */
    public boolean hasGood(Good good) { return (inventoryMap.get(good) != null); }

    /**
     * Method to add goods to Inventory
     * @param good Good to add
     * @param count Amount of certain good to add
     * @return amount of a certain good added to Inventory
     */
    public int add(Good good, int count) {
        if ((count + curCapacity) <= capacity) {
            if (inventoryMap.get(good) != null) {
                inventoryMap.put(good, inventoryMap.get(good) + count);
                curCapacity += count;
                return count;
            }  else if (good == null) {
                return 0;
            } else {
                inventoryMap.put(good, count);
                curCapacity += count;
                size++;
                return count;
            }
        }
        return 0; // add failed

    }

    /**
     * Method to remove goods to Inventory
     * @param good Good to remove
     * @param count Amount of certain good to remove
     * @return amount of a certain good removed from Inventory
     */
    public int subtract(Good good, int count) {
        if (count < inventoryMap.get(good)) {
            inventoryMap.put(good, inventoryMap.get(good) - count);
            curCapacity -= count;
            return count;
        } else if (count == inventoryMap.get(good)) {
            inventoryMap.remove(good);
            curCapacity -= count;
            size--;
            return count;
        } else if (count >= inventoryMap.get(good)) {
            return 0;
        }
        return 0; // subtract failed
    }
}
