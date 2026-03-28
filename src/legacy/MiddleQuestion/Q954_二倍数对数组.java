package MiddleQuestion;

import java.util.*;

public class Q954_二倍数对数组 {

    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{4, 2, 4, 4, 2, -4, 0, -2, 0, 4}));
    }

    // 每一个数都有个二倍
    public static boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            if (key == 0) continue;
            int val = 1;
            if (map.containsKey(key)) {
                val = map.get(key);
                map.put(key, val + 1);
            } else {
                map.put(key, 1);
            }
            if (map.containsKey(key << 1) || (key % 2 == 0 && map.containsKey(key >> 1))) {
                int del = map.containsKey(key << 1) ? key << 1 : key >> 1;
                if (val == 1) {
                    map.remove(key);
                } else {
                    map.put(key, val);
                }
                Integer temp = map.get(del);
                if (temp == 1) {
                    map.remove(del);
                } else {
                    map.put(del, temp - 1);
                }
            }
        }
        return map.size() == 0;
    }
}
