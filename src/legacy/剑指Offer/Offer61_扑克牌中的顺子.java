package 剑指Offer;

import java.util.Arrays;

public class Offer61_扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        for (int i = 1; i < 5; i++) {
            if (nums[i - 1] == 0) continue;
            if (nums[i] == nums[i - 1]) return false;
            temp += nums[i] - nums[i - 1];
        }
        return temp < 5;
    }


    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        int zeroNum = 0;
        int index = 0;
        int help = 0;
        while (nums[index] == 0) {
            index++;
            zeroNum++;
        }
        help = nums[index++];
        while (index < nums.length) {
            if (nums[index] - help == 1) {
                index++;
            } else {
                if (zeroNum > 0) {
                    zeroNum--;
                } else {
                    return false;
                }
            }
            help++;
        }
        return true;
    }

}
