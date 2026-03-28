package 剑指Offer;

public class Offer21_调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && (nums[p1] & 1) == 1) p1++;
            while (p1 < p2 && (nums[p2] & 1) == 0) p2--;
            swap(nums, p1, p2);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
