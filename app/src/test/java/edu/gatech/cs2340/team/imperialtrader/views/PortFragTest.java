package edu.gatech.cs2340.team.imperialtrader.views;

import org.junit.Test;

import edu.gatech.cs2340.team.imperialtrader.entity.Good;
import edu.gatech.cs2340.team.imperialtrader.entity.RadicalPriceEvent;
import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.entity.Resource;
import edu.gatech.cs2340.team.imperialtrader.entity.TechLevel;

import static org.junit.Assert.*;

public class PortFragTest {

    @Test
    public void priceCalc() {
        Region re = new Region("test", "test",
                0, 0, TechLevel.RENAISSANCE, Resource.DESERT);
        re.setCurEvent(RadicalPriceEvent.DROUGHT);
        int quan = 1000;
        Good type = Good.FIREARMS;
        int price = PortFrag.priceCalc(re, quan, type);
        assertEquals(1250, price); // check
        // base price when none of the conditions are met to change price

        re.setResource(Resource.WARLIKE);
        price = PortFrag.priceCalc(re, quan, type);
        assertEquals(875, price); // check
        // price drop when the region has abundant CR resource type.

        re.setResource(Resource.DESERT);
        re.setTechLevel(TechLevel.HITECH);
        price = PortFrag.priceCalc(re, quan, type);
        assertEquals(950, price); // check
        // price increase when the region's tech level is above MLTP Techlevel

        re.setTechLevel(TechLevel.RENAISSANCE);
        re.setCurEvent(RadicalPriceEvent.WAR);
        price = PortFrag.priceCalc(re, quan, type);
        assertEquals(2500, price); // check
        // price increase when the region's current
        // event matches the condition to make good more expensive

        re.setCurEvent(RadicalPriceEvent.DROUGHT);
        quan = 2000;
        price = PortFrag.priceCalc(re, quan, type);
        assertEquals(1201, price); // check
        // price decrease when the quantity is high

        quan = 967;
        price = PortFrag.priceCalc(re, quan, type);
        assertEquals(1662, price); // check
        // price increase when the quantity is low
    }

    @Test
    public void priceVarianceEnforce() {
        double priceToCheck = 0;
        double variance = Good.FIREARMS.getVar();
        int correctedPrice = 0;

        priceToCheck = 200000000;
        correctedPrice = PortFrag.priceVarianceEnforce(priceToCheck,
                variance, Good.FIREARMS.getBasePrice());
        assertEquals(2500, correctedPrice); // check
        // if price is capped when it's calculated to be too high

        priceToCheck = 1;
        correctedPrice = PortFrag.priceVarianceEnforce(priceToCheck,
                variance, Good.FIREARMS.getBasePrice());
        assertEquals(125, correctedPrice); // check
        // if price is capped when it's calculated to be too low

        variance = Good.FOOD.getVar();
        priceToCheck = 200000000;
        correctedPrice = PortFrag.priceVarianceEnforce(priceToCheck,
                variance, Good.FOOD.getBasePrice());
        assertEquals(105, correctedPrice); // check
        // if price is capped when it's calculated to be too high

        priceToCheck = 1;
        correctedPrice = PortFrag.priceVarianceEnforce(priceToCheck,
                variance, Good.FOOD.getBasePrice());
        assertEquals(95, correctedPrice); // check
        // if price is capped when it's calculated to be too low
    }
}