package MiddleQuestion;

public class Q240_搜索二维矩阵II {

    // 从右上角看是搜索二叉树
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }

}
