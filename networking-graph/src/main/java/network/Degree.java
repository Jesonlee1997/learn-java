package network;

/**
 * Created by lijs
 * on 2017/8/22.
 */
public class Degree {
    private static final int DEFAULT_WEIGHT = 0;

    Node from;
    Node to;
    private int weight;

    public Degree() {
        weight = DEFAULT_WEIGHT;
    }

    public Degree(int weight) {
        this.weight = weight;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
