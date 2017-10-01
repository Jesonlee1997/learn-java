package designpattern.reactor;

import java.io.IOException;

/**
 * Created by JesonLee
 * on 2017/5/11.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor();
        new Handler(reactor.selector);
        reactor.run();
    }
}
