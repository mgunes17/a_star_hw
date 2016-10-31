package view;

import model.City;
import model.Path;
import model.State;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by mgunes on 26.10.2016.
 *
 * Görsel işlemlerin yapılmasını sağlayan sınıf
 */
public class AppWindow extends JFrame {
    private List<City> cityList;
    private JPanel jp;
    private boolean way = false;
    private boolean astar = false;
    private State target;
    private int targetCity = -1;
    private int startCity = -1;

    public AppWindow(List<City> cityList) {
        super();
        setTitle("A Star");
        setSize(1000,700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.cityList = cityList;

        jp = new GPanel();
        getContentPane().add(jp);
        setBackground(Color.PINK);

    }

    public void setWay(boolean way) {
        this.way = way;
    }

    private class GPanel extends JPanel {
        public GPanel() {
            setPreferredSize(new Dimension(1000, 700));
        }

        @Override
        public void paint(Graphics g) {
            g.clearRect(0, 0, 500, 500);

            for(City city: cityList) { //her bir şehir için
                g.setColor(Color.DARK_GRAY);
                g.drawOval(city.getX_coor(), city.getY_coor(), 5, 5);
                g.fillOval(city.getX_coor(), city.getY_coor(), 5, 5);

                for(Path path: city.getPaths()) {
                    g.setColor(Color.GRAY);
                    g.drawLine(city.getX_coor(), city.getY_coor(),
                            path.getAdjacent().getX_coor(), path.getAdjacent().getY_coor()
                    );
                    if(way) {
                        g.setColor(Color.BLUE);
                        g.drawString("" + city.getId(), city.getX_coor(), city.getY_coor());
                        g.setColor(Color.BLACK);
                        g.drawString("" + path.getDistance(),
                                (city.getX_coor() + path.getAdjacent().getX_coor()) / 2,
                                (city.getY_coor() + path.getAdjacent().getY_coor()) / 2
                        );
                    }

                }
            }

            if(astar) { //yol bulunduysa, renklendir
                State s  = target;

                while(s.getPreviousState() != null) {
                    g.setColor(Color.RED);
                    g.drawLine(s.getCity().getX_coor(), s.getCity().getY_coor(),
                            s.getPreviousState().getCity().getX_coor(), s.getPreviousState().getCity().getY_coor());

                    s = s.getPreviousState();
                }
            }
            if(startCity != -1 && targetCity != -1) { //başlangıç ve bitiş şehirleri belirlendiyse işaretle
                g.setColor(Color.BLUE);
                g.drawOval(cityList.get(startCity).getX_coor(), cityList.get(startCity).getY_coor(), 15 , 15);
                g.fillOval(cityList.get(startCity).getX_coor(), cityList.get(startCity).getY_coor(), 15 , 15);

                g.setColor(Color.CYAN);
                g.drawOval(cityList.get(targetCity).getX_coor(), cityList.get(targetCity).getY_coor(), 15 , 15);
                g.fillOval(cityList.get(targetCity).getX_coor(), cityList.get(targetCity).getY_coor(), 15 , 15);
            }
        }
    }

    public void setAstar(boolean astar) {
        this.astar = astar;
    }

    public void setTarget(State target) {
        this.target = target;
    }

    public void setTargetCity(int targetCity) {
        this.targetCity = targetCity;
    }

    public void setStartCity(int startCity) {
        this.startCity = startCity;
    }
}
