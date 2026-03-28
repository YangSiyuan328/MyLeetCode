package MiddleQuestion;

public class Q2028_找出缺失的观测数据 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int differ = m * mean - sum + n * mean;
        // 避免大于6
        if (differ > n * 6) return new int[]{};
        // 避免为负数
        if (differ < n) return new int[]{};
        int num = differ / n;
        int mod = differ % n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = num;
        }
        while (mod > 0) {
            ans[mod--]++;
        }
        return ans;
    }

}
