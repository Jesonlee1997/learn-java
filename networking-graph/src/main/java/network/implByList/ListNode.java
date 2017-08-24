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
    private final List<Degree> inDegrees = new ArrayList<>();
    private final List<Degree> outDegrees = new ArrayList<>();

    @Override
    public void addInDegree(Node in) {
        Degree degree = new Degree();
        degree.setFrom(in);
        degree.setTo(this);
        inDegrees.add(degree);
        ((ListNode)in).outDegrees.add(degree);
    }

    @Override
    public void addOutDegree(Node out) {
        Degree degree = new Degree();
        degree.setFrom(this);
        degree.setTo(out);
        outDegrees.add(degree);
        ((ListNode)out).inDegrees.add(degree);
    }

    @Override
    public void addOutDegree(Node out, Degree degree) {
        degree.setFrom(this);
        degree.setTo(out);
        outDegrees.add(degree);
        ((ListNode)out).inDegrees.add(degree);
    }

    @Override
    public List<Degree> getOutDegrees() {
        return outDegrees;
    }

    @Override
    public List<Degree> getInDegrees() {
        return inDegrees;
    }

}
