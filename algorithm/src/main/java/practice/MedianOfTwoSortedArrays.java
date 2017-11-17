package practice;

/**
 * //TODO
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @author lijs
 * @date 17-11-12.
 */
public class MedianOfTwoSortedArrays {
    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int midian = 0;

            int[] longArray, shortArray;
            if (nums1.length > nums2.length) {
                longArray = nums1;
                shortArray = nums2;
            } else {
                longArray = nums2;
                shortArray = nums1;
            }

            int lo1 = 0;
            int hi1 = nums1.length - 1;
            int mid1left = (lo1 + hi1) / 2;
            int mid1right = (lo1 + hi1 + 1) / 2;

            int lo2 = 0;
            int hi2 = nums2.length - 1;
            int mid2left = (lo2 + hi2) / 2;
            int mid2right = (lo2 + hi2 + 1) / 2;

            if (nums1[hi1] < nums2[lo2] || nums2[hi2] < nums1[lo1]) {
                int length = nums1.length + nums2.length;
                if (nums1.length == nums2.length) {
                    if (nums1[hi1] < nums2[lo2]) {
                        midian = (nums1[hi1] + nums2[lo2]) / 2;
                    } else {
                        midian = (nums1[lo1] + nums2[hi2]) / 2;
                    }
                } else if (nums1.length < nums2.length) {
                    midian = (nums2[length / 2 - nums1.length] + nums2[(length - 1) / 2 - nums1.length]) / 2;
                } else {
                    midian = (nums1[length / 2 - nums2.length] + nums1[(length - 1) / 2 - nums2.length]) / 2;
                }
            } else {
                while (true) {
                    if (nums1[mid1left] <= nums2[mid2right]) {
                        if (nums1[mid1right] >= nums2[mid2left]) {
                            //正确出口
                            //找出这四个数中的中位数
                            //midian =
                            break;
                        } else {
                            //nums2左移 num1右移
                            lo1 = mid1right;
                            hi2 = mid1left;
                        }
                    } else {
                        //num1左移 nums2右移
                        hi1 = mid1left;
                        lo2 = mid1right;
                    }
                    mid1left = (lo1 + hi1) / 2;
                    mid1right = (lo1 + hi1 + 1) / 2;

                    mid2left = (lo2 + hi2) / 2;
                    mid2right = (lo2 + hi2 + 1) / 2;
                }
            }
            return 0.0;
        }
    }
}
