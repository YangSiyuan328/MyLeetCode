package MiddleQuestion;

import java.util.HashSet;
import java.util.Set;

public class Q128_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        // 遍历
        // 如果 num - 1 不存在, 说明 num是起点, 进入内层循环,重新计算字串长度
        // 如果 num - 1 存在, 说明已经遍历给, 直接跳过
        for (int num : set) {
            // 跳过已经遍历的元素
            if (!set.contains(num - 1)) {
                int curLength = num;
                //往后遍历元素
                while (set.contains(curLength + 1)) {
                    curLength++;
                }
                maxLength = Math.max(curLength - num + 1, maxLength);
            }
        }
        return maxLength;
    }

}
