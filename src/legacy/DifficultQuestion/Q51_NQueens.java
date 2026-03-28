package DifficultQuestion;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Q51_NQueens {

    public static void main(String[] args) {
        Q51_NQueens Q = new Q51_NQueens();
        List<List<String>> lists = Q.solveNQueens(4);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        int[] record = new int[n];
        process(0, record, n, res);
        return res;
    }

    // i 目前的行数  [0,n-1]
    // j 列数
    private void process(int i, int[] record, int n, List<List<String>> res) {
        if (i == n) {
            res.add(recordToList(record, n));
        }
        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                process(i + 1, record, n, res);
            }
        }
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    private List<String> recordToList(int[] record, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (record[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }



}
