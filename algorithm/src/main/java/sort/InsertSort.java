package sort;

import tool.Check;
import tool.TimeCounter;
import tool.random.RandomTool;

/**
 * 插入排序
 * 初始化：左边已排好序的数组个数为0
 * 保持：左边是已经排好序的数组，右边未参加排序
 * 终止：最后一个数排完序后整个数组有序
 *
 * @author JesonLee
 * @date 2017/11/4.
 */
public class InsertSort {
    private static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > data) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = data;
        }
    }

    public static void main(String[] args) {
        int[] nums = RandomTool.getRandomArray(Integer.MAX_VALUE, 100000);
        TimeCounter counter = TimeCounter.start();
        insertSort(nums);
        counter.end();
        System.out.println("sorted:" + Check.checkIfSorted(nums));
    }
}
