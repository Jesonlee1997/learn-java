package designpattern.observer1;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public class BeatObserver implements Observer {

    @Override
    public void handleWakeUp() {
        System.out.println("Beat");
    }
}
