package WeeklyContest.Week_246;

import java.awt.*;

/**
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * 子字符串 是字符串中的一个连续的字符序列。
 * <p>
 * 示例 1：
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 * <p>
 * 示例 2：
 * 输入：num = "4206"
 * 输出：""
 * 解释：在 "4206" 中不存在奇数。
 * <p>
 * 示例 3：
 * 输入：num = "35427"
 * 输出："35427"
 * 解释："35427" 本身就是一个奇数。
 */
class Q5788_LargestOddNumberInString {
    public static void main(String[] args) {
        Q5788_LargestOddNumberInString Q = new Q5788_LargestOddNumberInString();
        System.out.println(Q.largestOddNumber("52"));
        System.out.println(Q.largestOddNumber("4206"));
        System.out.println(Q.largestOddNumber("35427"));
        System.out.println(Q.largestOddNumber(""));
    }

    public String largestOddNumber(String num) {
        int l = num.length();
        if (l== 0) return num;
        if (num.charAt(l - 1) % 2 != 0) return num;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                break;
            } else {
                l--;
            }
        }
        if (l != 0) {
            return num.substring(0, l);
        } else {
            return "";
        }
    }
}
