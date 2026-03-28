package SimpleQuestion;

public class Q762_二进制表示中质数个计算置位 {

    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            res += 665772 >> Integer.bitCount(i) & 1;
        }
        return res;
    }
}
