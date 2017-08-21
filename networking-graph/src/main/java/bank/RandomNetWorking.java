package bank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lijs
 * on 2017/8/21.
 * 构建一个随机网络
 */
public class RandomNetWorking extends Networking {

    public RandomNetWorking(int nodeNum) {
        super(nodeNum);
    }

    @Override
    public void init() {
        int[] randoms = new int[nodes.length];
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = RandomTools.nextInt(nodes.length);
        }

        for (int i = 0; i < nodes.length; i++) {
            Set<Integer> outDegrees = new HashSet<>();

            for (int j = 0; j < randoms[i]; j++) {
                outDegrees.add(RandomTools.nextInt(nodes.length));
            }

            for (Integer outDegree : outDegrees) {
                nodes[i].addOutDegree(nodes[outDegree]);
            }
        }
    }
}
