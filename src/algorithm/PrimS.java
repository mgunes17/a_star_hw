package algorithm;

import model.City;
import model.Path;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgunes on 26.10.2016.
 */
public class PrimS {
    //tree ye eklenen şehirler
    private List<City> cityInGraph;
    private List<City> cityList;

    public PrimS(List<City> cityList) {
        super();
        cityInGraph = new ArrayList<City>();
        this.cityList = cityList;
    }

    public void minimumSpanningTree() {
        // Başlangıç noktası 0 id li şehir
        int index = 0;
        int minPath = 9999;
        cityInGraph.add(cityList.get(0));
        int adj1 = -1;
        int adj2 = -1;

        while(cityInGraph.size() != cityList.size()) { //tüm şehirlerden birbirine yol olabilir
            for(City city: cityInGraph) { //MST' deki herbir şehrin tüm komşularına bakılacak
                for(int i = 0; i < cityList.size(); i++) {
                    if(!cityInGraph.contains(cityList.get(i)) && City.distanceMatrix[city.getId()][i] < minPath &&
                            City.distanceMatrix[city.getId()][i] != 0) {
                        minPath = City.distanceMatrix[city.getId()][i];
                        adj1 = city.getId();
                        adj2 = cityList.get(i).getId();

                    }
                }
            }
            cityInGraph.add(cityList.get(adj2)); //bulunan şehir MST ' ye eklendi
            cityList.get(adj1).getPaths().add(new Path(cityList.get(adj2), minPath));
            cityList.get(adj2).getPaths().add(new Path(cityList.get(adj1), minPath));
            minPath = 9999;
        }
    }

    /*

        min bul fonksiyonu olacak,
        cityInGraph taki listede olan şehirler arasında komşusu en küçük olan ve listede olmayan şehri bulup listeye
        ekleyeceğiz ta ki bulunamayana kadar

        burda şehirlerin pathlerine eklenecek
     */

}
