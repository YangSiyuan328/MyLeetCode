package MiddleQuestion;

public class Q50_Pow {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if (x == 0 || x == 1||n==1) return x;
        if (n == 0) return 1;
        double res = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            res *= x;
        }
        if (n > 0) {
            return res;
        } else {
            return 1 / res;
        }
    }
}
