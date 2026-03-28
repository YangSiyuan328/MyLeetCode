package 剑指Offer;

import java.util.ArrayList;

public class Offer22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slowp = head;
        ListNode fastp = head;
        while (fastp != null && k > 0) {
            k--;
            fastp = fastp.next;
        }
        while (fastp != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }
        return slowp;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode cur = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        return list.get(list.size() - k);
    }

}
