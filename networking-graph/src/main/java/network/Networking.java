package network;

import network.implByList.ListNode;

/**
 * Created by lijs
 * on 2017/8/19.
 * 代表网络图
 */
public abstract class Networking {

    protected Node[] nodes;

    public int size() {
        return nodes.length;
    }

    protected NumberGenerateStrategy strategy;

    public void setStrategy(NumberGenerateStrategy strategy) {
        this.strategy = strategy;
    }

    public Networking(int nodeNum) {
        nodes = new ListNode[nodeNum];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode();
        }
    }

    //构建一个初始化网络
    public abstract void init();

    public void print(){}
}
