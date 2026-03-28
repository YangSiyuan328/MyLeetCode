package 剑指Offer;

public class Offer15_二进制中1的个数 {

    public int hammingWeight(int n) {
        if (n == 0) return 0;
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ans++;
        }
        return ans;
    }

}
