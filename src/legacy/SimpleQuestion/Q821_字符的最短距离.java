package SimpleQuestion;

public class Q821_字符的最短距离 {

    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] res = new int[length];
        int l = 0;
        int r = 0;
        int last = -1;
        while (r < length) {
            if (s.charAt(r) == c) {
                if (last == -1) {
                    while (l <= r) {
                        res[l] = r - l++;
                    }
                } else {
                    while (l <= r) {
                        res[l] = Math.min(l - last, r - l++);
                    }
                }
                last = r;
            }
            r++;
        }
        while (l < length) {
            res[l] = l++ - last;
        }
        return res;
    }

}
