package MiddleQuestion;

public class Q238_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int l = nums.length;
        int[] ans = new int[l];
        ans[0] = 1;
        int R = 1;
        for (int i = 1; i < l; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = l - 1; i > 0; i--) {
            ans[i] = ans[i] * R;
            R *= ans[i];
        }
        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int l = nums.length;
        int[] pre = new int[l];
        int[] suf = new int[l];
        int[] ans = new int[l];
        pre[0] = nums[0];
        suf[l - 1] = nums[l - 1];
        for (int i = 1; i < l; i++) {
            pre[i] = pre[i - 1] * nums[i];
            suf[l - 1 - i] = suf[l - i] * nums[l - 1 - i];
        }
        ans[0] = suf[1];
        ans[l - 1] = pre[l - 2];
        for (int i = 1; i < l - 1; i++) {
            ans[i] = pre[i - 1] * suf[i + 1];
        }
        return ans;
    }

}
