package SimpleQuestion;

public class Q70_ClimbingStairs {

    //for test
    public static void main(String[] args) {
        for (int i = 0; i < 46; i++) {
            int ans1 = climbStairs(2);
            int ans2 = Solution.climbStairs(2);
            if (ans1 != ans2) {
                System.out.println("false");
                return;
            }
        }
        System.out.println(Solution.climbStairs(3));
        System.out.println("all case true");
    }

    //
    public static int climbStairs(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1]; // 1 ~ n
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 暴力递归
    public int climbStairs1(int n) {
        return process(n);
    }

    private static int process(int n) {
        if (n <= 0) return n == 0 ? 1 : 0;
        return process(n - 1) + process(n - 2);
    }

    // 矩阵乘法+快速幂 解决斐波那契数列问题
    static class Solution {
        public static int climbStairs(int n) {
            n++;
            if (n < 1) return 0;
            if (n == 1 || n == 2) return 1;
            // [1, 1]
            // [1, 0]
            int[][] base = {{1, 1}, {1, 0}};
            int[][] res = matrixPower(base, n - 2);
            return res[0][0] + res[1][0];
        }

        // 快速幂
        public static int[][] matrixPower(int[][] m, int p) {
            int[][] res = new int[m.length][m[0].length];
            for (int i = 0; i < res.length; i++) {
                res[i][i] = 1;
            }

            // res = 矩阵中的1
            int[][] tmp = m;// 矩阵1次方
            for (; p != 0; p >>= 1) {
                if ((p & 1) != 0) {
                    res = multiMatrix(res, tmp);
                }
                tmp = multiMatrix(tmp, tmp);
            }
            return res;
        }

        // 两个矩阵乘完之后的结果返回
        public static int[][] multiMatrix(int[][] m1, int[][] m2) {
            int[][] res = new int[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    for (int k = 0; k < m2.length; k++) {
                        res[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
            return res;
        }
    }

}
