package edu.gatech.cs2340.team.imperialtrader.views;

import org.junit.Test;

import edu.gatech.cs2340.team.imperialtrader.entity.Region;
import edu.gatech.cs2340.team.imperialtrader.entity.Resource;
import edu.gatech.cs2340.team.imperialtrader.entity.TechLevel;

import static org.junit.Assert.*;

public class MapFragTest {
    @Test
    public void distance_calc_correct1() {
        Region region1 = new Region("region1","home1",0,0,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        Region region2 = new Region("region2","home2",5,0,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        assertEquals(5, MapFrag.distanceCalc(region1, region2), 0);
    }
    @Test
    public void distance_calc_correct2() {
        Region region1 = new Region("region1","home1",0,0,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        Region region2 = new Region("region2","home2",3,4,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        assertEquals(5, MapFrag.distanceCalc(region1, region2), 0);
    }
    @Test
    public void distance_calc_correct3() {
        Region region1 = new Region("region1","home1",0,0,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        Region region2 = new Region("region2","home2",12,5,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        assertEquals(13, MapFrag.distanceCalc(region1, region2), 0);
    }
    @Test
    public void distance_calc_correct4() {
        Region region1 = new Region("region1","home1",0,0,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        Region region2 = new Region("region2","home2",0,0,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        assertEquals(0, MapFrag.distanceCalc(region1, region2), 0);
    }
    @Test
    public void distance_calc_correct5() {
        Region region1 = new Region("region1","home1",5,5,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        Region region2 = new Region("region2","home2",8,9,
                TechLevel.AGRIULTURE, Resource.MINERALPOOR);
        assertEquals(5, MapFrag.distanceCalc(region1, region2), 0);
    }
}