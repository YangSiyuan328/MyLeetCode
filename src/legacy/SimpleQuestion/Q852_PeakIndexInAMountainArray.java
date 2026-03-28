package SimpleQuestion;

/**
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 找局部最值——二分法
 */
class Q852_PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Q852_PeakIndexInAMountainArray Q = new Q852_PeakIndexInAMountainArray();
        System.out.println(Q.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(Q.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(Q.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(Q.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(Q.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }

    /*public int peakIndexInMountainArray(int[] arr) {
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length - 2] < arr[arr.length - 1]) return arr.length - 1;
        int low = 0;
        int hight = arr.length - 1;
        int mid = low + (hight - low) / 2;
        while (true) {
            if (arr[mid] > arr[mid + 1]) {
                low = mid;
                mid = low + (hight - low) / 2;
            } else if (arr[mid - 1] < arr[mid]) {
                hight = mid;
                mid = low + (hight - low) / 2;
            } else {
                return mid;
            }
        }
    }*/
    public int peakIndexInMountainArray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            // 如果mid 比 mid + 1 大 说明存在的区间在[l, mid]
            // mid < mid + 1 说明存在的区间在[mid + 1, r]
            if(nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }

}
