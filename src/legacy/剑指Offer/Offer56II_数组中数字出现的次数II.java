package 剑指Offer;

public class Offer56II_数组中数字出现的次数II {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public int singleNumber1(int[] nums) {
        int[] k = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                k[j] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (k[i] % 3) << i;
        }
        return res;
    }

}
