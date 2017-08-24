package designpattern.singleton;

/**
 * Created by lijs
 * on 2017/8/23.
 */
public enum EasySingleton {
    INSTANCE {
        @Override
        public void doSomething() {
            System.out.println("do something");
        }
    };

    private int x;

    public int getX() {
        return x;
    }

    public abstract void doSomething();

    public static void main(String[] args) {
        INSTANCE.doSomething();
    }
}
