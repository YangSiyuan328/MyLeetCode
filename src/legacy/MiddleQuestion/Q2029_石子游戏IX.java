package MiddleQuestion;

public class Q2029_石子游戏IX {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int i : stones) count[i % 3]++;
        if (count[0] % 2 == 0) return count[1] != 0 && count[2] != 0;
        return count[2] > count[1] + 2 || count[1] > count[2] + 2;
    }
}
