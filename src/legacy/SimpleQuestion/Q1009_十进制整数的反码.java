package SimpleQuestion;

public class Q1009_十进制整数的反码 {

    public int bitwiseComplement1(int n) {
        if (n == 0) return 1;
        int num = n, c = 0;
        while (num > 0) {
            num >>= 1;
            c = (c << 1) + 1;
        }
        return n ^ c;
    }

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int i = 1;
        while (i <= n) {
            i *= 2;
        }
        return i - n - 1;
    }

}
