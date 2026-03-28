package SimpleQuestion;

public class Q268_丢失的数字 {

    public int missingNumber(int[] nums) {
        int l = nums.length;
        int res = (((l + 1)) * l) >> 1;
        for (int num : nums) {
            res -= num;
        }
        return res;
    }

}
