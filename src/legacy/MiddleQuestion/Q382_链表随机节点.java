package MiddleQuestion;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q382_链表随机节点 {

    class Solution {
        ArrayList<Integer> list = null;

        public Solution(ListNode head) {
            list = new ArrayList<Integer>();
            ListNode index = head;
            while (index != null) {
                list.add(index.val);
                index = index.next;
            }
        }

        public int getRandom() {
            int size = list.size();
            return list.get((int) (Math.random() * size));
        }
    }

}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */