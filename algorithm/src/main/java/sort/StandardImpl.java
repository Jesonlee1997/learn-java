package sort;

import org.junit.Test;
import tool.Check;
import tool.TimeCounter;
import tool.random.RandomTool;

import java.util.Arrays;

/**
 * @author JesonLee
 * @date 2017/11/4.
 */
public class StandardImpl {
    @Test
    public void testSort() {
        int[] nums = RandomTool.getRandomArray(Integer.MAX_VALUE, 1000000);
        TimeCounter counter = TimeCounter.start();
        Arrays.sort(nums);
        counter.end();
        System.out.println("sorted:" + Check.checkIfSorted(nums));
    }
}
