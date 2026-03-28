package SwordFingerOffer;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q38_LCOF {
    public static void main(String[] args) {
        Q38_LCOF Q = new Q38_LCOF();
        System.out.println(Arrays.toString(Q.permutation("abc")));
    }


    public String[] permutation(String s) {
        int l = s.length();
        if (l == 1) return new String[]{s};
        char[] chars = s.toCharArray();
        TreeSet<Character> treeSet = new TreeSet<>();
        for (char c : chars) {
            treeSet.add(c);
        }
        String[] str = new String[getFactorial(treeSet.size())];
        return null;
    }

    public int getFactorial(int num) {
        if (num == 2) return num;
        return num * getFactorial(num - 1);
    }
}
