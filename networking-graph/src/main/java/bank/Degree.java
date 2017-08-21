package bank;

/**
 * Created by lijs
 * on 2017/8/19.
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
}
