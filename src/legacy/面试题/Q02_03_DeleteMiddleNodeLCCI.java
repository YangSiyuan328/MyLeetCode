package 面试题;

public class Q02_03_DeleteMiddleNodeLCCI {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
