package SimpleQuestion;

public class Q414_第三大的数 {


    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int max = Integer.MIN_VALUE;
        int SecMax = Integer.MIN_VALUE;
        int ThiMax = Integer.MIN_VALUE;
        boolean f = true;
        int flag = 0;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE && f) {
                flag++;
                f = false;
            }
            if (num > max) {
                flag++;
                ThiMax = SecMax;
                SecMax = max;
                max = num;
            } else if (num > SecMax && num < max) {
                flag++;
                ThiMax = SecMax;
                SecMax = num;
            } else if (num > ThiMax && num < SecMax) {
                flag++;
                ThiMax = num;
            }
        }
        return flag >= 3 ? ThiMax : max;
    }
}
