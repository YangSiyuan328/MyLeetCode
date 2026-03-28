package 剑指Offer;

import java.util.ArrayList;

public class Offer06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode index = head;
        while (index != null) {
            length++;
            index = index.next;
        }
        int[] ans = new int[length];
        index = head;
        for (int i = length - 1; i >= 0; i--) {
            ans[i] = index.val;
            index = index.next;
        }
        return ans;
    }

}
