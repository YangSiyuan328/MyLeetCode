package MiddleQuestion;

import java.util.*;

public class Q187_重复的DNA序列 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10 || s.length() > 10000) return new ArrayList<String>();
        Set<String> set = new HashSet<>(), res = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length - 10; i++) {
            String str = String.valueOf(chars, i, 10);
            if (!set.add(str)) res.add(str);
        }
        return new ArrayList<String>(res);
    }


    /*
        Map.getOrDefault(Object key, V defaultValue);
        如果存在就用存在的值，不存在就加入，并且用 defaultValue 作为默认值
     */
    public List<String> findRepeatedDnaSequences3(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (!list.contains(str)) {
                Integer count = map.getOrDefault(str, 0);
                if (count > 0) {
                    list.add(str);
                    continue;
                }
                map.put(str, count + 1);
            }
        }
        return list;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int l = s.length();
        int index = 0;
        while (index + 10 <= l) { // 截止为止为 index + 10 - 1 <= l - 1 => index + 10 <= l
            String str = s.substring(index, index + 10);
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, 2);
            }
            index++;
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 1) list.add(key);
        }
        return list;
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        int l = s.length();
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int index = 0;
        while (index + 10 <= l) { // 截止为止为 index + 10 - 1 <= l - 1 => index + 10 <= l
            String str = s.substring(index, index + 10);
            if (set.contains(str)) {
                set2.add(str);
            } else {
                set.add(str);
            }
            index++;
        }
        return new ArrayList<>(set2);
    }

}
