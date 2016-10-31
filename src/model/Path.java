package model;

/**
 * Created by mgunes on 26.10.2016.
 *
 * Yola ait bilgileri soyutlayan sınıf
 */
public class Path {
    private City adjacent;
    private int distance;

    public Path(City city, int distance) {
        adjacent = city;
        this.distance = distance;
    }

    public City getAdjacent() {
        return adjacent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
