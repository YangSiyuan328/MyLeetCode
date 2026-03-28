package DifficultQuestion;

public class Q32_最长有效括号 {

    public int longestValidParentheses(String s) {
        if (s == null || s.equals("")) return 0;
        char[] str = s.toCharArray();
        int l = str.length;
        int[] dp = new int[l];
        int pre = 0;
        int ans = 0;
        for (int i = 1; i < l; i++) { // dp[0] = 0;
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1; // 与str[i]匹配的左括号的位置 pre
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
}
