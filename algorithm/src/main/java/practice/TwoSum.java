package practice;

import sort.BinarySearch;

/**
 * 找出和为零的整数对的数量
 * @author JesonLee
 * @date 2017/11/2.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-8, -6, -3, -1, 1, 3, 6, 8};
        System.out.println(twoSum(nums));
    }

    public static int twoSum(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int k = nums[i];
            if (BinarySearch.search(nums, -k, i + 1, nums.length - 1) != -1) {
                count++;
            }
        }
        return count;
    }
}
