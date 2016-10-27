package algorithm;

import model.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.MatchResult;

import static java.lang.Math.sqrt;

/**
 * Created by mgunes on 26.10.2016.
 */
public class CityAlgorithm {
    private int cityCount;
    private List<City> map;

    public CityAlgorithm(int cityCount) {
        this.cityCount = cityCount;
        map = new ArrayList<City>();
    }

    public List<City> createCities() {

        for(int i = 0 ; i < cityCount; i++) {
            City city = new City(i);
            generateCoordinate(city);
            map.add(city);
        }

        return map;
    }

    public void generateCoordinate(City city) {
        int x;
        int y;
        Random r = new Random();

        do {
            x = r.nextInt(900);
            y = r.nextInt(900);
        } while(!isPossible(x, y));

        city.setX_coor(x);
        city.setY_coor(y);
    }

    public boolean isPossible(int x, int y) {
        return true;
    }

    public void evaluateDistances() {
        int distance;

        for(int i = 0; i < cityCount - 1; i++) {
            for(int j = i; j < cityCount; j++) {
                distance = eucledianDistance(map.get(i), map.get(j));
                City.distanceMatrix[i][j] = City.distanceMatrix[j][i] = distance;
            }
        }
    }

    public int eucledianDistance(City a, City b) {
        return (int) Math.sqrt(
                Math.pow((a.getX_coor() - b.getX_coor()),2) +
                Math.pow((a.getY_coor() - b.getY_coor()),2)
        );
    }
}
