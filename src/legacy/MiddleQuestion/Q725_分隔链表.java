package MiddleQuestion;


public class Q725_分隔链表 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) return new ListNode[k];
        ListNode[] listNode = new ListNode[k];
        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        ListNode first = head;
        ListNode last = head;
        int width = length % k; //3
        int depth = length / k; //0
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < depth - 1; j++) {
                last = last == null ? null : last.next;
            }
            if (i < width && depth != 0) {
                last = last == null ? null : last.next;
            }
            listNode[i] = first;
            if (last == null) {
                first = null;
            } else {
                first = last.next;
                last.next = null;
            }
            last = first;
        }
        return listNode;
    }

}
