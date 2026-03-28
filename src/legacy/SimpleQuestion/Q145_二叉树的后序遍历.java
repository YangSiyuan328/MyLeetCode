package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q145_二叉树的后序遍历 {

    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode head) {
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
                    getEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        getEdge(head);
        return list;
    }

    private void getEdge(TreeNode head) {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while (cur.right != null) {
            list.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from.right != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
}
