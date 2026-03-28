package MiddleQuestion;

public class Q2024_考试的最大困扰度 {

    public int maxConsecutiveAnswers(String str, int k) {
        if (k >= str.length()) return str.length();
        char[] c = str.toCharArray();
        int n = c.length;
        int left = 0,right = 0;
        int numT = 0, numF = 0;
        int ans = 0;
        while (right < n) {
            if (c[right] == 'T') {
                numT++;
            } else {
                numF++;
            }
            while (numT > k && numF > k) {
                if (c[left] == 'T') {
                    numT--;
                } else {
                    numF--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
