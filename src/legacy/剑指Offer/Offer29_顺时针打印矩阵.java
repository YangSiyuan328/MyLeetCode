package 剑指Offer;

public class Offer29_顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        int index = 0;
        int[] res = new int[matrix.length * matrix[0].length];
        while (tR <= dR & tC <= dC) {
            index = printEdge(matrix, res, index, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private static int printEdge(int[][] m, int[] res, int index, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res[index++] = m[tR][i];
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res[index++] = m[i][tC];
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                res[index++] = m[tR][curC++];
            }
            while (curR != dR) {
                res[index++] = m[curR++][dC];
            }
            while (curC != tC) {
                res[index++] = m[dR][curC--];
            }
            while (curR != tR) {
                res[index++] = m[curR--][tC];
            }
        }
        return index;
    }

}
