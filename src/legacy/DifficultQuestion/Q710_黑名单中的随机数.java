package DifficultQuestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Q710_黑名单中的随机数 {

    public static void main(String[] args) {
        Solution s = new Solution(7, new int[]{2, 3, 5});
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
    }

}
class Solution {

    ArrayList<Integer> list;

    HashSet<Integer> set;

    Random random;

    public Solution(int n, int[] blacklist) {
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (int i : blacklist) {
            set.remove(i);
        }
        list = new ArrayList<>(set);
        random = new Random();
    }

    public int pick() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */