package linear;

/**
 * Created by JesonLee
 * on 2017/11/2.
 * first-> -> -> -> last -> null
 */
public class Queue<T> {
    private Node first;//指向最早添加的节点
    private Node last;//指向最近添加的节点
    private int size;

    private class Node {
        T data;
        Node next;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //向表尾添加元素
    public void enqueue(T data) {
        Node oldLast = last;
        last = new Node();
        last.data = data;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;

    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = first.data;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return data;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("java");
        queue.enqueue("python");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
