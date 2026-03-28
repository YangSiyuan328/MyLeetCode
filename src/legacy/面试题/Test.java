package 面试题;

import java.util.Scanner;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: 面试题
 * @Author: 杨思远
 * @CreateTime: 2024-04-10  21:37
 * @Description: TODO
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入天平的平衡指数：");
        int m = sc.nextInt();
        System.out.println("请输入你要比较的球数：");
        int n = sc.nextInt() + 1;
        System.out.println("请输入模式： 1.遍历模式 2.指定模式");
        int type = sc.nextInt();
        if (type == 1) {
            for (int i = 0; i < n; i++) {
                System.out.println("getMin(" + i + "," + m + ") = " + getMin(i, m));
            }
        } else if (type == 2) {
            System.out.println("getMin(" + n + "," + m + ") = " + getMin(n, m));
        }
    }

    private static int getMin(int n, int m) {
        if (n <= 1) return 0;
        if (n <= m + 1) return 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m + 1; i++) {
            dp[i] = 1;
        }
        dp[m + 2] = 2;
        for (int i = m + 3; i <= n; i++) {
            dp[i] = dp[(i + m) / (m + 1)] + 1;
        }
        return dp[n];
    }
}
