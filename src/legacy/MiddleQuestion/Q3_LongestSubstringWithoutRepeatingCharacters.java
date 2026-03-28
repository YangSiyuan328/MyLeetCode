package MiddleQuestion;

import java.util.HashSet;
import java.util.Set;

public class Q3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] set = new boolean[129];
        char[] chars = s.toCharArray();
        int l = 0;
        int res = 0;
        for (int r = 0; r < chars.length; r++) {
            if (!set[chars[r]]) {
                set[chars[r]] = true;
            } else {
                while (set[chars[r]]) {
                    set[chars[l++]] = false;
                }
                set[chars[r]] = true;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        boolean[] set = new boolean[129];
        char[] chars = s.toCharArray();
        int l = 0;
        int res = 0;
        for (int r = 0; r < chars.length; r++) {
            if (set[chars[r]]) {
                while (set[chars[r]]) {
                    set[chars[l++]] = false;
                }
                set[chars[r]] = true;
            }
            set[chars[r]] = true;
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
