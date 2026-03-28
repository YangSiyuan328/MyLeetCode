package MiddleQuestion;

public class Q334_递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = a;
        for (int num : nums) {
            if (num <= a) {
                a = num;
            } else if (num < b) {
                b = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
