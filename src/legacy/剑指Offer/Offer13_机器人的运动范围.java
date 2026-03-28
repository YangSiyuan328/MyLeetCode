package 剑指Offer;

public class Offer13_机器人的运动范围 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n
                || (x / 10 + x % 10 + y / 10 + y % 10) > k || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        return dfs(x + 1, y, m, n, k, visited) + dfs(x, y + 1, m, n, k, visited) + 1;
    }

    private static int getSum(int x, int y) {
        return (x + y) / 10 + x % 10 + y % 10;
    }
}
