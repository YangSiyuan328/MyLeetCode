package 面试题;

import java.util.Stack;

public class Q04_06_SuccessorLCCI {

    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{2, 1, 3};
//        TreeNode treeNode = new TreeNode(arr);
//        System.out.println(treeNode);
//        System.out.println(inorderSuccessor(treeNode,new TreeNode(1)));
        Integer[] arr2 = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        TreeNode treeNode2 = new TreeNode(arr2);
        System.out.println(treeNode2);
        System.out.println(inorderSuccessor(treeNode2, new TreeNode(6)));
    }

    public static TreeNode inorderSuccessor(TreeNode head, TreeNode p) {
        if (head == null) return null;
        if (head.left == null && head.right == null) return null;
        TreeNode pre = null;
        TreeNode cur = head;
        while (cur.val > p.val) {
            pre = cur;
            cur = cur.left;
        }
        if (cur != head && cur.val == p.val) return new TreeNode(pre.val);
        if (cur != head && cur.right != null && cur.right.val == p.val) return new TreeNode(pre.val);
        return inorderSuccessor(cur.right, p);
    }

}

