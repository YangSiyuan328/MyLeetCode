package DifficultQuestion;

public class Q479_最大回文数乘积 {

    static int[] arr = new int[9];


    static {
        for (int i = 1; i <= 8; i++) {
            arr[i] = getAllLargestPalindrome(i);
        }
    }

    public int largestPalindrome(int n) {
        return arr[n];
    }

    private static int getAllLargestPalindrome(int n) {
        long count = (long) Math.pow(10, n * n) - 1;
        for (long i = count; i > 0; i--) {
            long mod = 0;
            long help = i;
            long palindrome = 0;
            while (help > 0) {
                palindrome = palindrome * 10 + mod;
                mod = help % 10;
                help /= 10;
            }
            if (palindrome == i) {
                return (int) (i % 1337);
            }
        }
        return 0;
    }

}
