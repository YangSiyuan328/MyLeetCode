package SimpleQuestion;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q53_MaximumSubarray {
    public static void main(String[] args) {
        Q53_MaximumSubarray Q = new Q53_MaximumSubarray();
        Q.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        Q.maxSubArray(new int[]{1});
        Q.maxSubArray(new int[]{0});
        Q.maxSubArray(new int[]{-1});
        System.out.println(Q.maxSubArray(new int[]{-10000}));

    }

    public int maxSubArray(int[] nums) {
        int[] sum =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                sum[i]=nums[0];
            }else {
                sum[i]=sum[i-1]+nums[i];
            }
        }
        for (int i : sum) {
            System.out.println(sum);
        }
        return -1;
    }
}
