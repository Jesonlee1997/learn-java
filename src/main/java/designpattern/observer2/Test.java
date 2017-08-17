package designpattern.observer2;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public class Test {
    public static void main(String[] args) {
        Kid kid = new Kid();
        kid.observers.add(new HHObserver());
        kid.wakeUp();
    }
}
