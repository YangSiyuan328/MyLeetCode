package DifficultQuestion;

import java.util.Arrays;

public class Q493_ReversePairs {

    public static void main(String[] args) {
        Q493_ReversePairs Q = new Q493_ReversePairs();
        int[] nums = new int[]{1, 3, 2, 3, 1};
        System.out.println(Q.reversePairs(nums));
        System.out.println(Arrays.toString(nums));
        int[] nums2 = new int[]{2, 4, 3, 5, 1};
        System.out.println(Q.reversePairs(nums2));
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(Q.reversePairs(nums3));
        System.out.println(Arrays.toString(nums3));
        //1,073,741,823.5
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int L, int R) {
        if (L == R) return 0;
        int M = L + ((R - L) >> 1);
        return process(nums, L, M) + process(nums, M + 1, R) + merge(nums, L, M, R);
    }

    private int merge(int[] nums, int L, int M, int R) {
        int ans = 0;
        int index = L;
        for (int i = M + 1; i <= R; i++) {
            //[2147483647,2147483647,2147483647,2147483647,2147483647,2147483647] 避免越界，先转型再接收
            long doubleNumber =(long) 2 * nums[i];
            while (index <= M && nums[index] <= doubleNumber) {
                index++;
            }
            ans += M - index + 1;

        }
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= M) {
            help[i++] = nums[p1++];
        }
        while (p2 <= R) {
            help[i++] = nums[p2++];
        }
        System.arraycopy(help, 0, nums, L, help.length);
        return ans;
    }
}
