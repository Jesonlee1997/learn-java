package network;

/**
 * Created by lijs
 * on 2017/8/19.
 * 代表网络图中的节点
 */
public interface Node {

    /**
     * 为本节点增加一条入度，同时会为另一个节点增加入度
     * @param in 入度另一端的节点
     */
    void addInDegree(Node in);

    /**
     * 为本节点增加一条出度，同时会为另一个节点增加入度
     * @param out 出度另一端的节点
     */
    void addOutDegree(Node out);

}
