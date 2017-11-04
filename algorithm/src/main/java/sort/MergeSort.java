package sort;

import tool.Check;
import tool.TimeCounter;
import tool.random.RandomTool;

/**
 * 归并排序
 * 分：将数组分为两部分，将这两部分排好序
 * 治：将排好序的这两部分归并
 *
 * @author JesonLee
 * @date 2017/11/4.
 */
public class MergeSort {
    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int[] aux = new int[nums.length];
        mergeSort(nums, aux, 0, nums.length - 1);
    }

    //非递归的归并排序，自底向上
    private static void mergeSortNonRecursive(int[] nums) {
        int N = nums.length;
        int[] aux = new int[N];
        for (int sz = 1; sz < N; sz = sz + sz) { //sz 为子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) {//lo:子数组的索引
                merge(nums, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    //原地归并
    private static void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    private static void mergeSort(int[] nums, int[] aux, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(aux, nums, start, mid);
        mergeSort(aux, nums, mid + 1, end);
        merge(nums, aux, start, mid, end);
    }

    public static void main(String[] args) {
        int[] nums = RandomTool.getRandomArray(Integer.MAX_VALUE, 1000000);
        TimeCounter counter = TimeCounter.start();
        mergeSort(nums);
        counter.end();
        System.out.println("sorted:" + Check.checkIfSorted(nums));
    }
}
