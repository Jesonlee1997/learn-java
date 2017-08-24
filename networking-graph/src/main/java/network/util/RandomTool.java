package network.util;

import java.util.*;

/**
 * Created by lijs
 * on 2017/8/21.
 */
public class RandomTool {
    private static final Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }

    /**
     * 获得指定区间的一个随机数
     * @param start 下限（包含）
     * @param end 上限（包含）
     * @return 随机值
     */
    public static int getRandomOf(int start, int end) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("start or end must >= 0");
        }

        if (start > end) {
            throw new IllegalArgumentException("start must >= end");
        }

        if (start == end) {
            return start;
        }

        return start + nextInt(end - start);
    }

    /**
     * 获得指定范围内的一串随机数，这串随机数相互不同
     *
     * @param start 最小值
     * @param end    最大值
     * @return 数组
     */
    static int[] getUnrepeateRandoms(int start, int end) {
        int[] res = new int[end - start + 1];

        int idx = 0;
        for (int i = start; i <= end; i++) {
            res[idx++] = i;
        }
        shuffle(res);
        return res;
    }

    /**
     * 获得一个随机数数组，大小为size，元素值范围为（0-bound)
     * @param bound 最大值（不包含）
     * @param size 随机数数组
     * @return 随机数数组
     */
    public static int[] getRandomArray(int bound, int size) {
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = nextInt(bound);
        }
        return res;
    }

    /**
     * 从已有的数组中随机取出一组数，这会打乱原有的数组
     * @param arr 已有的随机数数组
     * @param count 需要从该数组中取出的随机数个数
     * @return 结果数组
     */
    public static int[] getRandomArrayFromExist(int[] arr, int count) {
        shuffle(arr);
        int[] res = new int[count];
        System.arraycopy(arr, 0, res, 0, res.length);
        return res;
    }

    /**
     * 获得一个有序递增数组（递增幅度为1）
     * @param start 最小值（包含）
     * @param end 最大值（包含）
     * @return 结果数组
     */
    public static int[] getOrderedArray(int start, int end) {
        int[] res = new int[end - start + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = start++;
        }
        return res;
    }


    /**
     * 洗牌算法
     * @param arr 要洗的数组
     */
    public static void shuffle(int[] arr) {
        int size = arr.length;
        for (int i = size; i > 1; i--)
            swap(arr, i - 1, nextInt(i));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
