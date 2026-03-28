package SimpleQuestion;

public class Q326_PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(6));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        int mod;
        while (n >= 2) {
            mod = n % 3;
            if (mod != 0) return false;
            n /= 3;
        }
        return true;
    }

}
