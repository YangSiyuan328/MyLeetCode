package 剑指Offer;

class Offer10I_斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(new Offer10I_斐波那契数列().fib(5));
    }

    final static int MOD = 1000000007;

    // 数组
    public int fib(int n) {
        if (n <= 1) return n;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 0; i < n - 1; i++) {
            fib[i + 2] = (fib[i + 1] + fib[i]) % MOD;
        }
        return fib[n];
    }




}
