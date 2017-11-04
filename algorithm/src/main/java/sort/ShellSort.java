package sort;

import tool.Check;
import tool.random.RandomTool;
import tool.TimeCounter;

/**
 * @author JesonLee
 * @date 2017/11/4.
 */
public class ShellSort {
    private static void shellSort(int[] nums) {
        int n = nums.length;
        while (n > 1) {
            n = n / 3 + 1;
            for (int i = 0; i < nums.length; i++) {
                int data = nums[i];
                int j = i - n;
                for (; j >= 0; j -= n) {
                    if (nums[j] > data) {
                        nums[j + n] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j + n] = data;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = RandomTool.getRandomArray(Integer.MAX_VALUE, 1000000);
        TimeCounter counter = TimeCounter.start();
        shellSort(nums);
        counter.end();
        System.out.println("sorted:" + Check.checkIfSorted(nums));
    }
}
