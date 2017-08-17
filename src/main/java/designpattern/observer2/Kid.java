package designpattern.observer2;

import java.util.List;

/**
 * 事件源
 * Created by JesonLee
 * on 2017/5/10.
 */
public class Kid {
    private boolean sleeping = true;

    public List<Observer> observers;

    public void wakeUp() {
        //
        WakeUpEvent event = new WakeUpEvent(8, this);
        for (Observer observer : observers) {
            observer.handleWakeUp(event);
        }
    }

}
