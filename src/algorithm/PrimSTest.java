package algorithm;

import model.City;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mgunes on 27.10.2016.
 */
public class PrimSTest {
    @org.junit.Test
    public void mstTest() {
        CityAlgorithm cityAlgorithm = new CityAlgorithm(100);
        List<City> map = new ArrayList<City>();
        map = cityAlgorithm.createCities();

        cityAlgorithm.evaluateDistances();

        PrimS prim = new PrimS(map);
        prim.minimumSpanningTree();

        int totalPath = 0;

        for(City city: map) {
            totalPath += city.getPaths().size();
        }

        assertEquals(198, totalPath);
    }

}