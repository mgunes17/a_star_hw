package model;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mgunes on 30.10.2016.
 *
 * Çalışma bilgilerini saklamak amacıyla oluşturulmuş sınıf.
 * En sonda ekrana basılan bilgileri içerir
 */
public class ExecutionInfo {
    private long aStarExecutionTime;
    private int totalPolledSize;
    private int maxQueueSize;
    private Queue remainQueue;
    private State targetState;

    public ExecutionInfo() {
        remainQueue = new PriorityQueue<State>();
    }

    public long getaStarExecutionTime() {
        return aStarExecutionTime;
    }

    public void setaStarExecutionTime(long aStarExecutionTime) {
        this.aStarExecutionTime = aStarExecutionTime;
    }

    public int getTotalPolledSize() {
        return totalPolledSize;
    }

    public void setTotalPolledSize(int totalPolledSize) {
        this.totalPolledSize = totalPolledSize;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public void setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public Queue getRemainQueue() {
        return remainQueue;
    }

    public void setRemainQueue(Queue remainQueue) {
        this.remainQueue = remainQueue;
    }

    public State getTargetState() {
        return targetState;
    }

    public void setTargetState(State targetState) {
        this.targetState = targetState;
    }
}
