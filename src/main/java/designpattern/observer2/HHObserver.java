package designpattern.observer2;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public class HHObserver implements Observer {

    @Override
    public void handleWakeUp(WakeUpEvent event) {
        System.out.println("hoho");
    }
}
