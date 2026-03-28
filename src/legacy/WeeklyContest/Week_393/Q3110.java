package WeeklyContest.Week_393;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: WeeklyContest.Week_393
 * @Author: 杨思远
 * @CreateTime: 2024-04-13  21:31
 * @Description: TODO
 * @Version: 1.0
 */
public class Q3110 {

    public static void main(String[] args) {
        Q3110 obj = new Q3110();
        int[] nums = {4, 2, 9, 5, 3};
        System.out.println("obj.maximumPrimeDifference(nums) = " + obj.maximumPrimeDifference(nums));

    }


    public int maximumPrimeDifference(int[] nums) {
        Map<Integer, Boolean> primeMap = new HashMap<>();
        int minIndex = nums.length;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (primeMap.getOrDefault(num,false) || isPrime(num)) {
                minIndex = Math.min(i, minIndex);
                maxIndex = Math.max(i, maxIndex);
                primeMap.put(num, true);
            }
        }
        return maxIndex == -1 ? 0 : maxIndex - minIndex;
    }

    /**
     * 判断一个数是否为素数
     *
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
