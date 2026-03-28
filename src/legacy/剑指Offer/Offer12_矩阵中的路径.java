package 剑指Offer;

import java.util.function.IntFunction;

public class Offer12_矩阵中的路径 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        char[] str = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, str, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] str, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || str[start] != board[i][j] || visited[i][j]) {
            return false;
        }
        if (start == str.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean ans = false;
        ans = dfs(board, str, visited, i + 1, j, start + 1)
                || dfs(board, str, visited, i - 1, j, start + 1)
                || dfs(board, str, visited, i, j + 1, start + 1)
                || dfs(board, str, visited, i, j - 1, start + 1);
        visited[i][j] = false;
        return ans;
    }


}
