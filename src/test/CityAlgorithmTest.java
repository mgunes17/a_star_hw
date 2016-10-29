package test;

import algorithm.CityAlgorithm;
import model.City;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mgunes on 26.10.2016.
 */
public class CityAlgorithmTest {
    @org.junit.Test
    public void eucledianDistance() throws Exception {
        City c1 = new City(0);
        c1.setX_coor(6);
        c1.setY_coor(13);

        City c2 = new City(1);
        c2.setX_coor(9);
        c2.setY_coor(9);

        assertEquals(5, new CityAlgorithm(2).eucledianDistance(c1, c2));
    }

    @org.junit.Test
    public void generateRandomPaths() throws Exception {
        CityAlgorithm cityAlgorithm = new CityAlgorithm(100);
        List<City> map = new ArrayList<City>();
        map = cityAlgorithm.createCities();
        map = cityAlgorithm.generateRandomPath(50);

        int totalPath = 0;

        for(City city: map) {
            totalPath += city.getPaths().size();
        }

        assertEquals(100, totalPath);
    }

    @org.junit.Test
    public void isPossible() {
        City city1 = new City(0);
        city1.setX_coor(10);
        city1.setY_coor(10);

        List<City> map = new ArrayList<>();
        map.add(city1);

        CityAlgorithm cityAlgorithm = new CityAlgorithm(1);
        cityAlgorithm.setMap(map);

        assertEquals(false, cityAlgorithm.isPossible(15, 15));
        assertEquals(true, cityAlgorithm.isPossible(20, 20));
    }

}