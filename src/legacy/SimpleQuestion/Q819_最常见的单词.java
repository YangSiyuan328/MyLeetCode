package SimpleQuestion;

import java.util.*;

public class Q819_最常见的单词 {

    public static void main(String[] args) {
        String s = mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"});
        System.out.println(s);
    }
    /*
        Map.getOrDefault(Object key, V defaultValue);
        如果存在就用存在的值，不存在就加入，并且用 defaultValue 作为默认值
     */

    public static String mostCommonWord(String paragraph, String[] banned) {
        String res = "";
        int count = 0;
        HashSet<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        Collections.addAll(set, banned);

        String[] split = paragraph.split("\\s|,|\\.|!|:|;|\\?|'");
        for (String s : split) {
            s = s.toLowerCase();
            count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
        }
        count = 0;
        for (String key : map.keySet()) {
            if (key.equals("") || set.contains(key)) continue;
            int cur = map.get(key);
            if (cur > count) {
                res = key;
                count = cur;
            }
        }
        return res;
    }

}
