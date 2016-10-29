package test;

import model.City;
import model.Path;

import static org.junit.Assert.*;

/**
 * Created by mgunes on 29.10.2016.
 */
public class CityTest {

    @org.junit.Test
    public void findRealPathsTest() {
        City city = new City(0);
        Path path = new Path(new City(1), 10);
        Path path2 = new Path(new City(2), 20);
        city.getPaths().add(path);
        city.getPaths().add(path2);
        city.findRealPath();

        boolean b1 = city.getPaths().get(0).getDistance() > 10;
        boolean b2 = city.getPaths().get(0).getDistance() < 16;
        boolean b3 = city.getPaths().get(1).getDistance() < 31;
        boolean b4 = city.getPaths().get(1).getDistance() > 20;

        assertEquals(true, b1);
        assertEquals(true, b2);
        assertEquals(true, b3);
        assertEquals(true, b4);
    }
}
