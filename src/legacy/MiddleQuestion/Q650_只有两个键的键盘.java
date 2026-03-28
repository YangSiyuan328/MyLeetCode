package MiddleQuestion;

public class Q650_只有两个键的键盘 {

    public int minSteps(int n) {
        if (n == 1) return 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return i + minSteps(n / i);
        }
        return n;
    }

    public int minSteps1(int n) {
        int help;
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            help = isPrimeNormal(i);
            if (help == i) {
                dp[i] = i;
            } else {
                dp[i] = dp[help] + dp[i / help];
            }
        }
        return dp[n];
    }

    // 2 - positiveInfinity
    // 如果是质数，返回自己；不是质数，返回较小的因子。
    public static int isPrimeNormal(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }


    /*
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
        0 2 3 4 5 5 7 6 6  7 11  7 13  9  8  8 17  8 19  9 10 13 23  9 10 15  9 11 29 10
     */
}
