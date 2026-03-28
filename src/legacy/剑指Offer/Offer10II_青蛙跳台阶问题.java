package 剑指Offer;

class Offer10II_青蛙跳台阶问题 {

    public static void main(String[] args) {
        Offer10II_青蛙跳台阶问题 o = new Offer10II_青蛙跳台阶问题();
        System.out.println(o.numWays(2));
        System.out.println(o.numWays(7));
        System.out.println(o.numWays(0));
        System.out.println(o.numWays(50));
    }

    final static int MOD = 1000000007;

    // 动态规划
    public int numWays(int n) {
        if (n <= 1) return 1;
        int f0 = 1, f1 = 1, tmp;
        for (int i = 0; i < n - 1; i++) {
            tmp = f1;
            f1 = f0 + f1;
            f0 = tmp;
            f1 = f1 % 1000000007;
        }
        return f0;
    }

    // 记忆化搜索
    public int numWays2(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < n - 1; i++) {
            dp[i + 2] = (dp[i] + dp[i + 1]) % MOD;
        }
        return dp[n];
    }

    public int numWays1(int n) {
        return process(n);
    }


    private int process(int n) {
        if (n <= 0) {
            return n == 0 ? 1 : 0;
        }
        int case1 = process(n - 1);
        int case2 = process(n - 2);
        return (case1 + case2) % MOD;
    }

}
