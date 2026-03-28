package SimpleQuestion;

public class Q598_范围求和II {

    public int maxCount(int m, int n, int[][] ops) {
        int ans = m * n;
        for (int[] op : ops) {
            ans = Math.min(ans, op[0] * op[1]);
        }
        return ans;
    }

}
