package 剑指OfferII;

import java.util.Random;

public class OfferII024_反转链表 {

    public static void main(String[] args) {
        Random ran = new Random();
        int[] arr = new int[ran.nextInt(15) + 1];
        for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
            arr[i] = ran.nextInt(100);
        }
        ListNode node = new ListNode(arr, arr.length, 0);
        OfferII024_反转链表 O = new OfferII024_反转链表();
        System.out.println(node);
        ListNode reverse = O.reverseList(node);
        System.out.println(reverse);
        System.out.println(O.reverseList1(reverse));

    }

    //非递归
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

}
