package tool;

/**
 * @author JesonLee
 * @date 2017/11/4.
 */
public class Check {
    public static boolean checkIfSorted(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfSortedDesc(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                return false;
            }
        }
        return true;
    }
}
