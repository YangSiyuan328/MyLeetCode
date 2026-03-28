package MiddleQuestion;

import java.util.Arrays;

public class Q912_SortAnArray {
    public int[] sortArray(int[] nums) {
        mergeSort1(nums);
        return nums;
    }

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] nums, int L, int R) {
        if (R == L) return;
        int mid = L + ((R - L) >> 1);
        process(nums, L, mid);
        process(nums, mid + 1, R);
        merge(nums, L, mid, R);
    }

    public static void merge(int[] nums, int L, int M, int R) {
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
        /*for (i = 0; i < help.length; i++) {
            nums[L + i] = help[i];
        }*/

        System.arraycopy(help, 0, nums, L, help.length);

    }

    public static void main(String[] args) {
        Q912_SortAnArray Q = new Q912_SortAnArray();
        System.out.println(Arrays.toString(Q.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(Q.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
