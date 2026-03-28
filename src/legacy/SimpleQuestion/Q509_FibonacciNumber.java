package SimpleQuestion;

public class Q509_FibonacciNumber {

    public int fib(int n) {
        if (n == 0) return 0;
        int f0 = 0, f1 = 1;
        for (int i = 2; i <= n; i++) {
            f1 += f0;
            f0 = f1 - f0;
            f1 %= 100000007;
        }
        return f1;
    }

}
