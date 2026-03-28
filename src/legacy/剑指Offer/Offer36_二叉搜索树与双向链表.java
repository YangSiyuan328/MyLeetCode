package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

public class Offer36_二叉搜索树与双向链表 {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (head == null) return null;
        dfs(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node cur) {
        if (head == null) return;
        dfs(cur.left);

        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }


    // 暴力
    public Node treeToDoublyList1(Node head) {
        if (head == null) return null;
        ArrayList<Node> list = new ArrayList<>();
        in(head, list);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).right = i == list.size() - 1 ? list.get(0) : list.get(i + 1);
            list.get(i).left = i == 0 ? list.get(list.size() - 1) : list.get(i - 1);
        }
        return list.get(0);
    }

    private static void in(Node head, ArrayList<Node> list) {
        if (head == null) return;
        in(head.left, list);
        list.add(head);
        in(head.right, list);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

}

