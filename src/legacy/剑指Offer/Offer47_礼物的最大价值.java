package 剑指Offer;

class Offer47_礼物的最大价值 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        //int[][] grid = new int[][]{{1, 2, 5}, {3, 2, 1}};

        Offer47_礼物的最大价值 o = new Offer47_礼物的最大价值();
        System.out.println(o.maxValue1(grid));
    }

    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int maxValue1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return process(grid, 0, 0, dp);
    }

    private int process(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        int inRight = process(grid, i, j + 1, dp) + grid[i][j];
        int inDown = process(grid, i + 1, j, dp) + grid[i][j];
        dp[i][j] = Math.max(inRight, inDown);
        return dp[i][j];
    }
}
