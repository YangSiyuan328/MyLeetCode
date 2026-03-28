package SimpleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-04-22  01:34
 * @Description: <a href="https://leetcode.cn/problems/remove-linked-list-elements/description/"/>
 * @Version: 1.0
 */
public class Q203_移除链表元素 {


    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            if (cur.val == val) {
                temp.next = cur.next;
            } else {
                temp = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
