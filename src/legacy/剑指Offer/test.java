package 剑指Offer;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        swap(nums, 0, 1);
        swap(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
        swap(nums, 1, 2);
        swap(nums, 0, 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
