package DifficultQuestion;

/*
给你一个整数数组 instructions ，你需要根据 instructions 中的元素创建一个有序数组。一开始你有一个空的数组 nums ，你需要 从左到右 遍历 instructions 中的元素，将它们依次插入 nums 数组中。每一次插入操作的 代价 是以下两者的 较小值 ：

nums 中 严格小于  instructions[i] 的数字数目。
nums 中 严格大于  instructions[i] 的数字数目。
比方说，如果要将 3 插入到 nums = [1,2,3,5] ，那么插入操作的 代价 为 min(2, 1) (元素 1 和  2 小于 3 ，元素 5 大于 3 ），插入后 nums 变成 [1,2,3,3,5] 。

请你返回将 instructions 中所有元素依次插入 nums 后的 总最小代价 。由于答案会很大，请将它对 109 + 7 取余 后返回。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/create-sorted-array-through-instructions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 等同于每个数右边比他小的数字和
 */
public class Q1649_CreateSortedArrayThroughInstructions {
    public static void main(String[] args) {
        Q1649_CreateSortedArrayThroughInstructions Q = new Q1649_CreateSortedArrayThroughInstructions();
        System.out.println(Q.createSortedArray(new int[]{1, 5, 6, 2}));
    }

    public int createSortedArray(int[] instructions) {
        return -1;
    }


}
