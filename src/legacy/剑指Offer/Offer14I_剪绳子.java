package 剑指Offer;

public class Offer14I_剪绳子 {

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    // 数论，尽量分解为2和3
    public int cuttingRope1(int n) {
        if (n <= 3) return n - 1;
        int div = n / 3;
        int rem = n % 3;
        long res = 1;
        for (int i = 0; i < div; i++) {
            res *= i < div - 1 ? 3 : (rem == 2 ? rem : (3 + rem));
            if (res >= 1000000007) {
                res %= 1000000007;
            }
        }
        return (int) res;
    }

}
