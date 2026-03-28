package DifficultQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q52_NQueensII {

    public static void main(String[] args) {
        Q52_NQueensII Q = new Q52_NQueensII();
        System.out.println("Q.totalNQueens(4) = " + Q.totalNQueens(8));
        System.out.println("Q.totalNQueens1(4) = " + Q.totalNQueens1(8));
    }

    // 请不要超过32皇后问题
    public int totalNQueens(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0, 0);
    }

    private static int process(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        // pos 中所有是1的位置，是你可以去尝试皇后的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }

    //   ====================================================================================================
    public int totalNQueens1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    // i 目前的行数  [0,n-1]
    // j 列数
    private int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                sum += process(i + 1, record, n);
            }
        }
        return sum;
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

}
