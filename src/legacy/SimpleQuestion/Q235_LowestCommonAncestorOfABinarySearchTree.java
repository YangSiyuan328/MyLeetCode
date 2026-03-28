package SimpleQuestion;


import java.util.HashMap;
import java.util.HashSet;

public class Q235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(head, null);
        addMap(head, map);
        HashSet<TreeNode> set = new HashSet<>();
        while (p!=null) {
            set.add(p);
            p = map.get(p);
        }
        while (!set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }

    public static void addMap(TreeNode head, HashMap<TreeNode, TreeNode> map) {
        if (head.left != null) {
            map.put(head.left, head);
            addMap(head.left, map);
        }
        if (head.right != null) {
            map.put(head.right, head);
            addMap(head.right, map);
        }
    }


    public TreeNode lowestCommonAncestor1(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null) return head;
        if (head == p || head == q) {
            return head == p ? p : q;
        }

        TreeNode pIndex = p.val < head.val ? lowestCommonAncestor(head.left, p, q) : lowestCommonAncestor(head.right, p, q);
        TreeNode qIndex = q.val < head.val ? lowestCommonAncestor(head.left, p, q) : lowestCommonAncestor(head.right, p, q);
        if (pIndex != null && qIndex != null) {
            return pIndex == qIndex ? pIndex : head;
        } else if (pIndex != null) {
            return pIndex;
        } else return qIndex;
    }

}
