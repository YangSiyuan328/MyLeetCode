package 剑指Offer;

import java.util.HashSet;

public class Offer03_数组中重复的数字 {

    // 原地数组 0ms
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) { // 如果元素的当前位置正确，则跳过
                i++;
            } else if (nums[i] == nums[nums[i]]) {// 如果当前元素与拟定交换位置处的元素相同，则说明已经找到重复元素
                return nums[i];
            } else { // 否则反复交换元素，直到元素位于其应在的位置
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    // 构造数组
    public int findRepeatNumber1(int[] nums) {
        int l = nums.length;
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            if (arr[nums[i]] != 0) {
                return arr[nums[i]];
            }
            arr[nums[i]] = nums[i];
        }
        return 0;
    }

    // 哈希表
    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

}
