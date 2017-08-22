package network.implByMatrix;

import network.Degree;
import network.Networking;
import network.util.RandomTool;

/**
 * Created by lijs
 * on 2017/8/21.
 */
public class MatrixNetworking extends Networking {
    // 行表示from的Node索引，列表示to的Node索引 如matrix[1][2]就表示node1到node2的度，
    // 是node1出度中包含node2的部分，是node2的入度中包含node1的部分
    private DegreeCell[][] matrix;

    private int point0 = nodes.length / 20;
    private int point1 = nodes.length / 2;
    private int point2 = nodes.length * 2;

    public MatrixNetworking(int nodeNum) {
        super(nodeNum);
        matrix = new DegreeCell[nodes.length][nodes.length];
    }

    @Override
    public void init() {
        int[] randoms = getDegreeNumbers();//TODO:通过策略生成
        assert randoms != null;

        for (int i = 0; i < randoms.length; i++) {
            int[] degrees = generateDegrees(randoms[i]);//TODO:策略生成
            assert degrees != null;

            for (int degree : degrees) {
                DegreeCell cell;
                if ((cell = matrix[i][degree]) == null) {
                    cell = new DegreeCell();
                    matrix[i][degree] = cell;
                }
                cell.addDegree(new Degree());
                nodes[i].addOutDegree(nodes[degree]);
            }
        }
    }

    @Override
    public void print() {
        StringBuilder builder = new StringBuilder();
        for (DegreeCell[] cells : matrix) {
            //System.out.println("-----------------------------------------------------------");
            builder.append('|');
            for (int j = 0; j < cells.length; j++) {
                if (cells[j] == null) {
                    builder.append("0|");
                    continue;
                }
                builder.append(cells[j].size()).append("|");
            }
            System.out.println(builder.toString());
            builder.setLength(0);
        }
    }


    /**
     * 获得一个int数组，元素的数值范围在0 - node.length * 2之间
     * 有三个level
     * level0:度数 <= node.length / 20 && >=0  出现频率为40%-70%（可定制）
     * level1:度数 > node.length / 20 && < node.length / 2
     * level2:度数 >= node.length / 2 && <= node.length * 2 出现频率为5% - 10%
     *
     * 随机概率出现0个或者1个
     * @return 结果数组
     */
    private int[] getDegreeNumbers() {
        //第一步：确定各个level的边界和个数
        int size = nodes.length;
        int[] res = new int[size];
        assert size > 1;

        int level0Count = (int) (size * (RandomTool.getRandomOf(40, 70) / 100.0) + 0.5);
        int level2Count = (int) (size * (RandomTool.getRandomOf(5, 10) / 100.0) + 0.5);
        int level1Count = size - level0Count - level2Count;


        int idx = 0;

        for (int i = 0; i < level0Count; i++) {
            res[idx++] = RandomTool.getRandomOf(0, point0);
        }

        for (int i = 0; i < level1Count; i++) {
            res[idx++] = RandomTool.getRandomOf(point0, point1);
        }

        for (int i = 0; i < level2Count; i++) {
            res[idx++] = RandomTool.getRandomOf(point1, point2);
        }

        RandomTool.shuffle(res);
        return res;
    }

    /**
     * @return int数组，length为度个数，值为出度另一端的node索引
     */
    private int[] generateDegrees(int length) {

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = RandomTool.nextInt(nodes.length);
        }
        return res;
    }

    public static void main(String[] args) {
        int size = 1000;
        for (int i = 0; i < 10; i++) {
            System.out.println((int)(size * (RandomTool.getRandomOf(5, 10) / 100.0) + 0.5));
        }
    }
}
