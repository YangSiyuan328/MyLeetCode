package DifficultQuestion;

public class Q4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1 + l2;
        int[] nums = new int[l];
        int index1 = 0, index2 = 0, index = 0;
        while (index < l) {
            while (index1 < l1 && index2 < l2) {
                nums[index++] = nums1[index1] <= nums2[index2] ? nums1[index1++] : nums2[index2++];
            }
            while (index1 < l1) {
                nums[index++] = nums1[index1++];
            }
            while (index2 < l2) {
                nums[index++] = nums1[index2++];
            }
        }
        return (l & 1) == 0 ? ((double) (nums[l >> 1] + nums[(l >> 1) - 1])) / 2 : nums[l >> 1];
    }

}
