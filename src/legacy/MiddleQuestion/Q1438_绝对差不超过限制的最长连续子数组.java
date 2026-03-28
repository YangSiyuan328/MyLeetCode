package MiddleQuestion;

import java.util.LinkedList;

public class Q1438_绝对差不超过限制的最长连续子数组 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
    }

    public static int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) return 0;
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < nums.length) {
            while (R < nums.length) {
                while (!qMin.isEmpty() && nums[qMin.peekLast()] >= nums[R]) {
                    qMin.pollLast();
                }
                qMin.addLast(R);
                while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[R]) {
                    qMax.pollLast();
                }
                qMax.addLast(R);
                if (nums[qMax.getFirst()] - nums[qMin.getFirst()] > limit) {
                    break;
                }
                R++;
            }
            res = Math.max(res, R - L);
            if (qMin.peekFirst()==L){
                qMin.pollFirst();
            }
            if (qMax.peekFirst()==L){
                qMax.pollFirst();
            }
            L++;
        }
        return res;
    }

}
