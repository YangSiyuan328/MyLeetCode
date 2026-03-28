package MiddleQuestion;

import java.util.Arrays;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-29  16:04
 * @Description: TODO
 * @Version: 1.0
 */
public class Q63_不同路径II {

    public static void main(String[] args) {
        System.out.println("uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}) = " + uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println("uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}) = " + uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}));
        System.out.println("uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}) = " + uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp数组
        int[] dp = new int[n];
        // 第一排变成 1
        for (int i = 0; i < n; i++) {
            // 如果有障碍物，右侧均不可达
            if (obstacleGrid[0][i] == 1) break;
            dp[i] = 1;
        }
        // dp展开
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一列
                if (j == 0) {
                    // 如果有障碍物，变成不可达
                    if (obstacleGrid[i][0] == 1) dp[j] = 0;
                    // 如果没有障碍物，也不需要变更
                    // 1.之前也没有障碍物，初始可达是1
                    // 2.如果之前有障碍物，已经不可达，之前是已经变成0了
                } else {
                    // 如果有障碍物，变成不可达
                    if (obstacleGrid[i][j] == 1) dp[j] = 0;
                        // 如果没有障碍物
                    else dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    if (obstacleGrid[i][0] == 1) dp[j] = 0;
                } else {
                    dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

}
