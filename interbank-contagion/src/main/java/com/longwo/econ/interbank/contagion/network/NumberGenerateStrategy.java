package com.longwo.econ.interbank.contagion.network;

/**
 * Created by lijs
 * on 2017/9/24.
 */
public interface NumberGenerateStrategy {
    /**
     * 获得一个代表度分布的数组
     * @return
     */
    public int[] getNumbers();

    /**
     * @return int数组，length为度个数，值为出度另一端的node索引
     * @param size 要产生多少个出度
     * @param self 出度的节点 产生的int数组中的值不能为self
     * @return
     */
    public int[] generateDegrees(int size, int self);
}
