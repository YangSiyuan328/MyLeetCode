package SimpleQuestion;

public class Q693_交替位二进制数 {

    public static boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }
}
