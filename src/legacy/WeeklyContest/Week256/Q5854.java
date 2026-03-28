package WeeklyContest.Week256;

import java.util.LinkedList;
import java.util.Stack;

public class Q5854 {

    public int minimumDifference(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int L = 0;
        int R = 0;
        int curDif = 0;
        // [L..R) -> [0,0) 窗口内无数 [1,1)
        // [0,1) -> [0~0]
        int res = 0;
        while (L < nums.length) { // L是开头位置，尝试每一个开头
            // 如果此时窗口的开头是L,下面的while工作:R向右扩到违规为止
            while (R < nums.length) { // R是最后一个达标位置的再下一个
                while (!qmin.isEmpty() && nums[qmin.peekLast()] >= nums[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                // R -> arr[R],
                while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);
                if (nums[qmax.getFirst()] - nums[qmin.getFirst()] > k) {
                    break;
                }
                R++;
            }
            // R是最后一个达标位置的再下一个，第一个违规的位置
            res += R - L;
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            L++;
        }
        return res;
    }

}
