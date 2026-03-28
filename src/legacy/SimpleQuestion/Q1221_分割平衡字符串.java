package SimpleQuestion;

public class Q1221_分割平衡字符串 {

    public int balancedStringSplit(String s) {
        return process(s, 0, 0, 0, 0);
    }

    /**
     *
     * @param s 题中的平衡字符串
     * @param R 当索引指向 index 时，此时 index 前面的 'R' 的个数
     * @param L 当索引指向 index 时，此时 index 前面的 'L' 的个数
     * @param index 当前索引
     * @param res 返回值
     * @return 当索引指向 index 时，此时 index 前面的 最小平衡字符串 数量
     */
    private static int process(String s, int R, int L, int index, int res) {
        // Basis Case : 当指针指向 s.length() 时，返回 s.length() 前的所有情况
        if (index == s.length()) return res + 1;
        // 当 R == L 说明前面的都是平衡的，R != 0 (或 L != 0) 增加情况
        if (R == L && R != 0) res++;
        // 该字符是谁，谁的个数增加1
        if (s.charAt(index) == 'R') {
            return process(s, R + 1, L, index + 1, res);
        } else {
            return process(s, R, L + 1, index + 1, res);
        }
    }

}
