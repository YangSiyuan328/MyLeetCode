package WeeklyContest.Week_355;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: WeeklyContest.Week_355
 * @Author: 杨思远
 * @CreateTime: 2024-04-12  20:47
 * @Description: TODO
 * @Version: 1.0
 */
public class Q2790 {

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        int[] count = new int[n + 1];
        for (Integer limit : usageLimits) {
            int x = Math.min(limit, n);
            count[x]++;
        }
        long total = 0, k = 0;
        for (int usageLimit = 1; usageLimit <= n; usageLimit++) {
            for (int c = 0; c < count[usageLimit]; c++) {
                total += usageLimit;
                total -= total > k ? ++k : 0;
            }
        }
        return (int) k;
    }

    public int maxIncreasingGroups1(List<Integer> usageLimits) {
        int res = 0;
        long available = 0;
        Collections.sort(usageLimits);
        for (Integer count : usageLimits) {
            if (available + count > res) {
                available += count - (res++ + 1);
            } else {
                available += count;
            }
        }
        return res;
    }

}
