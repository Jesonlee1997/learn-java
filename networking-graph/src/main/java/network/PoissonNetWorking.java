package network;

/**
 * 基于泊松分布的网络图
 * 注意：在数值过大 > 700 由于double运算的精度问题无法形成泊松分布的值
 * Created by lijs
 * on 2017/8/21.
 */
public class PoissonNetWorking extends Networking {

    public PoissonNetWorking(int nodeNum) {
        super(nodeNum);
    }

    @Override
    public void init() {
        int[] numbers = RandomTool.getOrderedArray(0, nodes.length - 1);

        //获得符合泊松分布的一系列出度，出度个数最多为节点的总数-1
        int[] poissons = getPoissonNumbers(avg);

        for (int i = 0; i < nodes.length; i++) {
            int[] outDegrees = RandomTool.getRandomArrayFromExist(numbers, poissons[i]);

            for (int outDegree : outDegrees) {
                nodes[i].addOutDegree(nodes[outDegree]);
            }
        }
    }

    /**
     * 获得符合泊松分布的一系列值，这一系列值的数学期望是avg
     * 注意：在avg过大（> 700） 由于double运算的精度问题无法正常工作
     * @param avg 平均的数学期望
     * @return 结果数组
     */
    private int[] getPoissonNumbers(int avg) {
        int[] res = new int[nodes.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = getPoissonVariable(avg) % (nodes.length - 1);
        }
        return res;
    }

    private static int getPoissonVariable(double lambda) {
        int x = 0;
        double y = Math.random(), cdf = Math.exp(-1.0 * lambda);
        while (cdf <= y) {
            x++;
            cdf += getPoissonProbability(x, lambda);
        }
        return Math.abs(x);
    }


    private static double getPoissonProbability(int k, double lambda) {
        double pdf = 1;
        int i;
        for (i = 1; i <= k; ++i) {
            pdf *= lambda / i;
        }
        return pdf * Math.exp(-1.0 * lambda);
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            int p = getPoissonVariable(700);
            sum += p;
        }
        System.out.println((double) (sum) / 10000f);
    }
}
