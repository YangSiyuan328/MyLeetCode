package 剑指Offer;

public class Offer24_反转链表 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5}, 5, 0);
        Offer24_反转链表 Q = new Offer24_反转链表();
        System.out.println(Q.reverseList(listNode));
    }

    //迭代
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
