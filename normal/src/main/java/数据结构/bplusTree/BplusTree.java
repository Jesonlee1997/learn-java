package 数据结构.bplusTree;

import java.util.ArrayList;
import java.util.List;
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
public class BplusTree<K extends Comparable<K>, V> implements B<K, V> {

    /**
     * 根节点
     */
    protected Node<K, V> root;

    /**
     * 阶数，M值
     */
    protected int order;

    /**
     * 叶子节点的链表头
     */
    protected Node<K, V> head;

    public Node<K, V> getHead() {
        return head;
    }

    public void setHead(Node<K, V> head) {
        this.head = head;
    }

    public Node<K, V> getRoot() {
        return root;
    }

    public void setRoot(Node<K, V> root) {
        this.root = root;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public V get(K key) {
        return root.get(key);
    }

    @Override
    public void remove(K key) {
        root.remove(key, this);

    }

    @Override
    public void put(K key, V obj) {
        root.put(key, obj, this);
    }

    public BplusTree(int order) {
        if (order < 3) {
            System.out.print("order must be greater than 2");
            System.exit(0);
        }
        this.order = order;
        root = new Node<>(true, true);
        head = root;
    }

    //测试
    public static void main(String[] args) {
        BplusTree<Integer, Integer> tree = new BplusTree<>(6);
        Random random = new Random();
        long current = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(1000);
                tree.put(randomNumber, randomNumber);
            }

            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(1000);
                tree.remove(randomNumber);
            }
        }

        long duration = System.currentTimeMillis() - current;
        System.out.println("time elpsed for duration: " + duration);
        /*tree.put(80, "Jeson");*/
        int search = 80;
        System.out.print(tree.get(search));
    }

    /**
     * Created by JesonLee
     * on 2017/7/9.
     */
    private static class Node<K extends Comparable<K>, V> {
        /**
         * 是否为叶子节点
         */
        private boolean isLeaf;

        /**
         * 是否为根节点
         */
        private boolean isRoot;

        /**
         * 父节点
         */
        private Node<K, V> parent;

        /**
         * 叶节点的前节点
         */
        private Node<K, V> previous;

        /**
         * 叶节点的后节点
         */
        private Node<K, V> next;

        /**
         * 节点的关键字
         */
        private List<Entry<K, V>> entries;

        /**
         * 子节点
         */
        private List<Node<K, V>> children;

        Node(boolean isLeaf) {
            this.isLeaf = isLeaf;
            entries = new ArrayList<>();

            if (!isLeaf) {
                children = new ArrayList<>();
            }
        }

        Node(boolean isLeaf, boolean isRoot) {
            this(isLeaf);
            this.isRoot = isRoot;
        }

        public V get(K key) {

            //如果是叶子节点
            if (isLeaf) {
                for (Entry<K, V> entry : entries) {
                    if (entry.getKey().compareTo(key) == 0) {
                        //返回找到的对象
                        return entry.getValue();
                    }
                }
                //未找到所要查询的对象
                return null;

                //如果不是叶子节点
            } else {
                //如果key小于等于节点最左边的key，沿第一个子节点继续搜索
                if (key.compareTo(entries.get(0).getKey()) <= 0) {
                    return children.get(0).get(key);
                    //如果key大于节点最右边的key，沿最后一个子节点继续搜索
                } else if (key.compareTo(entries.get(entries.size() - 1).getKey()) >= 0) {
                    return children.get(children.size() - 1).get(key);
                    //否则沿比key大的前一个子节点继续搜索
                } else {
                    for (int i = 0; i < entries.size(); i++) {
                        if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i + 1).getKey().compareTo(key) > 0) {
                            return children.get(i).get(key);
                        }
                    }
                }
            }

            return null;
        }

        public void put(K key, V val, BplusTree<K, V> tree) {
            //如果是叶子节点
            if (isLeaf) {
                //不需要分裂，直接插入或更新
                if (contains(key) || entries.size() < tree.getOrder()) {
                    put(key, val);
                    if (parent != null) {
                        //更新父节点
                        parent.updateInsert(tree);
                    }

                    //需要分裂
                } else {
                    //分裂成左右两个节点
                    Node<K, V> left = new Node<K, V>(true);
                    Node<K, V> right = new Node<K, V>(true);
                    //设置链接
                    if (previous != null) {
                        previous.setNext(left);
                        left.setPrevious(previous);
                    }
                    if (next != null) {
                        next.setPrevious(right);
                        right.setNext(next);
                    }
                    if (previous == null) {
                        tree.setHead(left);
                    }

                    left.setNext(right);
                    right.setPrevious(left);
                    previous = null;
                    next = null;

                    //左右两个节点关键字长度
                    int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2;
                    int rightSize = (tree.getOrder() + 1) / 2;
                    //复制原节点关键字到分裂出来的新节点
                    put(key, val);
                    for (int i = 0; i < leftSize; i++) {
                        left.getEntries().add(entries.get(i));
                    }
                    for (int i = 0; i < rightSize; i++) {
                        right.getEntries().add(entries.get(leftSize + i));
                    }

                    //如果不是根节点
                    if (parent != null) {
                        //调整父子节点关系
                        int index = parent.getChildren().indexOf(this);
                        parent.getChildren().remove(this);
                        left.setParent(parent);
                        right.setParent(parent);
                        parent.getChildren().add(index, left);
                        parent.getChildren().add(index + 1, right);
                        setEntries(null);
                        setChildren(null);

                        //父节点插入或更新关键字
                        parent.updateInsert(tree);
                        setParent(null);
                        //如果是根节点
                    } else {
                        isRoot = false;
                        Node<K, V> parent = new Node<K, V>(false, true);
                        tree.setRoot(parent);
                        left.setParent(parent);
                        right.setParent(parent);
                        parent.getChildren().add(left);
                        parent.getChildren().add(right);
                        setEntries(null);
                        setChildren(null);

                        //更新根节点
                        parent.updateInsert(tree);
                    }


                }

                //如果不是叶子节点
            } else {
                //如果key小于等于节点最左边的key，沿第一个子节点继续搜索
                if (key.compareTo(entries.get(0).getKey()) <= 0) {
                    children.get(0).put(key, val, tree);
                    //如果key大于节点最右边的key，沿最后一个子节点继续搜索
                } else if (key.compareTo(entries.get(entries.size() - 1).getKey()) >= 0) {
                    children.get(children.size() - 1).put(key, val, tree);
                    //否则沿比key大的前一个子节点继续搜索
                } else {
                    for (int i = 0; i < entries.size(); i++) {
                        if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i + 1).getKey().compareTo(key) > 0) {
                            children.get(i).put(key, val, tree);
                            break;
                        }
                    }
                }
            }
        }

        /**
         * 插入节点后中间节点的更新
         */
        private void updateInsert(BplusTree tree) {

            validate(this, tree);

            //如果子节点数超出阶数，则需要分裂该节点
            if (children.size() > tree.getOrder()) {
                //分裂成左右两个节点
                Node<K, V> left = new Node<K, V>(false);
                Node<K, V> right = new Node<K, V>(false);
                //左右两个节点关键字长度
                int leftSize = (tree.getOrder() + 1) / 2 + (tree.getOrder() + 1) % 2;
                int rightSize = (tree.getOrder() + 1) / 2;
                //复制子节点到分裂出来的新节点，并更新关键字
                for (int i = 0; i < leftSize; i++) {
                    left.getChildren().add(children.get(i));
                    left.getEntries().add(new Entry<>(children.get(i).getEntries().get(0).getKey(), null));
                    children.get(i).setParent(left);
                }
                for (int i = 0; i < rightSize; i++) {
                    right.getChildren().add(children.get(leftSize + i));
                    right.getEntries().add(new Entry<>(children.get(leftSize + i).getEntries().get(0).getKey(), null));
                    children.get(leftSize + i).setParent(right);
                }

                //如果不是根节点
                if (parent != null) {
                    //调整父子节点关系
                    int index = parent.getChildren().indexOf(this);
                    parent.getChildren().remove(this);
                    left.setParent(parent);
                    right.setParent(parent);
                    parent.getChildren().add(index, left);
                    parent.getChildren().add(index + 1, right);
                    setEntries(null);
                    setChildren(null);

                    //父节点更新关键字
                    parent.updateInsert(tree);
                    setParent(null);
                    //如果是根节点
                } else {
                    isRoot = false;
                    Node<K, V> parent = new Node<K, V>(false, true);
                    tree.setRoot(parent);
                    left.setParent(parent);
                    right.setParent(parent);
                    parent.getChildren().add(left);
                    parent.getChildren().add(right);
                    setEntries(null);
                    setChildren(null);

                    //更新根节点
                    parent.updateInsert(tree);
                }
            }
        }

        /**
         * 调整节点关键字
         */
        protected void validate(Node<K, V> node, BplusTree tree) {

            // 如果关键字个数与子节点个数相同
            if (node.getEntries().size() == node.getChildren().size()) {
                for (int i = 0; i < node.getEntries().size(); i++) {
                    K key = node.getChildren().get(i).getEntries().get(0).getKey();
                    if (node.getEntries().get(i).getKey().compareTo(key) != 0) {
                        node.getEntries().remove(i);
                        node.getEntries().add(i, new Entry<>(key, null));
                        if (!node.isRoot()) {
                            validate(node.getParent(), tree);
                        }
                    }
                }
                // 如果子节点数不等于关键字个数但仍大于M / 2并且小于M，并且大于2
            } else if (node.isRoot() && node.getChildren().size() >= 2
                    || node.getChildren().size() >= tree.getOrder() / 2
                    && node.getChildren().size() <= tree.getOrder()
                    && node.getChildren().size() >= 2) {
                node.getEntries().clear();
                for (int i = 0; i < node.getChildren().size(); i++) {
                    K key = node.getChildren().get(i).getEntries().get(0).getKey();
                    node.getEntries().add(new Entry<>(key, null));
                    if (!node.isRoot()) {
                        validate(node.getParent(), tree);
                    }
                }
            }
        }

        /**
         * 删除节点后中间节点的更新
         */
        protected void updateRemove(BplusTree tree) {

            validate(this, tree);

            // 如果子节点数小于M / 2或者小于2，则需要合并节点
            if (children.size() < tree.getOrder() / 2 || children.size() < 2) {
                if (isRoot) {
                    // 如果是根节点并且子节点数大于等于2，OK
                    if (children.size() >= 2) {
                        return;
                        // 否则与子节点合并
                    } else {
                        Node<K, V> root = children.get(0);
                        tree.setRoot(root);
                        root.setParent(null);
                        root.setRoot(true);
                        setEntries(null);
                        setChildren(null);
                    }
                } else {
                    //计算前后节点
                    int currIdx = parent.getChildren().indexOf(this);
                    int prevIdx = currIdx - 1;
                    int nextIdx = currIdx + 1;
                    Node<K, V> previous = null, next = null;
                    if (prevIdx >= 0) {
                        previous = parent.getChildren().get(prevIdx);
                    }
                    if (nextIdx < parent.getChildren().size()) {
                        next = parent.getChildren().get(nextIdx);
                    }

                    // 如果前节点子节点数大于M / 2并且大于2，则从其处借补
                    if (previous != null
                            && previous.getChildren().size() > tree.getOrder() / 2
                            && previous.getChildren().size() > 2) {
                        //前叶子节点末尾节点添加到首位
                        int idx = previous.getChildren().size() - 1;
                        Node<K, V> borrow = previous.getChildren().get(idx);
                        previous.getChildren().remove(idx);
                        borrow.setParent(this);
                        children.add(0, borrow);
                        validate(previous, tree);
                        validate(this, tree);
                        parent.updateRemove(tree);

                        // 如果后节点子节点数大于M / 2并且大于2，则从其处借补
                    } else if (next != null
                            && next.getChildren().size() > tree.getOrder() / 2
                            && next.getChildren().size() > 2) {
                        //后叶子节点首位添加到末尾
                        Node<K, V> borrow = next.getChildren().get(0);
                        next.getChildren().remove(0);
                        borrow.setParent(this);
                        children.add(borrow);
                        validate(next, tree);
                        validate(this, tree);
                        parent.updateRemove(tree);

                        // 否则需要合并节点
                    } else {
                        // 同前面节点合并
                        if (previous != null
                                && (previous.getChildren().size() <= tree.getOrder() / 2 || previous.getChildren().size() <= 2)) {

                            for (int i = previous.getChildren().size() - 1; i >= 0; i--) {
                                Node<K, V> child = previous.getChildren().get(i);
                                children.add(0, child);
                                child.setParent(this);
                            }
                            previous.setChildren(null);
                            previous.setEntries(null);
                            previous.setParent(null);
                            parent.getChildren().remove(previous);
                            validate(this, tree);
                            parent.updateRemove(tree);

                            // 同后面节点合并
                        } else if (next != null
                                && (next.getChildren().size() <= tree.getOrder() / 2 || next.getChildren().size() <= 2)) {

                            for (int i = 0; i < next.getChildren().size(); i++) {
                                Node<K, V> child = next.getChildren().get(i);
                                children.add(child);
                                child.setParent(this);
                            }
                            next.setChildren(null);
                            next.setEntries(null);
                            next.setParent(null);
                            parent.getChildren().remove(next);
                            validate(this, tree);
                            parent.updateRemove(tree);
                        }
                    }
                }
            }
        }

        public void remove(K key, BplusTree tree) {
            //如果是叶子节点
            if (isLeaf) {

                //如果不包含该关键字，则直接返回
                if (!contains(key)) {
                    return;
                }

                //如果既是叶子节点又是跟节点，直接删除
                if (isRoot) {
                    remove(key);
                } else {
                    //如果关键字数大于M / 2，直接删除
                    if (entries.size() > tree.getOrder() / 2 && entries.size() > 2) {
                        remove(key);
                    } else {
                        //如果自身关键字数小于M / 2，并且前节点关键字数大于M / 2，则从其处借补
                        if (previous != null
                                && previous.getEntries().size() > tree.getOrder() / 2
                                && previous.getEntries().size() > 2
                                && previous.getParent() == parent) {
                            int size = previous.getEntries().size();
                            Entry<K, V> entry = previous.getEntries().get(size - 1);
                            previous.getEntries().remove(entry);
                            //添加到首位
                            entries.add(0, entry);
                            remove(key);
                            //如果自身关键字数小于M / 2，并且后节点关键字数大于M / 2，则从其处借补
                        } else if (next != null
                                && next.getEntries().size() > tree.getOrder() / 2
                                && next.getEntries().size() > 2
                                && next.getParent() == parent) {
                            Entry entry = next.getEntries().get(0);
                            next.getEntries().remove(entry);
                            //添加到末尾
                            entries.add(entry);
                            remove(key);
                            //否则需要合并叶子节点
                        } else {
                            //同前面节点合并
                            if (previous != null
                                    && (previous.getEntries().size() <= tree.getOrder() / 2 || previous.getEntries().size() <= 2)
                                    && previous.getParent() == parent) {
                                for (int i = previous.getEntries().size() - 1; i >= 0; i--) {
                                    //从末尾开始添加到首位
                                    entries.add(0, previous.getEntries().get(i));
                                }
                                remove(key);
                                previous.setParent(null);
                                previous.setEntries(null);
                                parent.getChildren().remove(previous);
                                //更新链表
                                if (previous.getPrevious() != null) {
                                    Node<K, V> temp = previous;
                                    temp.getPrevious().setNext(this);
                                    previous = temp.getPrevious();
                                    temp.setPrevious(null);
                                    temp.setNext(null);
                                } else {
                                    tree.setHead(this);
                                    previous.setNext(null);
                                    previous = null;
                                }
                                //同后面节点合并
                            } else if (next != null
                                    && (next.getEntries().size() <= tree.getOrder() / 2 || next.getEntries().size() <= 2)
                                    && next.getParent() == parent) {
                                for (int i = 0; i < next.getEntries().size(); i++) {
                                    //从首位开始添加到末尾
                                    entries.add(next.getEntries().get(i));
                                }
                                remove(key);
                                next.setParent(null);
                                next.setEntries(null);
                                parent.getChildren().remove(next);
                                //更新链表
                                if (next.getNext() != null) {
                                    Node<K, V> temp = next;
                                    temp.getNext().setPrevious(this);
                                    next = temp.getNext();
                                    temp.setPrevious(null);
                                    temp.setNext(null);
                                } else {
                                    next.setPrevious(null);
                                    next = null;
                                }
                            }
                        }
                    }
                    parent.updateRemove(tree);
                }
                //如果不是叶子节点
            } else {
                //如果key小于等于节点最左边的key，沿第一个子节点继续搜索
                if (key.compareTo(entries.get(0).getKey()) <= 0) {
                    children.get(0).remove(key, tree);
                    //如果key大于节点最右边的key，沿最后一个子节点继续搜索
                } else if (key.compareTo(entries.get(entries.size() - 1).getKey()) >= 0) {
                    children.get(children.size() - 1).remove(key, tree);
                    //否则沿比key大的前一个子节点继续搜索
                } else {
                    for (int i = 0; i < entries.size(); i++) {
                        if (entries.get(i).getKey().compareTo(key) <= 0 && entries.get(i + 1).getKey().compareTo(key) > 0) {
                            children.get(i).remove(key, tree);
                            break;
                        }
                    }
                }
            }
        }

        /**
         * 判断当前节点是否包含该关键字
         */
        protected boolean contains(K key) {
            for (Entry<K, V> entry : entries) {
                if (entry.getKey().compareTo(key) == 0) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 插入到当前节点的关键字中
         */
        protected void put(K key, V val) {
            Entry<K, V> entry = new Entry<>(key, val);
            //如果关键字列表长度为0，则直接插入
            if (entries.size() == 0) {
                entries.add(entry);
                return;
            }
            //否则遍历列表
            for (int i = 0; i < entries.size(); i++) {
                //如果该关键字键值已存在，则更新
                if (entries.get(i).getKey().compareTo(key) == 0) {
                    entries.get(i).setValue(val);
                    return;
                    //否则插入
                } else if (entries.get(i).getKey().compareTo(key) > 0) {
                    //插入到链首
                    if (i == 0) {
                        entries.add(0, entry);
                        return;
                        //插入到中间
                    } else {
                        entries.add(i, entry);
                        return;
                    }
                }
            }
            //插入到末尾
            entries.add(entries.size(), entry);
        }

        /**
         * 删除节点
         */
        protected void remove(K key) {
            int index = -1;
            for (int i = 0; i < entries.size(); i++) {
                if (entries.get(i).getKey().compareTo(key) == 0) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                entries.remove(index);
            }
        }

        private Node<K, V> getPrevious() {
            return previous;
        }

        private void setPrevious(Node<K, V> previous) {
            this.previous = previous;
        }

        private Node<K, V> getNext() {
            return next;
        }

        private void setNext(Node<K, V> next) {
            this.next = next;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        private Node<K, V> getParent() {
            return parent;
        }

        private void setParent(Node<K, V> parent) {
            this.parent = parent;
        }

        private List<Entry<K, V>> getEntries() {
            return entries;
        }

        private void setEntries(List<Entry<K, V>> entries) {
            this.entries = entries;
        }

        private List<Node<K, V>> getChildren() {
            return children;
        }

        private void setChildren(List<Node<K, V>> children) {
            this.children = children;
        }

        private boolean isRoot() {
            return isRoot;
        }

        private void setRoot(boolean isRoot) {
            this.isRoot = isRoot;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("isRoot: ");
            sb.append(isRoot);
            sb.append(", ");
            sb.append("isLeaf: ");
            sb.append(isLeaf);
            sb.append(", ");
            sb.append("keys: ");
            for (Entry entry : entries) {
                sb.append(entry.getKey());
                sb.append(", ");
            }
            sb.append(", ");
            return sb.toString();

        }

        static class Entry<K extends Comparable<K>, V> {
            K key;
            V value;

            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }

            K getKey() {
                return key;
            }

            public void setKey(K key) {
                this.key = key;
            }

            V getValue() {
                return value;
            }

            void setValue(V value) {
                this.value = value;
            }
        }
    }
}
