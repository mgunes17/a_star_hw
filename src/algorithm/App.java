package algorithm;

import model.City;
import model.ExecutionInfo;
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
    private int cityCount;
    private int randomPathCount;
    private int startCity;
    private int targetCity;

    public static void main(String args[]) {
        App app = new App();
        app.cityCount = app.readInput("Şehir sayısını giriniz:");
        app.randomPathCount = app.readInput("Rastgele oluşturmak istediğiniz yol sayısını giriniz:");

        CityAlgorithm cityAlgorithm = new CityAlgorithm(app.cityCount);

        List<City> map = new ArrayList<>();
        map = cityAlgorithm.createCities();

        cityAlgorithm.evaluateDistances();

        PrimS prim = new PrimS(map);
        prim.minimumSpanningTree();

        AppWindow appWindow = new AppWindow(map);

        JOptionPane.showMessageDialog(null, "Mininmum Spannig Tree Oluşturuldu");

        appWindow.repaint();

        map = cityAlgorithm.generateRandomPath(app.randomPathCount);
        JOptionPane.showMessageDialog(null, "Random yollar eklendi");
        appWindow.repaint();

        //yollara %10-%50 aralığında ekleme yap

        map = cityAlgorithm.updatePaths();
        JOptionPane.showMessageDialog(null, "Yolların gerçek uzunlukları hesaplandı");

        appWindow.setWay(true);
        appWindow.repaint();

        app.startCity = app.readInput("Başlangıç şehrinin id sini giriniz:");
        app.targetCity = app.readInput("Hedef şehrin id sini giriniz:");

        appWindow.setStartCity(app.startCity);
        appWindow.setTargetCity(app.targetCity);
        appWindow.repaint();

        AStar astar = new AStar(map, app.startCity, app.targetCity);
        ExecutionInfo executionInfo =  astar.algorithm();

        appWindow.setTarget(executionInfo.getTargetState());
        appWindow.setAstar(true);
        appWindow.repaint();

        app.lastMessage(executionInfo);
    }

    public void lastMessage(ExecutionInfo executionInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Toplam Çalışma Süresi:");
        stringBuilder.append(executionInfo.getaStarExecutionTime() / 1000000.0 + " milisaniye\n");
        stringBuilder.append("Kuyruktan çekilen toplam eleman sayısı:");
        stringBuilder.append(executionInfo.getTotalPolledSize() + "\n");
        stringBuilder.append("Kuyruğun ulaştığı maximum boyut:");
        stringBuilder.append(executionInfo.getMaxQueueSize() + "\n");

        JOptionPane.showMessageDialog(null, stringBuilder.toString());
    }

    public int readInput(String message){
        boolean read;
        int inputNumber = 0;

        do {
            try {
                String input = JOptionPane.showInputDialog(message);
                inputNumber = Integer.parseInt(input);

                if(inputNumber < 0 && inputNumber > 99) {
                    JOptionPane.showMessageDialog(null, "Lütfen 0-99 aralığında giriş yapınız");
                    read = false;
                } else {
                    read = true;
                }

            } catch(Exception e) {
                read = false;
            }
        } while(!read);

        return inputNumber;
    }
}
