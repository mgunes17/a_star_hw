package model;

/**
 * Created by mgunes on 26.10.2016.
 */
public class Path {
    private City adjacent;
    private int distance;

    public City getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(City adjacent) {
        this.adjacent = adjacent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
