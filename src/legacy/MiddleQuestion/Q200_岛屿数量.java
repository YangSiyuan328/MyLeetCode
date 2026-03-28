package MiddleQuestion;

public class Q200_岛屿数量 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    process(grid, i, j);
                }
            }
        }
        return islands;
    }

    private static void process(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        process(grid, i - 1, j);
        process(grid, i + 1, j);
        process(grid, i, j - 1);
        process(grid, i, j + 1);
    }
}
