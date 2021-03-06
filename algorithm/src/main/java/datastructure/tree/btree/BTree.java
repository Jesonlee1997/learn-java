package datastructure.tree.btree;

/**
 * B Tree的特征
 * 1. 树中每个结点含有最多含有m个孩子，即m满足：ceil(m/2)<=m<=m。
 * 2. 除根结点和叶子结点外，其它每个结点至少有[ceil(m / 2)]个孩子（其中ceil(x)是一个取上限的函数）；
 * 3. 根结点不是叶子结点，则至少有2个孩子（特殊情况：没有孩子的根结点，即根结点为叶子结点，整棵树只有一个根节点）；
 * 4. 所有叶子结点都出现在同一层，叶子结点不包含任何关键字信息(可以看做是外部接点或查询失败的接点，实际上这些结点不存在，指向这些结点的指针都为null)；
 * 5. 每个非终端结点中包含有n个关键字信息： (n，P0，K1，P1，K2，P2，......，Kn，Pn)。其中：
    a)   Ki (i=1...n)为关键字，且关键字按顺序升序排序K(i-1)< Ki。
    b)   Pi为指向子树根的接点，且指针P(i-1)指向子树种所有结点的关键字均小于Ki，但都大于K(i-1)。
    c)   除根结点之外的结点的关键字的个数n必须满足： [ceil(m / 2)-1]<= n <= m-1（叶子结点也必须满足此条关于关键字数的性质，根结点除外）。
 * on 2017/7/10.
 */
public class BTree {

}
