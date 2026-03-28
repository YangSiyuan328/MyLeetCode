package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q1023_驼峰式匹配 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> answer = new ArrayList<>();
        for (String query : queries) {
            answer.add(isMatch(query, pattern));
        }
        return answer;
    }

    private boolean isMatch(String big, String small) {
        char[] str = big.toCharArray();
        char[] match = small.toCharArray();
        int x = 0, y = 0;
        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (str[x] < 'a') {
                return false;
            } else {
                x++;
            }
        }
        while (x < str.length){
            if (str[x++] < 'a') {
                return false;
            }
        }
        return y == match.length;
    }

}
