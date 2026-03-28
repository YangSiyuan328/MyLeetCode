package 剑指Offer;

public class Offer52_两个链表的第一个公共节点 {

    public static void main(String[] args) {

    }

    // 简洁版
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }

        return tempA;
    }

    // 复杂
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA;
        ListNode help;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        p = headB;
        while (p != null) {
            p = p.next;
            length--;
        }
        if (length < 0) { // B比A长
            p = headB;
            help = headA;
            while (length != 0) {
                p = p.next;
                length++;
            }
        } else { // A比B长
            p = headA;
            help = headB;
            while (length != 0) {
                p = p.next;
                length--;
            }
        }
        while (p != help) {
            p = p.next;
            help = help.next;
        }
        return p;
    }
}
