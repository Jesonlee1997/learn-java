package com.longwo.econ.interbank.contagion.network.implByList;



import com.longwo.econ.interbank.contagion.network.Degree;
import com.longwo.econ.interbank.contagion.network.Node;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by lijs
 * on 2017/8/19.
 * 代表网络图中的节点，邻接表中的Node
 */
public class ListNode implements Node {
    private final List<Degree> inDegrees = new ArrayList<Degree>();
    private final List<Degree> outDegrees = new ArrayList<Degree>();

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

    private static int getPossionVariable(double lamda) {
        int x = 0;
        double y = Math.random(), cdf = getPossionProbability(x, lamda);
        while (cdf < y) {
            x++;
            cdf += getPossionProbability(x, lamda);
        }
        return x;
    }

    private static double getPossionProbability(int k, double lamda) {
        double c = Math.exp(-lamda), sum = 1;
        for (int i = 1; i <= k; i++) {
            sum *= lamda / i;
        }
        return sum * c;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (getPossionVariable(100) > 200) {
                System.out.println(">>");
            }

        }

    }
}
