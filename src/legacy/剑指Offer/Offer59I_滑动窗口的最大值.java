package 剑指Offer;

import java.util.LinkedList;

public class Offer59I_滑动窗口的最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length == 0) return new int[]{};
        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() == i - k) {
                qMax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[qMax.peekFirst()];
            }
        }
        return res;
    }

}
