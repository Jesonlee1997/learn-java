package designpattern.observer;

/**
 * Created by JesonLee
 * on 2017/5/10.
 */
public class MyObserver implements Observer {
    private String name;

    private String state;

    public MyObserver(String name) {
        this.name = name;
    }


    @Override
    public void update(String state) {
        this.state = state;
        System.out.println(name + "接到了状态改变的信息，新状态为"+state);
    }
}
