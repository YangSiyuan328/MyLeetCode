package SimpleQuestion;

public class Q1576_替换所有的问号 {


    public String modifyString(String s) {
        if (s.length() == 1) return s.equals("?") ? "a" : s;
        char[] map = new char[]{'a', 'b', 'c'};
        char[] chars = s.toCharArray();
        int l = s.length();
        int p;
        for (int i = 0; i < l; i++) {
            if (chars[i] == '?') {
                if (i == l - 1) {
                    p = 0;//防止越界
                    chars[i] = chars[i - 1] == map[p] ? map[++p] : map[p];
                    break;
                }
                char pre = i == 0 ? '?' : chars[i - 1];
                char lastOne = chars[i + 1];
                p = 0;
                while (map[p] == pre || map[p] == lastOne) {
                    p++;
                }
                chars[i] = map[p];
                pre = map[p];
            }
        }
        return new String(chars);
    }

}
