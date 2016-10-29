package test;

import model.City;
import model.State;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;


/**
 * Created by mgunes on 29.10.2016.
 */
public class AStar {

    @org.junit.Test
    public void comparatorState() {
        State s0 = new State(new City(0));
        s0.setBeelineCost(30);
        s0.setCurrentCost(20);

        State s1 = new State(new City(1));
        s1.setBeelineCost(10);
        s1.setCurrentCost(20);

        State s2 = new State(new City(2));
        s2.setBeelineCost(10);
        s2.setCurrentCost(30);

        State s3 = new State(new City(3));
        s3.setBeelineCost(10);
        s3.setCurrentCost(0);

        State s4 = new State(new City(4));
        s4.setBeelineCost(10);
        s4.setCurrentCost(10);

        PriorityQueue<State> stateQueue = new PriorityQueue<State>(new algorithm.AStar.StateComparator());
        stateQueue.offer(s0);
        stateQueue.offer(s1);
        stateQueue.offer(s2);
        stateQueue.offer(s3);
        stateQueue.offer(s4);

        stateQueue.comparator();

        assertEquals(10, stateQueue.poll().getEstimatedCost());
        assertEquals(20, stateQueue.poll().getEstimatedCost());
        assertEquals(30, stateQueue.poll().getEstimatedCost());
        assertEquals(40, stateQueue.poll().getEstimatedCost());
        assertEquals(50, stateQueue.poll().getEstimatedCost());
    }
}
