package sort;

/**
 * @author JesonLee
 * @date 2017/11/7.
 */
public class BinarySearch {
    public static int search(int[] nums, int p) {
        return search(nums, p, 0, nums.length - 1);
    }

    public static int search(int[] nums, int p, int start, int end) {
        if (end < start) {
            throw new RuntimeException("End must bigger than start！ start:" + start + " end:" + end);
        }
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
        int[] nums = new int[]{1, 4, 5, 12, 435, 4441};
        System.out.println(search(nums, 4441));
    }
}
