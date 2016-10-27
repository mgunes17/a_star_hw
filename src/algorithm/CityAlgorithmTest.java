package algorithm;

import model.City;

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

}