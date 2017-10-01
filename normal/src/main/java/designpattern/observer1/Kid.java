package designpattern.observer1;

/**
 * 事件源
 * Created by JesonLee
 * on 2017/5/10.
 */
public class Kid {
    private boolean sleeping = true;

    public Observer observer;

    public void wakeUp() {
        observer.handleWakeUp();
    }

}
