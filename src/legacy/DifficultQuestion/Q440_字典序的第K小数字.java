package DifficultQuestion;

import java.util.Arrays;

public class Q440_字典序的第K小数字 {

    public static void main(String[] args) {
        Q440_字典序的第K小数字 Q = new Q440_字典序的第K小数字();
        System.out.println(Q.findKthNumber(1000, 20));
        System.out.println(Q.findKthNumber(1000, 20));
        //System.out.println(Q.findKthNumber(1, 1));
    }

    public int findKthNumber(int n, int k) {
        int ans = 1;
        while (k > 1) {
            int count = helper(ans, ans + 1, n);
            if (count < k) {
                ans++;
                k -= count;
            } else {
                ans *= 10;
                k--;
            }
        }
        return ans;
    }

    private int helper(long n1, long n2, long n) {
        int ans = 0;
        while (n1 <= n) {
            ans += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return ans;
    }

}
