package 剑指Offer;

public class Offer27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode head) {
        return symmetry(head);
    }

    private TreeNode symmetry(TreeNode head) {
        if (head == null) return null;
        TreeNode temp = head.left;
        head.left = symmetry(head.right);
        head.right = symmetry(temp);
        return head;
    }

}
