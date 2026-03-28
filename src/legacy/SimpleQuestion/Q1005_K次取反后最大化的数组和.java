package SimpleQuestion;

import java.util.*;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-22  15:46
 * @Description: TODO
 * @Version: 1.0
 */
public class Q1005_K次取反后最大化的数组和 {

    public static void main(String[] args) {
        Q1005_K次取反后最大化的数组和 Q = new Q1005_K次取反后最大化的数组和();
        int[] num1 = {4, 2, 3};
        System.out.println("Q.largestSumAfterKNegations(num1, 1) = " + Q.largestSumAfterKNegations(num1, 1));
        int[] num2 = {3, -1, 0, 2};
        System.out.println("Q.largestSumAfterKNegations(num2, 3) = " + Q.largestSumAfterKNegations(num2, 3));
        int[] num3 = {2, -3, -1, 5, -4};
        System.out.println("Q.largestSumAfterKNegations(num3, 2) = " + Q.largestSumAfterKNegations(num3, 2));

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (k-- > 0) {
            for (Integer num : map.keySet()) {
                sum -= num << 1;
                Integer count = map.get(num);
                // 去除当前
                if (count > 1) {
                    map.put(num, count - 1);
                } else {
                    // count == 1
                    map.remove(num);
                }
                // 新增相反
                map.put(-num, map.getOrDefault(-num, 0) + 1);
                break;
            }
        }
        return sum;
    }

}
