package leetcode.problems.lc1005_maximize_sum_of_array_after_k_negations;

import java.util.PriorityQueue;

class Solution_1 {

    public static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            minHeap.add(num);
        }
        while (!minHeap.isEmpty() && k-- > 0) {
            int minNum = minHeap.poll();
            if (minNum == 0) break;
            sum -= minNum << 1;
            minHeap.add(-minNum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}