package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q373_查找和最小的K对数字 {

    public static void main(String[] args) {
        List<List<Integer>> lists = kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums1.length > nums2.length) {
            int[] help = nums1;
            nums1 = nums2;
            nums2 = help;
        }
        int l1 = nums1.length, l2 = nums2.length;
        int[] rIndex = new int[l1];
        k = Math.min(k, l1 * l2);
        while (k-- > 0) {
            int x = 0, y0 = rIndex[x];
            while (y0 == l2) {
                y0 = rIndex[++x];
            }
            int x0 = x;
            int curMin = nums1[x0] + nums2[y0];
            while (x < l1) {
                if (nums1[x] + nums2[rIndex[x]] < curMin) {
                    x0 = x;
                    y0 = rIndex[x];
                    curMin = nums1[x0] + nums2[y0];
                }
                x++;
            }
            rIndex[x0]++;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[x0]);
            list.add(nums2[y0]);
            lists.add(list);
        }
        return lists;
    }


}
