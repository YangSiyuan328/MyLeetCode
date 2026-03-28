package 剑指Offer;

import java.util.ArrayList;

public class Offer38_字符串的排列 {

    public String[] permutation(String s) {
        if (s.length() == 0) return new String[0];
        char[] chars = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        process(chars, 0, list);
        return list.toArray(new String[0]);
    }

    // 深度优先遍历
    private void process(char[] str, int i, ArrayList<String> list) {
        if (i == str.length - 1) {
            list.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, list);
                swap(str, i, j);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
