package designpattern.observer;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public class TestMain {
    public static void main(String[] args) {
        MySubject subject = new MySubject();
        Observer observer1 = new MyObserver("observer1");
        subject.attach(observer1);

        Observer observer2 = new MyObserver("observer2");
        subject.attach(observer2);

        subject.changeState("newstate");

    }
}
