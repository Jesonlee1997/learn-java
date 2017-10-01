package network.implByMatrix;

import network.NumberGenerateStrategy;
import network.util.RandomTool;

import java.math.BigDecimal;

/**
 * Created by lijs
 * on 2017/9/24.
 */
public class PoissonStrategy implements NumberGenerateStrategy {
    private static final int SCALE = 100;

    public PoissonStrategy(int size, int avg) {
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
        BigDecimal decimal = new BigDecimal(lambda).setScale(SCALE, BigDecimal.ROUND_HALF_UP);

        BigDecimal y = new BigDecimal(Math.random()).setScale(SCALE, BigDecimal.ROUND_HALF_UP), cdf = new BigDecimal(Math.exp(-decimal.doubleValue())).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
        while (cdf.compareTo(y) < 0) {
            x++;
            cdf = cdf.add(getPoissonProbability(x, decimal));
        }
        return Math.abs(x);
    }


    private static BigDecimal getPoissonProbability(int k, BigDecimal lambda) {
        BigDecimal pdf = new BigDecimal(1);
        pdf.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
        int i;
        for (i = 1; i <= k; ++i) {
            pdf = pdf.multiply(lambda.divide(new BigDecimal(i), BigDecimal.ROUND_HALF_UP));
        }
        return pdf.multiply(new BigDecimal(Math.exp(-lambda.doubleValue())).setScale(SCALE, BigDecimal.ROUND_HALF_UP));
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
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sum += getPoissonVariable(100);
            }
        }
        System.out.println(sum / (1 * 10));
    }
}
