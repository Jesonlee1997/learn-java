package sort;

import tool.Check;
import tool.TimeCounter;
import tool.random.RandomTool;

/**
 * @author JesonLee
 * @date 2017/11/4.
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = partition(nums, lo, hi);
        quickSort(nums, lo, mid - 1);
        quickSort(nums, mid + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int base = nums[chooseBaseIndex(nums, lo, hi)];
        int result = lo;//表示基准点最终的下标
        for (int i = lo; i <= hi; i++) {
            if (nums[i] < base) {
                nums[result++] = nums[i];
                nums[i] = nums[result];
            }
        }
        nums[result] = base;
        return result;
    }

    private static int chooseBaseIndex(int[] nums, int lo, int hi) {
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = RandomTool.getRandomArray(Integer.MAX_VALUE, 1000000);
        TimeCounter counter = TimeCounter.start();
        quickSort(nums);
        counter.end();
        System.out.println("sorted:" + Check.checkIfSorted(nums));
    }
}
