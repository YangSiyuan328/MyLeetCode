package DifficultQuestion;

public class Q214_最短回文串 {

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
        System.out.println(shortestPalindrome("abdvcd"));
        System.out.println(shortestPalindrome("vcd"));
    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        char[] str = manacherString(s);
        int l = str.length;
        int[] pArr = new int[l];
        int C = l;
        int L = l;
        for (int i = l - 1; i >= 0; i--){
            pArr[i] = L < i ? Math.min(pArr[2 * C - i], i - L) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i - pArr[i] < L) {
                L = i - pArr[i];
                C = i;
            }
            if (L == 0) {
                break;
            }
        }
        char[] res = new char[s.length() - C];
        for (int i = 0; i < res.length; i++) {
            res[i] = s.charAt(s.length() - 1 - i);
        }
        return String.valueOf(res) + s;
    }

    public static char[] manacherString(String s) {

        char[] str = s.toCharArray();
        char[] res = new char[str.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : str[index++];
        }
        return res;
    }
}
