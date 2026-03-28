package 剑指Offer;

import java.util.HashMap;

public class Offer35_复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // cur 老
            // map.get(cur) 新
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        //        // copy node and link to every node
        //        // 1 -> 2
        //        // 1 -> 1' -> 2
        while (cur != null) {
            // cur 老   next 老的下一个
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand
        // 1 -> 1' -> 2 -> 2'
        while (cur != null) {
            // cur 老
            // cur.next  新 copy
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        // head  head.next
        Node res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

}
