package algorithm;

import model.City;
import model.Path;
import model.State;

import java.lang.ref.SoftReference;
import java.util.*;

/**
 * Created by mgunes on 26.10.2016.
 */
public class AStar {
    private PriorityQueue<State> stateQueue; //A* 'daki kuyruk yapısının işlevini görecek
    private int polledCount = 0;
    private List<City> cityList;
    private int startId;
    private int targetId;

    public AStar(List<City> cityList, int startId, int targetId) {
        this.cityList = cityList;
        stateQueue = new PriorityQueue<State>(new StateComparator());
        this.startId = startId;
        this.targetId = targetId;
    }

    public State algorithm() {
        State currentState;
        State targetState = null;
        boolean found = false;

        State startState = new State(cityList.get(startId));
        startState.setCurrentCost(0);
        startState.setBeelineCost(City.distanceMatrix[startId][targetId]);
        stateQueue.offer(startState);

        while(stateQueue.size() != 0 && found == false) {
            currentState = stateQueue.poll();
            polledCount++;

            if(targetId == currentState.getCity().getId()) {
                found = true;
                targetState = currentState;
            }

            for(Path path: currentState.getCity().getPaths()) {
                if(!stateQueue.contains(path.getAdjacent())) {
                    State state = new State(path.getAdjacent());
                    state.setCurrentCost(currentState.getCurrentCost() + path.getDistance());
                    state.setBeelineCost(City.distanceMatrix[currentState.getCity().getId()][path.getAdjacent().getId()]);
                    stateQueue.offer(state);
                    state.setPreviousState(currentState);
                }
            }

            stateQueue.comparator();
        }
        return targetState;
    }

    public static class StateComparator implements Comparator<State> {
        public int compare(State s1, State s2) {
            return s1.compareTo(s2);
        }
    }

    public int getPolledCount() {
        return polledCount;
    }
}
