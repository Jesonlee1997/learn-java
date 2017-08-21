package network;

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
        int[] numbers = RandomTool.getOrderedArray(0, nodes.length - 1);

        //代表图中每个节点的出度个数
        int[] randoms = RandomTool.getRandomArray(nodes.length - 1, nodes.length);

        for (int i = 0; i < nodes.length; i++) {

            int[] outDegrees = RandomTool.getRandomArrayFromExist(numbers, randoms[i]);

            for (int outDegree : outDegrees) {
                nodes[i].addOutDegree(nodes[outDegree]);
            }

        }
    }
}
