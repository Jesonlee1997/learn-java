package practice;

import java.util.Arrays;

/**
 * 找出和为零的整数对的数量
 * @author JesonLee
 * @date 2017/11/2.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int k = nums[i];
            int j;
            if ((j = search(nums,target -k, i + 1, nums.length - 1)) != -1) {
                return new int[]{i, j};
            }
        }
        return new int[0];
    }

    private int search(int[] nums, int p, int start, int end) {
        int lo = start;
        int hi = end;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == p) {
                return mid;
            } else if (nums[mid] > p) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{0, 4, 3, 0}, 0)));
    }
}
