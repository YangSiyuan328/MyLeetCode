package SimpleQuestion;

public class Q704_二分查找 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int L = 0;
        int R = nums.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[mid] == target ? mid : -1;
    }
}
