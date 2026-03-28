package DifficultQuestion;


/**
 * 有效数字（按顺序）可以分成以下几个部分：
 * 一个 小数 或者 整数
 * <p>
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * 部分有效数字列举如下：
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * <p>
 * 部分无效数字列举如下：
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * <p>
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = ".1"
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q65_ValidNumber {
    public static void main(String[] args) {
        Q65_ValidNumber Q = new Q65_ValidNumber();
        System.out.println(Q.isNumber("0"));
        System.out.println(Q.isNumber("e"));
        System.out.println(Q.isNumber("."));
        System.out.println(Q.isNumber(".1"));
        System.out.println(Q.isNumber(".1"));
        System.out.println(Q.isNumber("Infinity"));
        System.out.println(Q.isNumber("959440.94f"));
    }

    public boolean isNumber(String s) {
        // 能被new Double(s);方法转为浮点数且不符合题意的字符串有：正负Infinity（均为y结尾），和D或者F结尾的浮点数
        char c = s.charAt(s.length() - 1);
        if (c == 'f' || c == 'D' || c == 'y') return false;
        try {
            new Double(s);
        } catch (NumberFormatException e) {
            // 如果不能转为浮点数，则返回 false
            return false;
        }
        return true;
    }
}
