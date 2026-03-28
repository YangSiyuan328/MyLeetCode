package SimpleQuestion;

class Q9_Palindrome {
    public static void main(String[] args) {
        Q9_Palindrome Q = new Q9_Palindrome();
        System.out.println(Q.isPalindrome(-212));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = 0;
        int m = x;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return m == n;

    }
}
