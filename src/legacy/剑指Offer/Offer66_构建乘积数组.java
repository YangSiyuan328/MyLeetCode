package 剑指Offer;

import java.util.Arrays;

public class Offer66_构建乘积数组 {

    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= a[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }

    public static int[] constructArr1(int[] a) {
        if (a == null || a.length <= 1) return a;
        int l = a.length;
        int[] pre = new int[l];
        int[] pre2 = new int[l];
        int[] res = new int[l];
        pre[0] = a[0];
        pre2[l - 1] = a[l - 1];
        for (int i = 1; i < l; i++) {
            pre[i] = pre[i - 1] * a[i];
            pre2[l - 1 - i] = pre2[l - i] * a[l - 1 - i];
        }
        res[0] = pre2[1];
        res[l - 1] = pre[l - 2];
        for (int i = 1; i < l - 1; i++) {
            res[i] = pre[i - 1] * pre2[i + 1];
        }
        return res;
    }

}
