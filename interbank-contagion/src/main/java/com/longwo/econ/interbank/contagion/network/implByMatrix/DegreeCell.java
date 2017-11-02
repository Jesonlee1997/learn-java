package com.longwo.econ.interbank.contagion.network.implByMatrix;



import java.util.ArrayList;
import java.util.List;

import com.longwo.econ.interbank.contagion.network.Degree;


/**
 * matrix中的一个单元格，表示出度
 * Created by lijs
 * on 2017/8/21.
 */
class DegreeCell {
    private List<Degree> degreeList;

    public DegreeCell() {
        degreeList = new ArrayList<Degree>();
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
