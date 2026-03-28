package 剑指Offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Offer48_最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        Offer48_最长不含重复字符的子字符串 o = new Offer48_最长不含重复字符的子字符串();
        System.out.println(o.lengthOfLongestSubstring("jkgsagjhajhvajdksgjgfkhgjk"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(set.contains(c)) {
                set.remove(s.charAt(l++));
            }
            set.add(c);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0, n = s.length();
        int[] lastIndex = new int[128];
        int start = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            start = Math.max(start, lastIndex[chs[i]]);
            res = Math.max(res, i - start + 1);
            lastIndex[chs[i]] = i + 1;
        }
        return res;
    }

    // map
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int start = 0;
        int curMax = 0;
        int res = 0;
        for (int i = 0; i < str.length; i++) {
            if (!map.containsKey(str[i])) {
                map.put(str[i], i);
                curMax++;
            } else {
                if (map.get(str[i]) >= start) {
                    curMax = i - map.get(str[i]);
                    start = map.get(str[i]) + 1;
                } else {
                    curMax++;
                }
                map.put(str[i], i);
            }
            res = Math.max(res, curMax);
        }
        return res;
    }
}
