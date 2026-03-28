package MiddleQuestion;

public class Q430_扁平化多级双向链表 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    /**
     * 思路：深度优先遍历，如果有 child 先遍历 child，再将 next 放在 child 最后面
     * @param head 开始节点：可以是头结点，也可以是某一链表的 child 节点
     * @return 返回该链表中最后一个不为空的节点
     */
    public Node dfs(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur.next != null) {
            if (cur.child != null) {
                Node flatten = dfs(cur.child);
                flatten.next = cur.next;
                flatten.next.prev = flatten;
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            cur = cur.next;
        }
        if (cur.child != null) {
            cur.next = cur.child;
            cur.next.prev = cur;
            cur.child = null;
            cur = dfs(cur.next);
        }
        return cur;
    }



}
