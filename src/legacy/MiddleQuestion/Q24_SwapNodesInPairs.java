package MiddleQuestion;

import java.util.ArrayList;

public class Q24_SwapNodesInPairs {
    public static void main(String[] args) {
        Q24_SwapNodesInPairs Q = new Q24_SwapNodesInPairs();
        System.out.println(Q.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
        System.out.println(Q.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))))));
        System.out.println(Q.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5,new ListNode(6))))))));
        System.out.println(Q.swapPairs(null));
        System.out.println(Q.swapPairs(new ListNode(1)));
        System.out.println(Q.swapPairs(new ListNode(1, new ListNode(3))));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3;
        ListNode p4;
        head = p2;
        if (p2.next != null && p2.next.next != null) {
            p3 = p2.next;
            p4 = p3.next;
            while (true) {
                p1.next = p4;
                p2.next = p1;
                p1 = p3;
                p2 = p4;
                if (p4.next == null || p4.next.next == null) {
                    p3.next = p4.next;
                    p4.next = p3;
                    return head;
                }
                p3 = p4.next;
                p4 = p4.next.next;
            }
        } else {
            p1.next = p2.next;
            p2.next = p1;
        }
        return head;
    }


    // 数组实现
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ArrayList<ListNode> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        for (int i = 1; i < arr.size(); i += 2) {
            cur = arr.get(i - 1);
            arr.set(i - 1, arr.get(i));
            arr.set(i, cur);
        }
        head = arr.get(0);
        cur = head;
        for (int i = 1; i < arr.size(); i++) {
            cur.next = arr.get(i);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}
