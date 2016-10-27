package view;

import model.City;
import model.Path;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mgunes on 26.10.2016.
 */
public class AppWindow extends JFrame {
    private List<City> cityList;

    public AppWindow(List<City> cityList) {
        setTitle("A Star");
        setSize(960,960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.cityList = cityList;
    }

    public void paint(Graphics g) {
        for(City city: cityList) { //her bir şehir için
            g.drawOval(city.getX_coor(), city.getY_coor(), 5, 5);
            g.fillOval(city.getX_coor(), city.getY_coor(), 5, 5);
            g.setColor(Color.GREEN);

            for(Path path: city.getPaths()) {
                g.drawLine(city.getX_coor(), city.getY_coor(),
                        path.getAdjacent().getX_coor(), path.getAdjacent().getY_coor()
                );
            }

            repaint();
        }
    }

}
