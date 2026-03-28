package 剑指Offer;

/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

示例 1:
输入: [7,5,6,4]
输出: 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

class Offer51_数组中的逆序对 {
    public static void main(String[] args) {
        Offer51_数组中的逆序对 Q = new Offer51_数组中的逆序对();
        //int[] nums = new int[]{7, 5, 6, 4};
        int[] nums = new int[]{2, 4, 3, 5, 1};
        System.out.println(Q.reversePairs(nums));
        System.out.println(Arrays.toString(nums));

    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return process(nums, 0, nums.length - 1);
    }

    public static int process(int[] nums, int l, int r) {
        if (l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return
                process(nums, l, mid)
                        +
                        process(nums, mid + 1, r)
                        +
                        merge(nums, l, mid, r);
    }

    public static int merge(int[] nums, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int res = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            res += nums[p1] <= nums[p2] ? 0 : (M - p1 + 1);
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= M) {
            help[i++] = nums[p1++];
        }
        while (p2 <= R) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[L + i] = help[i];
        }
        return res;
    }
}
