package linear;

/**
 * Created by JesonLee
 * on 2017/11/2.
 */
public class Stack<T> {
    private Node first = null;
    private int size = 0;


    private class Node {
        T data;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void push(T data) {
        if (isEmpty()) {
            first = new Node();
            first.data = data;
        } else {
            Node node = new Node();
            node.next = first;
            node.data = data;
            first = node;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        size--;
        Node node = first;
        first = node.next;
        return node.data;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("jeson");
        stack.push("lee");
        stack.push("java");
        stack.push("python");
        System.out.println(stack.size());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.size());
    }
}
