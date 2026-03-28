package SimpleQuestion;

public class Q1672_最富有客户的资产总量 {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] account : accounts) {
            int cur = 0;
            for (int i : account) {
                cur += i;
            }
            maxWealth = Math.max(maxWealth, cur);
        }
        return maxWealth;
    }
}
