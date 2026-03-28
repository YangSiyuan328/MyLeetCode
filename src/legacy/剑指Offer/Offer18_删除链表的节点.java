package 剑指Offer;

public class Offer18_删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
