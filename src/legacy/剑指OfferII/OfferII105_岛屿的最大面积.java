package 剑指OfferII;

public class OfferII105_岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int S = process(grid, i, j);
                    res = Math.max(S,res);
                }
            }
        }
        return res;
    }

    private static int process(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return process(grid, i - 1, j) +
                process(grid, i + 1, j) +
                process(grid, i, j - 1) +
                process(grid, i, j + 1) + 1;

    }
}
