package DifficultQuestion;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1044_最长重复子串 {

    public String longestDupSubstring(String s) {
        Set<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        String ans = "";
        int maxLength = 0;
        int l = 0;
        char[] chars = s.toCharArray();
        for (int r = 0; r < chars.length; r++) {
            if (!set.contains(chars[r])) {
                builder.append(chars[r]);
                set.add(chars[r]);
            } else {
                while (set.contains(chars[r])) {
                    set.remove(builder.charAt(0));
                    builder.deleteCharAt(0);
                }
                set.add(chars[r]);
                builder.append(chars[r]);
            }
            if (r - l + 1 > maxLength){
                maxLength = r - l + 1;
                ans = builder.toString();
            }

        }
        return ans;
    }

}
