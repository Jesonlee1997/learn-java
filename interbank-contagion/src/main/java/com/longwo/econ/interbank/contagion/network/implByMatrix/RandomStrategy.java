package com.longwo.econ.interbank.contagion.network.implByMatrix;

import com.longwo.econ.interbank.contagion.network.NumberGenerateStrategy;
import com.longwo.econ.interbank.contagion.network.util.RandomTool;

/**
 * Created by lijs
 * on 2017/9/24.
 */
public class RandomStrategy implements NumberGenerateStrategy {
    public RandomStrategy(int size) {
        this.size = size;
    }

    private int size;



    /**
     * 获得一个int数组，元素的数值范围在0 - node.length * 2之间
     * 有三个level
     * level0:度数 <= node.length / 20 && >=0  出现频率为40%-70%（可定制）
     * level1:度数 > node.length / 20 && < node.length / 2
     * level2:度数 >= node.length / 2 && <= node.length * 2 出现频率为5% - 10%
     *
     * 随机概率出现0个或者1个
     * @return 结果数组
     */
//    @Override
    public int[] getNumbers() {
        //第一步：确定各个level的边界和个数
        int[] res = new int[size];
        assert size > 1;

        int point0 = size / 20;
        int point1 = size / 2;
        int point2 = size * 2;

        int level0Count = (int) (size * (RandomTool.getRandomOf(1, 1) / 100.0) + 0.5);
        int level2Count = (int) (size * (RandomTool.getRandomOf(70, 70) / 100.0) + 0.5);
        int level1Count = size - level0Count - level2Count;


        int idx = 0;

        for (int i = 0; i < level0Count; i++) {
            res[idx++] = RandomTool.getRandomOf(0, point0);
        }

        for (int i = 0; i < level1Count; i++) {
            res[idx++] = RandomTool.getRandomOf(point0, point1);
        }

        for (int i = 0; i < level2Count; i++) {
            res[idx++] = RandomTool.getRandomOf(point1, point2);
        }

        RandomTool.shuffle(res);
        return res;
    }

    //TODO
//    @Override
    public int[] generateDegrees(int length, int self) {
        int[] res = new int[length];
        int addNum = 0;
        while (addNum < length) {
            int toAdd = RandomTool.nextInt(size);
            if (toAdd != self) {
                res[addNum++] = toAdd;
            }
        }
        return res;
    }


}
