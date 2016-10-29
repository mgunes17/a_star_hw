package algorithm;

import model.City;
import model.State;
import view.AppWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgunes on 26.10.2016.
 *
 * Ana Akışın Yönetilmesinden Sorumlu Sınıf
 */
public class App extends JFrame {

    public static void main(String args[]) {
        CityAlgorithm cityAlgorithm = new CityAlgorithm(10);

        List<City> map = new ArrayList<City>();
        map = cityAlgorithm.createCities();

        cityAlgorithm.evaluateDistances();

        PrimS prim = new PrimS(map);
        prim.minimumSpanningTree();

        AppWindow appWindow = new AppWindow(map);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        map = cityAlgorithm.generateRandomPath(2);

        //yollara %10-%50 aralığında ekleme yap
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        map = cityAlgorithm.updatePaths();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AStar astar = new AStar(map, 2, 5);
        State state = astar.algorithm();
        System.out.println(astar.getPolledCount());

    }
}
