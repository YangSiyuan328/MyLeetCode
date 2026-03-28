package WeeklyContest.Week_355;

import 剑指Offer.TreeNode;

import java.util.*;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: WeeklyContest.Week_355
 * @Author: 杨思远
 * @CreateTime: 2024-04-12  20:47
 * @Description: TODO
 * @Version: 1.0
 */
public class Q2791 {


    public static void main(String[] args) {
        Integer[] ints = {-1, 0, 0, 1, 1, 2};
        List<Integer> parent = Arrays.asList(ints);
        String s = "acaabc";
        Q2791 q = new Q2791();
        q.countPalindromePaths(parent, s);
    }

    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = s.length();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            Integer p = parent.get(i);
            g[p].add(i);
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        return dfs(0, 0, g, s.toCharArray(), cnt);
    }

    private long dfs(int v, int xor, List<Integer>[] g, char[] s, Map<Integer, Integer> cnt) {
        long res = 0;
            for (int w : g[v]) {
                int x = xor ^ (1 << (s[w] - 'a'));
                res += cnt.getOrDefault(x, 0); // x ^ x = 0
                for (int i = 0; i < 26; i++) {
                    res += cnt.getOrDefault(x ^ (1 << i), 0); // x ^ (x^(1<<i)) = 1<<i
                }
                cnt.merge(x, 1, Integer::sum);
                res += dfs(w, x, g, s, cnt);
        }
        return res;
    }

}
