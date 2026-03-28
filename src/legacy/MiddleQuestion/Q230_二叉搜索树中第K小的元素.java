package MiddleQuestion;

import java.util.LinkedList;

public class Q230_二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }


    /**
     * 查找左子树节点个数为leftN,如果K<=leftN,则所查找节点在左子树上.
     * 若K=leftN+1,则所查找节点为根节点
     * 若K>leftN+1,则所查找节点在右子树上,按照同样方法查找右子树第K-leftN个节点
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        int leftN = findChild(root.left);
        if (leftN + 1 == k) return root.val;
        else if (k <= leftN) {
            return kthSmallest(root.left, k);
        } else return kthSmallest(root.right, k - leftN - 1);
    }

    /**
     * 查找子节点个数
     *
     * @param root
     * @return
     */
    public int findChild(TreeNode root) {
        if (root == null) return 0;
        return findChild(root.left) + findChild(root.right) + 1;
    }

}
