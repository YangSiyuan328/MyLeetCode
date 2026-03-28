package DifficultQuestion;

import DifficultQuestion.Q51_NQueens;

import java.util.List;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: DifficultQuestion.Q37
 * @Author: 杨思远
 * @CreateTime: 2024-03-19  14:15
 * @Description: TODO
 * @Version: 1.0
 */
public class Q37_解数独 {
    public static void main(String[] args) {
        Q37_解数独 Q = new Q37_解数独();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Q.solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] bucket = new boolean[9][10];
        initMaps(board, row, col, bucket);
        process(board, 0, 0, row, col, bucket);
    }


    private void initMaps(char[][] board, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bid = 3 * (i / 3) + (j / 3);
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
    }

    private boolean process(char[][] board, int i, int j, boolean[][] row, boolean[][] col, boolean[][] bucket) {
        if (i == 9) {
            return true;
        }
        // 当离开 (i,j) => (nexti,nextj)
        int nexti = j != 8 ? i : i + 1;
        int nextj = j != 8 ? j + 1 : 0;
        if (board[i][j] != '.') {
            return process(board, nexti, nextj, row, col, bucket);
        } else {
            // 可以尝试 1~9
            int bid = 3 * (i / 3) + (j / 3);
            for (int num = 1; num <= 9; num++) { // 尝试没一个数字 1-9
                if ((!row[i][num]) && (!col[j][num]) && (!bucket[bid][num])) {
                    // 可以尝试 num
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                    board[i][j] = (char) (num + '0');
                    if (process(board, nexti, nextj, row, col, bucket)) {
                        return true;
                    }
                    row[i][num] = false;
                    col[j][num] = false;
                    bucket[bid][num] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }


}


