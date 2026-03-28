package SimpleQuestion;

/**
 * @Description: <a href="https://leetcode.cn/problems/reverse-linked-list/description/"/>
 */
public class Q206_ReverseLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseList(head.next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 非递归实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = cur;
            cur = head;
            head = next;
        }
        return head;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        return null;
    }

    public ListNode swapLeftAndRightList(ListNode head, ListNode tail) {
        if (head == null || head.next == null || tail == null) return head;
        ListNode slowp = head, fastp = head.next.next, tailNext = tail.next, l, r;
        tail.next = null;
        while (fastp.next != null && fastp.next.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }
        r = swapLeftAndRightList(slowp.next, fastp);
        slowp.next = null;
        l = swapLeftAndRightList(head, slowp);
        return mergeNode(l, r);
    }

    public ListNode mergeNode(ListNode l, ListNode r) {
        ListNode slowp = l, fastp = l.next.next, tailNext = r.next;
        r.next = null;
        while (fastp.next != null && fastp.next.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }
        return null;
    }

}
