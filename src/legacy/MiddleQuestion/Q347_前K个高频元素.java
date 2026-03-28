package MiddleQuestion;

import java.util.*;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-12  18:39
 * @Description: TODO
 * @Version: 1.0
 */
public class Q347_前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println("topKFrequent(nums,2) = " + Arrays.toString(topKFrequent(nums, 2)));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

}
