package 剑指Offer;

public class Offer17_打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int cut = 1;
        for (int i = 0; i < n; i++) {
            cut *= 10;
        }
        int[] res = new int[cut - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
