package 剑指Offer;

public class Offer50_第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        int[] visited = new int[26];
        for (int i = 0; i < s.length(); i++) {
            visited[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }

}
