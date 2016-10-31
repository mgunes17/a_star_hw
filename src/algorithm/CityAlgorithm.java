package algorithm;

import model.City;
import model.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by mgunes on 26.10.2016.
 *
 * Şehir koordinatlarının ve yollarının üretilmesi işlemleri
 * ve bunları ait kontrollerin yapılmasını içeren sınıf
 */
public class CityAlgorithm {
    private int cityCount;
    private List<City> map;

    public CityAlgorithm(int cityCount) {
        this.cityCount = cityCount;
        map = new ArrayList<>();
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
            x = r.nextInt(960) + 20; //pencere kenarında 20 pxlik boşluk bırakıldı
            y = r.nextInt(660) + 20;
        } while(!isPossible(x, y));

        city.setX_coor(x);
        city.setY_coor(y);
    }

    //5 birimlik çevrede 2 şehrin olmaması için yapılan kontrol
    public boolean isPossible(int x, int y) {
        int i = 0;
        boolean isExist = false;
        City city = new City(0);
        city.setX_coor(x);
        city.setY_coor(y);

        while(i < map.size() && !isExist) {
            if(eucledianDistance(map.get(i), city) < 50 )
                isExist  = true;
            i++;
        }

        if(isExist)
            return false;
        else
            return true;
    }

    //tüm şehirlerin birbirine uzaklığını gösteren matrisin hesaplanması
    public void evaluateDistances() {
        int distance;

        for(int i = 0; i < cityCount - 1; i++) {
            for(int j = i; j < cityCount; j++) {
                distance = eucledianDistance(map.get(i), map.get(j));
                City.distanceMatrix[i][j] = City.distanceMatrix[j][i] = distance;
            }
        }
    }

    //iki şehir arasındaki öklid uzaklığının hesaplanması
    public int eucledianDistance(City a, City b) {
        return (int) Math.sqrt(
                Math.pow((a.getX_coor() - b.getX_coor()),2) +
                Math.pow((a.getY_coor() - b.getY_coor()),2)
        );
    }

    //rastgele yollar üretilmesi
    public List<City> generateRandomPath(int pathCount) {
        Random r = new Random();
        int city1, city2;
        boolean adjacent;

        for(int i = 0; i < pathCount; i++) {

            //yol üretilecek 2 şehrin belirlenmesi
            do {
                city1 = r.nextInt(cityCount);
                city2 = r.nextInt(cityCount);

                adjacent = isAdjacent(map.get(city1) ,map.get(city2));
            } while(city1 == city2 || adjacent);

            int distance = City.distanceMatrix[city1][city2];
            map.get(city1).getPaths().add(new Path(map.get(city2), distance));
            map.get(city2).getPaths().add(new Path(map.get(city1), distance));
        }

        return map;
    }

    private boolean isAdjacent(City c1, City c2) {
        boolean adjacent = false;

        for(Path path: c1.getPaths()) {
            if(path.getAdjacent().getId() == c2.getId()) {
                adjacent = true;
            }
        }

        return adjacent;
    }

    public List<City> updatePaths() {
        for(City city: map) {
            city.findRealPath();
        }

        return map;
    }

    public void setMap(List<City> map) {
        this.map = map;
    }
}
