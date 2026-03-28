package MiddleQuestion;

public class Q5_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1;
        int mid = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                mid = C;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = (mid - max) >> 1; i < (mid + max) >> 1; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

}
