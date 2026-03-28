package SimpleQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class Q100_SameTree {

    // 宽度优先遍历
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        return false;
    }


    // 先序对比
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        return pres(p,q);
    }

    private static boolean pres(TreeNode p, TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        boolean b1 = p.val == q.val;
        boolean b2 = pres(p.left,q.left);
        boolean b3 = pres(p.right,q.right);
        return b1 && b2 && b3;
    }

}
