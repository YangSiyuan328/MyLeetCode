package DifficultQuestion;

public class Q1220_统计元音字母序列的数目 {


    public int countVowelPermutation1(int n) {
        final int MOD = 1000000007;
        long[][] dp = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) + dp[i - 1][4];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][1] + dp[i - 1][3];
            dp[i][3] = dp[i - 1][2];
            dp[i][4] = dp[i - 1][2] + dp[i - 1][3];
            for (int j = 0; j < 5; j++) {
                dp[i][j] %= MOD;
            }
        }
        int res = 0;
        for (int j = 0; j < 5; j++) {
            res += dp[n][j];
            res %= MOD;
        }
        return res;
    }

}
