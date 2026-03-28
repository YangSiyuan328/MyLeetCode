package SimpleQuestion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q653_两数之和IV输入BST {
    public static void main(String[] args) {
        Q653_两数之和IV输入BST Q = new Q653_两数之和IV输入BST();
        TreeNode treeNode = new TreeNode(new Integer[]{-3, -4, 0, null, null, -2, 1});
        System.out.println(treeNode);
        System.out.println(Q.findTarget(treeNode, -1));
    }

    /**
     * 思路，边遍历边查找，这样效率高
     * @param head 头结点
     * @param k
     * @return
     */
    public static boolean findTarget1(TreeNode head, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        set.add(head.val);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                if (set.contains(k - temp.left.val)) return true;
                stack.push(temp.left);
                set.add(temp.left.val);
            }
            if (temp.right != null) {
                if (set.contains(k - temp.right.val)) return true;
                stack.push(temp.right);
                set.add(temp.right.val);
            }
        }
        return false;
    }

    Set<Integer> sets = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (sets.contains(k - root.val)) {
            return true;
        }
        sets.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }


}
