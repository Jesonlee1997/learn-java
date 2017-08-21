package bank;

/**
 * Created by lijs
 * on 2017/8/19.
 * 代表网络图
 */
public abstract class Networking {
    protected Node[] nodes;
    public Networking(int nodeNum) {
        nodes = new Node[nodeNum];
    }

    //构建一个初始化网络
    public abstract void init();
}
