package MiddleQuestion;

public class Q19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Q19_RemoveNthNodeFromEndOfList Q = new Q19_RemoveNthNodeFromEndOfList();
        System.out.println(Q.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(Q.removeNthFromEnd(new ListNode(1), 1));
        System.out.println(Q.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
        System.out.println(Q.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            if (fast.next != null) {
                fast = fast.next;
                n--;
            } else {
                return head.next;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
