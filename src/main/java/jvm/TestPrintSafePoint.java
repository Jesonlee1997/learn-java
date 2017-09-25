package jvm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lijs
 * on 2017/9/2.
 */
public class TestPrintSafePoint {
    private static final Collection<Object> leak = new ArrayList<>();
    private static volatile Object sink;
    // Run with: -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDetails
    // Notice that all the stop the world pauses coincide with GC pauses
    public static void main(String[] args) {
        while(true) {
            try {
                leak.add(new byte[1024 * 1024]);

                sink = new byte[1024 * 1024];
            } catch(OutOfMemoryError e) {
                leak.clear();
            }
        }
    }
}
