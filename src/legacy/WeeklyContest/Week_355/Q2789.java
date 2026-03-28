package WeeklyContest.Week_355;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: WeeklyContest.Week_355
 * @Author: 杨思远
 * @CreateTime: 2024-04-12  20:47
 * @Description: TODO
 * @Version: 1.0
 */
public class Q2789 {

    public static void main(String[] args) {
        Q2789 obj = new Q2789();
        System.out.println("obj.maxArrayValue(new int[]{56,67,18,81,95,41,39,56,63,70,56,31,84,46,28,38,27,56,13,10,58,16,85,21,63,8}) = " + obj.maxArrayValue(new int[]{56, 67, 18, 81, 95, 41, 39, 56, 63, 70, 56, 31, 84, 46, 28, 38, 27, 56, 13, 10, 58, 16, 85, 21, 63, 8}));
    }

    public long maxArrayValue(int[] nums) {
        int l = nums.length;
        long res = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            res = res >= nums[i] ? res + nums[i] : nums[i];
        }
        return res;
    }

}
