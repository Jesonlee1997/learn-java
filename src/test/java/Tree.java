import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lijs
 * on 2017/9/2.
 */
public class Tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Node[] nodes = new Node[count];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
            nodes[i].id = i;
        }
        int rootId = 0;
        for (int i = 0; i < count; i++) {
            nodes[i].nodeName = scanner.next();
            int parentId = scanner.nextInt();
            if (parentId == -1) {
                rootId = i;
                continue;
            }
            nodes[parentId].addChildren(nodes[i]);
        }

        display(nodes[rootId], 0);

    }

    private static void display(Node node, int depth) {
        StringBuilder builder = new StringBuilder();
        List<Node> children = node.children;
        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);

            display(node, depth + 1);
        }
    }

    private static class Node {
        int id;//
        String nodeName;
        List<Node> children = new ArrayList<>();

        public void addChildren(Node node) {
            children.add(node);
        }
    }

}
