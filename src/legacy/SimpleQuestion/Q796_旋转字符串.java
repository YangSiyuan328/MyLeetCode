package SimpleQuestion;

class Q796_旋转字符串 {

    // KMP
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        s += s;
        char[] str = s.toCharArray();
        char[] match = goal.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArray(match);
        while (x < s.length() && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length;
    }

    private int[] getNextArray(char[] match) {
        if (match.length == 1) return new int[]{-1};
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < match.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

}
