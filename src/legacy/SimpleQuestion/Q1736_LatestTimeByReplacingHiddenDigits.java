package SimpleQuestion;

public class Q1736_LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        Q1736_LatestTimeByReplacingHiddenDigits Q = new Q1736_LatestTimeByReplacingHiddenDigits();
        System.out.println(Q.maximumTime("2?:?0"));
        System.out.println(Q.maximumTime("0?:3?"));
        System.out.println(Q.maximumTime("1?:22"));
    }

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            if (chars[1] == '?') {
                chars[0] = '2';
                chars[1] = '3';
            }
            if (chars[1] < '4') {
                chars[0] = '2';
            } else {
                chars[0] = '1';
            }
        }
        if (chars[1] == '?') {
            if (chars[0] != '2') {
                chars[1] = '9';
            } else {
                chars[1] = '3';
            }
        }
        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }
        return new String(chars);
    }
}
