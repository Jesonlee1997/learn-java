package network;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijs
 * on 2017/8/19.
 * 代表网络图中的节点
 */
public class Node {
    private final List<Degree> inDegree = new ArrayList<>();
    private final List<Degree> outDegree = new ArrayList<>();

    /**
     * 为本节点增加一条入度，同时会为另一个节点增加入度
     * @param in 入度另一端的节点
     */
    public void addInDegree(Node in) {
        Degree degree = new Degree();
        degree.from = in;
        degree.to = this;
        inDegree.add(degree);
        in.outDegree.add(degree);
    }

    /**
     * 为本节点增加一条出度，同时会为另一个节点增加入度
     * @param out 出度另一端的节点
     */
    public void addOutDegree(Node out) {
        Degree degree = new Degree();
        degree.from = this;
        degree.to = out;
        outDegree.add(degree);
        out.inDegree.add(degree);
    }

}
