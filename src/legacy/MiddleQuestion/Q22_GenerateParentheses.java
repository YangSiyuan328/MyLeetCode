package MiddleQuestion;

import java.util.*;

public class Q22_GenerateParentheses {

    public static void main(String[] args) {
        Q22_GenerateParentheses Q = new Q22_GenerateParentheses();
        System.out.println(Q.generateParenthesis(1));
        System.out.println(Q.generateParenthesis(2));
        System.out.println(Q.generateParenthesis(3));
        System.out.println(Q.generateParenthesis(4));
    }

    // 动态规划
    public List<String> generateParenthesis(int n) {
        return null;
    }

    // 回溯
    public List<String> generateParenthesis1(int n) {
        ArrayList<String> list = new ArrayList<>();
        process("", n, n, list);
        return list;
    }

    /**
     * @param s    此时的字符串
     * @param num1 剩余的"("个数
     * @param num2 剩余的")"个数
     * @param list 容器
     */
    public void process(String s, int num1, int num2, ArrayList<String> list) {
        if (num1 > num2) return;
        if (num1 == 0 && num2 == 0) {
            list.add(s);
        }
        if (num1 > 0) {
            process(s + "(", num1 - 1, num2, list);
        }
        if (num2 > 0) {
            process(s + ")", num1, num2 - 1, list);
        }
    }

}
