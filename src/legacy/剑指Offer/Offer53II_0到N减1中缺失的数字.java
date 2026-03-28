package 剑指Offer;

import java.util.Arrays;

public class Offer53II_0到N减1中缺失的数字 {

    // 理论的和减去实际的和即为缺少的数字
    public int missingNumber(int[] nums) {
        //计算出0-n的和  n*(n+1)/2
        int sum = nums.length * (nums.length+1)/2;
        return  sum - Arrays.stream(nums).sum() ;
    }

    // 二分
    public int missingNumber1(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1;
        if (nums[left] != left) return left;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 数组下标是从0开始连续的向n增长，若相等范围区域继续向右靠
            if (nums[mid] == mid) {
                left = mid + 1;
            } else { // 不相等范围区域向左靠拢
                right = mid - 1;
            }
        }
        return left;
    }

}
