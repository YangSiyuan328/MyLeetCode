package DifficultQuestion;

import java.util.HashSet;

public class Q940_DistinctSubsequencesII {

    final int MOD = (int) 1e9 + 7;

    public int distinctSubseqII(String s) {
        HashSet<String> set = new HashSet<>();
        process(s.toCharArray(), 0, set, "");
        set.remove("");
        return set.size() % MOD;
    }

    public static void process(char[] str, int index, HashSet<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        // 不添加 index 位置元素
        process(str, index + 1, set, path);
        // 添加 index 位置元素
        process(str, index + 1, set, path + String.valueOf(str[index]));
    }
}
