package SimpleQuestion;

public class Q453_最小操作次数使数组元素相等 {

    /**
     * 优化前 2ms
     * @param nums
     * @return
     */
    public int minMoves1(int[] nums) {
        int l = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - l * min;
    }

    /**
     * 优化后 1 ms
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }


}
