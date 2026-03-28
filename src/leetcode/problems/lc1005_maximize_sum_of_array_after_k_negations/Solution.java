package common.lc1005_maximize_sum_of_array_after_k_negations;

import java.util.PriorityQueue;

class Solution {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        if (heap.isEmpty()) return sum;
        int minNum = heap.poll();
        if (minNum >= 0) {
            return sum - (minNum << 1) * (k & 1);
        }
        int minNumObs = -minNum;
        // -5 -3 -1 0
        while (minNum < 0 && k-- > 0) {
            sum -= minNum * 2;
            minNum = heap.poll();
        }


        return 0;
    }

    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }


    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}