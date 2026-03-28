package SimpleQuestion;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q35_SearchInsertPosition {
    public static void main(String[] args) {
        Q35_SearchInsertPosition Q = new Q35_SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        System.out.println(Q.searchInsert(nums, 5));
        System.out.println(Q.searchInsert(nums, 2));
        System.out.println(Q.searchInsert(nums, 7));
        System.out.println(Q.searchInsert(nums, 0));
        System.out.println(Q.searchInsert(new int[]{1, 3}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int L = 1;
        int R = nums.length - 2;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
