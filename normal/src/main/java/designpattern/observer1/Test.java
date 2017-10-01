package designpattern.observer1;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public class Test {
    public static void main(String[] args) {
        Kid kid = new Kid();
        kid.observer = new HHObserver();
        kid.wakeUp();
    }
}
