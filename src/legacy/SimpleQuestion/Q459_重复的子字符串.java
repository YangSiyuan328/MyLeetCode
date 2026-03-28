package SimpleQuestion;

public class Q459_重复的子字符串 {
    public int waysToChange(int n) {
        if (n <= 0) return 0;
        int[] tokens = new int[]{1, 5, 10, 25};
        return process1(tokens, 0, n);
    }

    public static int process1(int[] arr, int index, int rest) {
        if (index == arr.length) return rest == 0 ? 1 : 0;
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process1(arr, index + 1, rest - (zhang * arr[index]));
        }
        return ways;
    }

    // 记忆化搜索
    public static int ways2(int[] arr, int aim) {
        if (aim <= 0) return 0;
        int[] tokens = new int[]{1, 5, 10, 25};
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(tokens, 0, aim, dp);
    }

    public static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) return dp[index][rest];
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process2(arr, index + 1, rest - (zhang * arr[index]), dp);
        }
        dp[index][rest] = ways;
        return ways;
    }

    public static int waysdp(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }
}
