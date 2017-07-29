package 数据结构.bplusTree;

import java.util.Random;

/**
 * B+树的定义
 * 1、任意非叶子节点最多有M个子节点；且M>2
 * 2、除根节点外的非叶子节点至少有M/2个子节点
 * 3、根节点至少有2个子节点
 * 4.除根节点外每个结点存放至少M/2和至多M个关键字；（至少2个关键字）
 * 5.非叶子结点的子树指针与关键字个数相同；
 * 6.所有结点的关键字：K[1], K[2], …, K[M]；且K[i] < K[i+1]；
 * 7.非叶子结点的子树指针P[i]，指向关键字值属于[K[i], K[i+1])的子树；
 * 8.所有叶子结点位于同一层；
 * 9、为所有叶子结点增加一个链指针；
 * 10.所有关键字都在叶子结点出现；
 * Created by JesonLee
 * on 2017/7/9.
 */
public class BplusTree implements B {

    /** 根节点 */
    protected Node root;

    /** 阶数，M值 */
    protected int order;

    /** 叶子节点的链表头*/
    protected Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public Object get(Comparable key) {
        return root.get(key);
    }

    @Override
    public void remove(Comparable key) {
        root.remove(key, this);

    }

    @Override
    public void insertOrUpdate(Comparable key, Object obj) {
        root.insertOrUpdate(key, obj, this);
    }

    public BplusTree(int order){
        if (order < 3) {
            System.out.print("order must be greater than 2");
            System.exit(0);
        }
        this.order = order;
        root = new Node(true, true);
        head = root;
    }

    //测试
    public static void main(String[] args) {
        BplusTree tree = new BplusTree(6);
        Random random = new Random();
        long current = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(1000);
                tree.insertOrUpdate(randomNumber, randomNumber);
            }

            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(1000);
                tree.remove(randomNumber);
            }
        }

        long duration = System.currentTimeMillis() - current;
        System.out.println("time elpsed for duration: " + duration);
        /*tree.insertOrUpdate(80, "Jeson");*/
        int search = 80;
        System.out.print(tree.get(search));
    }
}
