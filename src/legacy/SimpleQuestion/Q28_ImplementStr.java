package SimpleQuestion;

/**
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q28_ImplementStr {
    public static void main(String[] args) {
        Q28_ImplementStr Q = new Q28_ImplementStr();
//        System.out.println(Q.strStr("hello", "ll"));
//        System.out.println(Q.strStr("aaaaa", "bba"));
//        System.out.println(Q.strStr("", ""));
//        System.out.println(Q.strStr("a", ""));
//        System.out.println(Q.strStr("aaa", "aaaa"));
        System.out.println(Q.strStr("mississippi", "issip"));
    }

    public int strStr(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() == 0 || s1.length() < s2.length()) return s2.length() == 0 ? 0 :-1;
        char[] str = s1.toCharArray();
        char[] match = s2.toCharArray();
        int[] next = getNextArray(match);
        int x = 0, y = 0;
        while (x < str.length && y < match.length) {
            if (str[x] == match[y]){
                x++;
                y++;
            } else if(next[y] != -1) { // y != 0
                y = next[y];
            } else { // y == 0
                x++;
            }
        }
        return y == match.length ? x - y : -1;
    }

    public int[] getNextArray(char[] match) {
        if (match.length == 1) return new int[]{-1};
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0){
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
