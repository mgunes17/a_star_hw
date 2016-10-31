package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgunes on 26.10.2016.
 *
 * Şehir bilgilerini soyutlayan sınıf
 */
public class City {
    public static int distanceMatrix[][] = new int[100][100]; //öklid distance ları tutan matris
    private final int id; //her şehrin unique bir id si var
    private int x_coor;
    private int y_coor;
    private List<Path> paths; //her şehrin sahip olduğu yollarla ilgili bilgiyi tutan liste

    public City(int id) {
        this.id = id;
        paths = new ArrayList<>();
    }

    //tüm yollara %20 ekleme yapar
    public void findRealPath() {
        int distance ;

        for(Path path: paths) {
            //yol uzunlukları %20 artırıldı
            distance = path.getDistance() + (path.getDistance() * (2)) / 10;
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

}
