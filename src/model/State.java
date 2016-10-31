package model;

/**
 * Created by mgunes on 29.10.2016.
 *
 * Arama yaparken o an bulunduğumuz şehir ve uzaklık bilgilerini tutmak amacıyla
 * kullanılan sınıf. Teorik olarak her şehir birden fazla state de bulunabilir
 */
public class State implements Comparable<State> {
    private final City city;
    private int currentCost; //g(n) ' e karşılık gelen değişken
    private int beelineCost; //h(n) ' e karşılık gelen değişken
    private int estimatedCost; // f(n) ' e karşılık gelen değişken
    private State previousState; //yolu bulmak için bir önceki state tutuluyor

    public State(City city) {
        this.city = city;
    }

    public int compareTo(State compareState) {
        int compareCost = compareState.getEstimatedCost();
        return this.estimatedCost - compareCost;
    }

    //getter-setter
    public City getCity() {
        return city;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
        setEstimatedCost();
    }

    public void setBeelineCost(int beelineCost) {
        this.beelineCost = beelineCost;
        setEstimatedCost();
    }

    public int getEstimatedCost() {
        return estimatedCost;
    }

    private void setEstimatedCost() {
        estimatedCost = beelineCost + currentCost;
    }

    public State getPreviousState() {
        return previousState;
    }

    public void setPreviousState(State previousState) {
        this.previousState = previousState;
    }
}
