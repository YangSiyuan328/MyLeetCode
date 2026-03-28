package 剑指Offer;

import java.util.HashMap;

public class Offer39_数组中出现次数超过一半的数字 {

    // 数组取中位数

    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer card = null;
        for (int num : nums) {
            if (count == 0) card = num;
            count += (card == num) ? 1 : -1;
        }
        return card;
    }

    // 暴力哈希
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > max) {
                res = num;
                max = map.get(num);
            }
        }
        return res;
    }

}
