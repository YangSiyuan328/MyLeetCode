package SimpleQuestion;

public class Q1332_删除回文子序列 {
    public int removePalindromeSub(String s) {
        int l = s.length();
        for (int i = 0; i < (l + 1) >> 1; i++) {
            if (s.charAt(i) != s.charAt(l - 1 - i)) return 2;
        }
        return 1;
    }
}
