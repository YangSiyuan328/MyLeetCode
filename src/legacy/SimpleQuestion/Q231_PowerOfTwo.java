package SimpleQuestion;

class Q231_PowerOfTwo {

    public static void main(String[] args) {
        Q231_PowerOfTwo Q = new Q231_PowerOfTwo();
        System.out.println(Q.isPowerOfTwo(0));
    }

    // 位运算
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        int mod;
        while (n != 1) {
            mod = n & 1;
            if (mod != 0) return false;
            n >>= 1;
        }
        return true;
    }

}
