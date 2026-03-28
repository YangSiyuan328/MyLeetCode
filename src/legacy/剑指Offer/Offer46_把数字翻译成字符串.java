package 剑指Offer;

class Offer46_把数字翻译成字符串 {

    public static void main(String[] args) {
        Offer46_把数字翻译成字符串 o = new Offer46_把数字翻译成字符串();
        System.out.println(o.translateNum(12258));
        System.out.println(o.translateNum(25));

    }


    public int translateNum(int num) {
        if (num == 0) return 1;
        char[] str = String.valueOf(num).toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (str[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < N) {
                    dp[i] += dp[i + 2];
                }
            } else if (str[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < N && (str[i + 1] >= '0' && str[i + 1] <= '5')) {
                    dp[i] += dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
