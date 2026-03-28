package SimpleQuestion;

public class Q434_字符串中的单词数 {

    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        int ans = 0;
        char[] str = s.toCharArray();
        for (int i = 1; i < str.length; i++) {
            if (str[i] != ' ' && str[i - 1] == ' ') ans++;
        }
        return str[0] == ' ' ? ans : ans + 1;
    }

}
