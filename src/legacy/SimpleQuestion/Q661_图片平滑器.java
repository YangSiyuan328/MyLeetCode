package SimpleQuestion;

import java.util.Arrays;

public class Q661_图片平滑器 {
    public static void main(String[] args) {
        int[][] img = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] img2 = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] img3 = {{3}};
        Q661_图片平滑器 Q = new Q661_图片平滑器();
        System.out.println(Arrays.deepToString(Q.imageSmoother(img3)));
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        //if (m == 1 && n == 1) return img;
        int[][] rSum = new int[m][n];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(img[i], 0, rSum[i], 0, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    rSum[i][j] += img[i][Math.min(n - 1, 1)];
                } else if (j == n - 1) {
                    rSum[i][j] += img[i][j - 1];
                } else {
                    rSum[i][j] += img[i][j - 1] + img[i][j + 1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = rSum[i][j];
                int count = 1;
                if (i > 0) {
                    ans[i][j] += rSum[i - 1][j];
                    count++;
                }
                if (i < m - 1) {
                    ans[i][j] += rSum[i + 1][j];
                    count++;
                }
                count *= j > 0 && j < n - 1 ? 3 : 2;
                ans[i][j] /= count;
            }
        }
        return ans;
    }

}
