package 剑指Offer;

import java.util.Arrays;
import java.util.HashMap;

public class Offer07_重建二叉树 {

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);

    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                                     // 递归终止
        TreeNode node = new TreeNode(preorder[root]);                      // 建立根节点
        int i = dic.get(preorder[root]);                                   // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);                // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right);    // 开启右子树递归
        return node;
    }

    // 递归
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) return null;
        int rootVal = preorder[0], rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + rootIndex, len), Arrays.copyOfRange(inorder, rootIndex + 1, len));
        return root;
    }

}
