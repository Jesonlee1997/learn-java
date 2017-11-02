package network.implByMatrix;

import network.NumberGenerateStrategy;
import network.util.RandomTool;

/**
 * @Author lijs
 * @Create-time 2017/10/3.
 */
public class PoissonStrategy2 implements NumberGenerateStrategy {
    public PoissonStrategy2(int size, int avg) {
        this.size = size;
        this.avg = avg;
    }

    private int size;
    //泊松分布的平均值
    private int avg;

    @Override
    public int[] getNumbers() {
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = getPoissonVariable(avg);
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

    @Override
    public int[] generateDegrees(int length, int self) {
        int[] res = new int[length];

        int addNum = 0;
        while (addNum < length) {
            int toAdd = RandomTool.nextInt(size);
            if (toAdd != self) {
                res[addNum++] = toAdd;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10012; i++) {
            int i1 = getPoissonVariable(20);
            System.out.println(i1);
            sum += getPoissonVariable(20);
        }
        System.out.println(sum / 10012);
    }
}
