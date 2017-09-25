package network.implByMatrix;

import network.Degree;
import network.Networking;
import network.util.RandomTool;

import java.util.List;

/**
 * Created by lijs
 * on 2017/8/21.
 */
public class MatrixNetworking extends Networking {
    // 行表示from的Node索引，列表示to的Node索引 如matrix[1][2]就表示node1到node2的度，
    // 是node1出度中包含node2的部分，是node2的入度中包含node1的部分
    private DegreeCell[][] matrix;


    public MatrixNetworking(int nodeNum) {
        super(nodeNum);
        matrix = new DegreeCell[nodes.length][nodes.length];
    }

    @Override
    public void init() {
        int[] randoms = strategy.getNumbers();
        assert randoms != null;

        for (int i = 0; i < randoms.length; i++) {
            int[] degrees = strategy.generateDegrees(randoms[i], i);
            assert degrees != null && degrees.length == randoms[i];

            for (int degree : degrees) {
                DegreeCell cell;
                if ((cell = matrix[i][degree]) == null) {
                    cell = new DegreeCell();
                    matrix[i][degree] = cell;
                }
                Degree thDegree = new Degree();
                cell.addDegree(thDegree);
                nodes[i].addOutDegree(nodes[degree], thDegree);
            }
        }
    }

    @Override
    public void print() {
        StringBuilder builder = new StringBuilder();
        for (DegreeCell[] cells : matrix) {
            //System.out.println("-----------------------------------------------------------");
            builder.append('|');
            for (DegreeCell cell : cells) {
                if (cell == null) {
                    builder.append("0|");
                    continue;
                }
                builder.append(cell.size()).append("|");
            }
            System.out.println(builder.toString());
            builder.setLength(0);
        }
    }

    public List<Degree> getOutDegreesOf(int nodeIndex) {
        return nodes[nodeIndex].getOutDegrees();
    }

    public List<Degree> getInDegreesOf(int nodeIndex) {
        return nodes[nodeIndex].getInDegrees();
    }

    public List<Degree> getOutDegreesOf(int fromIndex, int toIndex) {
        return matrix[fromIndex][toIndex].getDegreeList();
    }

    public List<Degree> getInDegreesOf(int fromIndex, int toIndex) {
        return matrix[toIndex][fromIndex].getDegreeList();
    }


    public static void main(String[] args) {
        int size = 1000;
        for (int i = 0; i < 10; i++) {
            System.out.println((int)(size * (RandomTool.getRandomOf(5, 10) / 100.0) + 0.5));
        }
    }
}
