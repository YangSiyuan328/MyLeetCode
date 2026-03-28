package DifficultQuestion;

import java.util.Arrays;
import java.util.Map;

public class Q407_接雨水II {

    public static void main(String[] args) {
        int[][] h = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        Q407_接雨水II Q = new Q407_接雨水II();
        System.out.println("Q.trapRainWater(h) = " + Q.trapRainWater(h));
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
            }
        }

        int ans = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans += dp[i][j] - heightMap[i][j];
            }
        }
        return ans;
    }

}
