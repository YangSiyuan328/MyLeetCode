package SimpleQuestion;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Q21_MergeTwoSortedLists Q = new Q21_MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        /*while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            System.out.println(l2.val);
            l2 = l2.next;
        }
*/
        ListNode l3 = Q.mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
        /*
        while (l4 != null) {
            System.out.println(l4.val);
            l4 = l4.next;
        }
*/

    }

    // 大佬解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode l = l1.val < l2.val ? l1 : l2;
        l.next = mergeTwoLists(l.next, l1.val >= l2.val ? l1 : l2);
        return l;
    }



/*
    // 暴力解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode l3;
        ListNode l4;
        if (l1.val <= l2.val) {
            l4 = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            l4 = new ListNode(l2.val);
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l4 = new ListNode(l1.val, l4);
                l1 = l1.next;
            } else {
                l4 = new ListNode(l2.val, l4);
                l2 = l2.next;
            }
        }
        if (l1 != null){
            while (l1 != null) {
                l4 = new ListNode(l1.val, l4);
                l1 = l1.next;
            }
        }else {
            while (l2 != null) {
                l4 = new ListNode(l2.val, l4);
                l2 = l2.next;
            }
        }

        l3 = new ListNode(l4.val);
        l4 = l4.next;
        while (l4 != null) {
            l3 = new ListNode(l4.val, l3);
            l4 = l4.next;
        }
        return l3;
    }*/
}