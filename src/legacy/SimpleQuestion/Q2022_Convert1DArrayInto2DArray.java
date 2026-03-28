package SimpleQuestion;

import java.util.Arrays;

public class Q2022_Convert1DArrayInto2DArray {


    public static void main(String[] args) {
        int[][] ints = construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        System.out.println(Arrays.deepToString(ints));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length == 0 || original.length != m * n) return new int[0][0];
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[i * m + j];
            }
        }
        return res;
    }
}
