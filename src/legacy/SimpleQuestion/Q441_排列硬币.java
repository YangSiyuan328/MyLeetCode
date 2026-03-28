package SimpleQuestion;

public class Q441_排列硬币 {

    // 迭代
    public int arrangeCoins1(int n) {
        int count = n;
        for (int i = 0; i < n >> 1; i++) {
            count -= i;
            if (count < 0) {
                return i - 1;
            }
        }
        return 0;
    }

    // 二分
    /**
     * 二分查找，O(log(n / 2 + 1))
     * @param n
     * @return
     */
    public static int arrangeCoins3(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }

}
