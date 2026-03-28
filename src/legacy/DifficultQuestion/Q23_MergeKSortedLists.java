package DifficultQuestion;

public class Q23_MergeKSortedLists {
    public static void main(String[] args) {
        Q23_MergeKSortedLists Q = new Q23_MergeKSortedLists();
        ListNode[] lists = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))};
        System.out.println(Q.mergeKLists(lists));
        System.out.println(Q.mergeKLists(new ListNode[]{}));
        System.out.println(Q.mergeKLists(new ListNode[]{new ListNode()}));
        System.out.println(Q.mergeKLists(new ListNode[]{new ListNode(), new ListNode()}));
        System.out.println(Q.mergeKLists(new ListNode[]{new ListNode(), new ListNode(1)}));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int l = lists.length;
        while (l != 1) {
            for (int i = 0; i < (l + 1) >> 1; i++) {
                if (i != l - 1 - i) {
                    lists[i] = mergeList(lists[i], lists[l - 1 - i]);
                } else {
                    lists[i - 1] = mergeList(lists[i], lists[i - 1]);
                }
            }
            l >>= 1;
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode l, ListNode r) {
        ListNode tmpHead = new ListNode(-1);
        ListNode p = tmpHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return tmpHead.next;
    }

}
