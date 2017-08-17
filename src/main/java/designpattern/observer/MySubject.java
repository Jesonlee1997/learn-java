package designpattern.observer;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public class MySubject extends Subject {
    private String state;

    public void changeState(String state) {
        System.out.println("状态由" + this.state + "变为" + state);
        this.state = state;
        notifyObservers(state);
    }
}
