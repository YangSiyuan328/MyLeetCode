package 剑指Offer;

public class Offer16_数值的整数次方 {

    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));
    }

    // 奇偶递推公式 + 位运算
    public static double myPow(double x, int n) {

        if (n == 0 || x == 1) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;

        double res = myPow(x, n >> 1);
        res *= res;

        if ((n & 1) == 1 && n > 0) res *= x;
        if ((n & 1) == 1 && n < 0) res /= x;

        return res;
    }

}
