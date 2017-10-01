package stream;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by lijs
 * on 2017/9/12.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1, null, 3, 4, null, 6);
        Stream<Integer> stream = numbers.stream().filter(num -> num != null);
        System.out.println();
    }
}
