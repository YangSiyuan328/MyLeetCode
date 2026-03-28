package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q22_括号生成 {


    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        process(list, n, n, "");
        return list;
    }

    private static void process(ArrayList<String> list, int n, int m, String s) {
        if (n > m || n < 0) return;
        if (n == 0 && m == 0) {
            list.add(s);
            return;
        }
        // n <= m  左<=右  -1 4
        process(list, n - 1, m, s + "(");
        process(list, n, m - 1, s + ")");
    }

}
