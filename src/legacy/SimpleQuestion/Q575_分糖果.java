package SimpleQuestion;

import java.util.HashSet;
import java.util.Set;

public class Q575_分糖果 {

    // 36ms
    public int distributeCandies1(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i : candyType) {
            if (!set.contains(i)) {
                count++;
                set.add(i);
            }
        }
        return Math.min(count, candyType.length >> 1);
    }

    // 9ms
    public int distributeCandies2(int[] candyType) {
        int[] flag = new int[200000 + 1];
        int count = 0;
        for (int i : candyType) {
            if (flag[i + 100000] == 0) {
                count++;
                flag[i + 100000] = 1;
            }
        }
        return Math.min(count, candyType.length >> 1);
    }

    // 5ms
    public int distributeCandies3(int[] candyType) {
        boolean[] flag = new boolean[200001];
        int count = 0;
        for (int i : candyType) {
            if (!flag[i + 100000]) {
                count++;
                flag[i + 100000] = true;
            }
        }
        return Math.min(count, candyType.length >> 1);
    }

    // 4ms
    public int distributeCandies(int[] candyType) {
        boolean[] flag = new boolean[200001];
        int count = 0;
        for (int i : candyType) {
            if (!flag[i + 100000]) {
                count++;
                flag[i + 100000] = true;
            }
            if (count == candyType.length >> 1) return count;
        }
        return count;
    }

}
