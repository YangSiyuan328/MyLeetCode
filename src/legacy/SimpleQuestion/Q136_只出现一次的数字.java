package SimpleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-12  18:30
 * @Description: TODO
 * @Version: 1.0
 */
public class Q136_只出现一次的数字 {


    public int singleNumber(int[] nums) {
        int l = nums.length;
        for (int i = 1; i < l; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

}
