package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("Attached a observer");
    }

    public void disattach(Observer observer) {
        observers.remove(observer);
    }


    public void notifyObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
