package algorithm;

import model.City;
import model.ExecutionInfo;
import model.Path;
import model.State;

import java.util.*;

/**
 * Created by mgunes on 26.10.2016.
 *
 * A star algoritmasının gerçeklendiği sınıf
 */
public class AStar {
    private PriorityQueue<State> stateQueue; //A* 'daki kuyruk yapısının işlevini görecek
    private int polledCount = 0;
    private List<City> cityList;
    private int startId;
    private int targetId;
    private List<City> visitedCity;

    public AStar(List<City> cityList, int startId, int targetId) {
        this.cityList = cityList;
        stateQueue = new PriorityQueue<State>(new StateComparator());
        visitedCity = new ArrayList<>();
        this.startId = startId;
        this.targetId = targetId;
    }

    public ExecutionInfo algorithm() {
        long startMillis = System.nanoTime();

        State currentState;
        State targetState = null;
        boolean found = false;
        int maxQueueSize = 0;

        State startState = new State(cityList.get(startId));
        startState.setCurrentCost(0);
        startState.setBeelineCost(City.distanceMatrix[startId][targetId]);
        stateQueue.offer(startState);

        while(stateQueue.size() != 0 && !found) {
            currentState = stateQueue.poll();
            visitedCity.add(currentState.getCity());
            polledCount++;

            if(targetId == currentState.getCity().getId()) {
                found = true;
                targetState = currentState;
            } else {
                for(Path path: currentState.getCity().getPaths()) {
                    if(!isExist(path.getAdjacent())) {
                        State state = new State(path.getAdjacent());
                        state.setCurrentCost(currentState.getCurrentCost() + path.getDistance());
                        state.setBeelineCost(City.distanceMatrix[currentState.getCity().getId()][path.getAdjacent().getId()]);
                        stateQueue.offer(state);
                        state.setPreviousState(currentState);
                    }
                }

                if(stateQueue.size() > maxQueueSize) {
                    maxQueueSize = stateQueue.size();
                }

                stateQueue.comparator();
            }

        }

        long finishMillis = System.nanoTime();

        ExecutionInfo executionInfo = new ExecutionInfo();
        executionInfo.setaStarExecutionTime(finishMillis - startMillis);
        executionInfo.setTotalPolledSize(polledCount);
        executionInfo.setMaxQueueSize(maxQueueSize);
        executionInfo.setTargetState(targetState);

        return executionInfo;
    }

    //aynı state in tekrar ele alınmaması için yapılan kontrol
    private boolean isExist(City c1) {
        boolean exist = false;

        for(City c2: visitedCity) {
            if(c1.getId() == c2.getId())
                exist  = true;
        }

        return exist;
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
