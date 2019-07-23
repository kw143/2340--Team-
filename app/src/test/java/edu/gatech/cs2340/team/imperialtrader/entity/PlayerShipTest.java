package edu.gatech.cs2340.team.imperialtrader.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerShipTest {
    private PlayerShip ship;
    @Before
    public void setup(){
        ship = new PlayerShip("Gnat",0, 30, 75, 10, 14, 14, 2, 15);
    }

    @Test
    public void legalCost(){
        ship.setCost(10);
        Assert.assertEquals(10, ship.getCost());
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalCost(){
        ship.setCost(-1);
    }

    @Test
    public void legalSpeed(){
        ship.setSpeed(10);
        Assert.assertEquals(10, ship.getSpeed());
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalSpeed(){
        ship.setSpeed(0);
    }

}