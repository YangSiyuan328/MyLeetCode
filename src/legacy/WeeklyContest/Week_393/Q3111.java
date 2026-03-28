package WeeklyContest.Week_393;

import java.util.*;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: WeeklyContest.Week_393
 * @Author: 杨思远
 * @CreateTime: 2024-04-13  21:31
 * @Description: TODO
 * @Version: 1.0
 */
public class Q3111 {

    public static void main(String[] args) {
        Q3111 obj = new Q3111();
        int[] coins = {6, 5};
        System.out.println("obj.findKthSmallest(coins, 3) = " + obj.findKthSmallest(coins, 1435065516));
    }

    public long findKthSmallest(int[] coins, int k) {
        ArrayList<Integer> newCoins = new ArrayList<>();
        Arrays.sort(coins);
        flag:
        for (int i = 0; i < coins.length; i++) {
            int val1 = coins[i];
            for (int j = 0; j < i; j++) {
                int val2 = coins[j];
                if (val1 % val2 == 0 || val2 % val1 == 0) {
                    val1 = Math.min(val1, val2);
                    continue flag;
                }
            }
            newCoins.add(val1);
        }
//        Collections.sort(newCoins);
        int l = newCoins.size();
        if (newCoins.get(0) == 1) return k;
        if (l == 1) return (long) k * newCoins.get(0);
        if (k == 1) return newCoins.get(0);
        TreeSet<Long> set = new TreeSet<>();
        for (Integer newCoin : newCoins) {
            for (long j = 1; j <= k; j++) {
                long val = newCoin * j;
                if (!set.contains(val)) {
                    set.add(val);
                }
            }
        }

        for (int i = 0; i < k - 1; i++) {
            set.pollFirst();
        }
//        for (int i = 0; i < l; i++) {
//            for (int j = 0; j < l; j++) {
//                if (newCoins.get(j) * newCoins.get(j) < k) {
//                    k++;
//                }
//            }
//        }
//        int n = k / l;
//        int mod =
        return set.pollFirst();
    }

}
