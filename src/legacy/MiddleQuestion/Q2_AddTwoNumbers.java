package MiddleQuestion;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q2_AddTwoNumbers {
    public static void main(String[] args) {
        Q2_AddTwoNumbers Q = new Q2_AddTwoNumbers();
        ListNode l1 = Q.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
        ListNode l2 = Q.addTwoNumbers(new ListNode(0), new ListNode(0));
        ListNode l3 = Q.addTwoNumbers(new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))), new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode.show(l1);
        ListNode.show(l2);
        ListNode.show(l3);
        System.out.println(l3);
    }

    // 自己暴力
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null ) return l2;
        if (l2 == null) return l1;
        ListNode res;
        if (l1.val + l2.val < 10) {
            res = new ListNode(l1.val + l2.val);
        } else {
            res = new ListNode(l1.val + l2.val - 10);
            if (l1.next != null) {
                if(l2.next != null){
                    l1.next.val++;
                }else {
                    l2.next = new ListNode(1);
                }
            } else {
                l1.next = new ListNode(1);
            }
        }
        res.next = addTwoNumbers(l1.next, l2.next);
        return res;
    }*/
    // 大佬循环
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            ListNode sumNode;
            if (sumVal > 9) {
                carry = 1;
                sumNode = new ListNode(sumVal-10);
            }else {
                carry = 0;
                sumNode = new ListNode(sumVal % 10);
            }
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return root.next;
    }*/
    // 大佬递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return this.addTwoNumbers2(l1, l2, 0);
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2, int a) {
        if (l1 == null && l2 == null) return a == 0 ? null : new ListNode(a);
        if (l1 != null) {
            a += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            a += l2.val;
            l2 = l2.next;
        }
        return new ListNode(a % 10, addTwoNumbers2(l1, l2, a / 10));
    }
}

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
