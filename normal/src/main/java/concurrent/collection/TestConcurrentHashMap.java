package concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lijs
 * on 2017/8/29.
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        map.put("st", 12314L);
        System.out.println();
    }
}
