package MiddleQuestion;

public class Q38_外观数列 {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        char index = str[0]; // 记录执行位置的数字
        int count = 0;; // 记录执行位置的数字出现的次数
        for (char c : str) {
            if (c == index) {
                count++;
            } else {
                sb.append(count).append(index);
                index = c;
                count = 1;
            }
        }
        sb.append(count).append(index);
        return sb.toString();
    }

}