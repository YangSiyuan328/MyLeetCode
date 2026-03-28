package 剑指Offer;

/*
统计一个数字在排序数组中出现的次数。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer53I_在排序数组中查找数字I {

    public static void main(String[] args) {
        Offer53I_在排序数组中查找数字I o = new Offer53I_在排序数组中查找数字I();
        System.out.println(o.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(o.search(new int[]{5, 7, 7, 8, 8, 10}, 6));
        System.out.println(o.search(new int[]{}, 0));
        System.out.println(o.search(new int[]{1}, 1));
        System.out.println(o.search(new int[]{2, 2}, 3));
    }

    // 二分法
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target)
                right = mid;
            if (nums[mid] < target)
                left = mid + 1;
        }
        while (left < nums.length && nums[left++] == target) count++;
        return count;
    }


}










