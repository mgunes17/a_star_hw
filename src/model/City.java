package model;

import algorithm.CityAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mgunes on 26.10.2016.
 */
public class City {
    public static int distanceMatrix[][] = new int[100][100];
    private final int id;
    private int x_coor;
    private int y_coor;
    private List<Path> paths;

    public City(int id) {
        this.id = id;
        paths = new ArrayList<Path>();
    }

    //tüm yollara %10 %50 aralığında ekleme yapar
    public void findRealPath() {
        Random r = new Random();
        int distance = 0;

        for(Path path: paths) {
            distance = path.getDistance() + (path.getDistance() * (r.nextInt(5) + 1)) / 10;
            path.setDistance(distance);
        }
    }

    //getter-setter
    public int getId() {
        return id;
    }

    public int getX_coor() {
        return x_coor;
    }

    public void setX_coor(int x_coor) {
        this.x_coor = x_coor;
    }

    public int getY_coor() {
        return y_coor;
    }

    public void setY_coor(int y_coor) {
        this.y_coor = y_coor;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

}
