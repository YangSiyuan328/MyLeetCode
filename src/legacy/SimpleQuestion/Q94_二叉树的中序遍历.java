package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q94_二叉树的中序遍历 {

    ArrayList<Integer> list = new ArrayList<>();



    public List<Integer> inorderTraversal1(TreeNode head) {
        if (head == null) return list;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

}
