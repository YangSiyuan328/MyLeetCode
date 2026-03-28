package MiddleQuestion;

import java.util.ArrayList;

class Q98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode head) {
        return false;
    }

    public boolean isValidBST1(TreeNode head) {
        if (head == null) return true;
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).val <= arr.get(i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public boolean isValidBST2(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    public static class Info {
        boolean isBST;
        public int min;
        public int max;

        public Info(boolean is, int mi, int ma) {
            isBST = is;
            min = mi;
            max = ma;
        }
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int min = head.val;
        int max = head.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        boolean isBST = false;
        if ((leftInfo == null || (leftInfo.isBST && leftInfo.max < head.val))
                && (rightInfo == null || (rightInfo.isBST && rightInfo.min > head.val))
        ) {
            isBST = true;
        }
        return new Info(isBST, min, max);
    }

    //大佬中序遍历
    double last = -Double.MAX_VALUE;
    public boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}


