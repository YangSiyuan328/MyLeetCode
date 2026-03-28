package 剑指Offer;

public class Offer56I_数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length <= 2) return nums;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int flag = xor & (-xor);
        int res = 0;
        for (int num : nums) {
            if ((flag & num) != 0) {
                res ^= num;
            }
        }
        return new int[]{res, xor ^ res};
    }

}
