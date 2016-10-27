package algorithm;

import model.City;
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
        CityAlgorithm cityAlgorithm = new CityAlgorithm(100);

        List<City> map = new ArrayList<City>();
        map = cityAlgorithm.createCities();

        cityAlgorithm.evaluateDistances();

        PrimS prim = new PrimS(map);
        prim.minimumSpanningTree();

        AppWindow appWindow = new AppWindow(map);
        //appWindow.paint(null);

        for(City city: map) {
            appWindow.paint(null);
        }

        //to-do
        /*
            ekrana sol panel yap
            her yeni görüntü için button olsun
            uygulamaya ait genel bilgileri orda yazdır
            mst yi çalıştır
            50 tane de rastgele yol üret
            ekranda göster
         */
    }
}
