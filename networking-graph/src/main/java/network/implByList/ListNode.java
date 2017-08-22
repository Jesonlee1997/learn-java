package network.implByList;

import network.Degree;
import network.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijs
 * on 2017/8/19.
 * 代表网络图中的节点，邻接表中的Node
 */
public class ListNode implements Node {
    private final List<Degree> inDegree = new ArrayList<>();
    private final List<Degree> outDegree = new ArrayList<>();

    /**
     * 为本节点增加一条入度，同时会为另一个节点增加入度
     * @param in 入度另一端的节点
     */
    @Override
    public void addInDegree(Node in) {
        Degree degree = new Degree();
        degree.setFrom(in);
        degree.setTo(this);
        inDegree.add(degree);
        ((ListNode)in).outDegree.add(degree);
    }

    /**
     * 为本节点增加一条出度，同时会为另一个节点增加入度
     * @param out 出度另一端的节点
     */
    @Override
    public void addOutDegree(Node out) {
        Degree degree = new Degree();
        degree.setFrom(this);
        degree.setTo(out);
        outDegree.add(degree);
        ((ListNode)out).inDegree.add(degree);
    }

}
