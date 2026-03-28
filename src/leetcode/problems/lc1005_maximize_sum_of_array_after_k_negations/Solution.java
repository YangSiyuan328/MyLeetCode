package leetcode.problems.lc1005_maximize_sum_of_array_after_k_negations;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    public static int largestSumAfterKNegations(int[] nums, int k) {

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}