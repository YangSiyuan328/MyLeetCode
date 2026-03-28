package SimpleQuestion;

public class Q1290_ConvertBinaryNumberInALinkedListToInteger {


    public int getDecimalValue1(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) + head.val;
            head = head.next;
        }
        return ans;
    }

    public int getDecimalValue(ListNode head) {
        return getValue(head, 0);
    }

    public int getValue(ListNode head, int ans) {
        if (head == null) return ans;
        return getValue(head.next,(ans << 1) + head.val);
    }

}
