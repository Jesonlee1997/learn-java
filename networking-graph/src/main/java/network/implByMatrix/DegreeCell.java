package network.implByMatrix;

import network.Degree;

import java.util.ArrayList;
import java.util.List;

/**
 * matrix中的一个单元格，表示出度
 * Created by lijs
 * on 2017/8/21.
 */
class DegreeCell {
    private List<Degree> degreeList;

    public DegreeCell() {
        degreeList = new ArrayList<>();
    }

    public void addDegree(Degree degree) {
        degreeList.add(degree);
    }

    public int size() {
        return degreeList.size();
    }

    public List<Degree> getDegreeList() {
        return degreeList;
    }
}
