package view;

import com.sun.deploy.panel.JavaPanel;
import model.City;
import model.Path;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mgunes on 26.10.2016.
 */
public class AppWindow extends JFrame {
    private List<City> cityList;
    private JPanel jp;
    JScrollPane scrollPane;

    public AppWindow(List<City> cityList) {
        super();
        setTitle("A Star");
        setSize(1280,960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.cityList = cityList;

        jp = new GPanel();
        add(jp);

    }

    class GPanel extends JPanel {
        public GPanel() {
            setPreferredSize(new Dimension(300, 300));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(City city: cityList) { //her bir şehir için
                g.setColor(Color.BLACK);
                g.drawOval(city.getX_coor(), city.getY_coor(), 5, 5);
                g.fillOval(city.getX_coor(), city.getY_coor(), 5, 5);

                for(Path path: city.getPaths()) {
                    g.drawLine(city.getX_coor(), city.getY_coor(),
                            path.getAdjacent().getX_coor(), path.getAdjacent().getY_coor()
                    );
                    g.drawString("" + city.getId(), city.getX_coor(), city.getY_coor());
                    g.drawString("" + path.getDistance(),
                            (city.getX_coor() + path.getAdjacent().getX_coor()) / 2,
                            (city.getY_coor() + path.getAdjacent().getY_coor()) / 2
                    );
                }
            }
            repaint();
        }
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
