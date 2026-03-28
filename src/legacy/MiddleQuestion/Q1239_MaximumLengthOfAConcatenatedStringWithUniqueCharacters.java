package MiddleQuestion;
/**
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 * <p>
 * 示例 1：
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * <p>
 * 示例 2：
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * <p>
 * 示例 3：
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Q1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    List<String> list1 = new LinkedList<String>() {
        {
            add("un");
            add("iq");
            add("ue");
        }
    };

    List<String> list2 = new LinkedList<String>() {
        {
            add("cha");
            add("r");
            add("act");
            add("ers");
        }
    };

    List<String> list3 = new LinkedList<String>() {
        {
            add("abcdefghijklmnopqrstuvwxyz");
        }
    };

    public static void main(String[] args) {
        Q1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters Q = new Q1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
        System.out.println(Q.maxLength(Q.list1));
        System.out.println(Q.maxLength(Q.list2));
        System.out.println(Q.maxLength(Q.list3));
    }

    public int maxLength(List<String> arr) {
        if (arr.isEmpty()) return 0;

        TreeSet<Character> treeSet = new TreeSet<>();
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                treeSet.add(s.charAt(i));
            }
        }
        for (Character character : treeSet) {
            System.out.println(character);
        }
        System.out.println("==============");
        return -1;
    }
}
