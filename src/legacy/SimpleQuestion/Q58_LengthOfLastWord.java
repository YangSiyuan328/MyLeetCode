package SimpleQuestion;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q58_LengthOfLastWord {
    public static void main(String[] args) {
        Q58_LengthOfLastWord Q = new Q58_LengthOfLastWord();
        System.out.println(Q.lengthOfLastWord("Hello World"));
        System.out.println(Q.lengthOfLastWord(" "));
        System.out.println(Q.lengthOfLastWord("a"));
        System.out.println(Q.lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {
        int l = s.length() - 1;
        while (' ' == s.charAt(l)) {
            if (l == 0) return 0;
            l--;
        }
        for (int i = l; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                return l - i;
            }
        }
        return l + 1;
    }
}
