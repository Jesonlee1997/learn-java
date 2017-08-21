package network;

/**
 * Created by lijs
 * on 2017/8/19.
 * 代表网络图
 */
public abstract class Networking {
    //平均的出度值
    protected int avg;

    protected Node[] nodes;

    public Networking(int nodeNum) {
        nodes = new Node[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            nodes[i] = new Node();
        }
        avg = nodeNum / 2;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    //构建一个初始化网络
    public abstract void init();

    public static void main(String[] args) {
        //Networking networking = new RandomNetWorking(100);
        Networking networking = new PoissonNetWorking(100);
        networking.init();
        System.out.println();
    }
}
