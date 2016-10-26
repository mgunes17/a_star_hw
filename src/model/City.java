package model;

import java.util.List;

/**
 * Created by mgunes on 26.10.2016.
 */
public class City {
    private final int id;
    private int x_coor;
    private int y_coor;
    private List<Path> paths;

    public City(int id) {
        this.id = id;
    }

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
