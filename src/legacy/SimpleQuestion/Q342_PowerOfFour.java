package SimpleQuestion;

public class Q342_PowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int mod;
        while (n > 1) {
            mod = n % 4;
            if (mod != 0) return false;
            n >>= 2;
        }
        return true;
    }

}
