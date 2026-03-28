package SimpleQuestion;

import java.util.Arrays;

public class Q1929_ConcatenationOfArray {
    public static void main(String[] args) {
        Q1929_ConcatenationOfArray Q = new Q1929_ConcatenationOfArray();
        System.out.println(Arrays.toString(Q.getConcatenation(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(Q.getConcatenation(new int[]{1, 3, 2, 1})));
    }

    public int[] getConcatenation(int[] nums) {
        int l = nums.length;
        int[] ans = new int[2 * l];
        System.arraycopy(nums, 0, ans, 0, l);
        System.arraycopy(nums, 0, ans, l, l);
        return ans;
    }
}
