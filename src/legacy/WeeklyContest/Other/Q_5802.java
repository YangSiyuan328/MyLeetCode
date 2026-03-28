package WeeklyContest.Other;

//请你将它对 10^9 + 7 取余后返回
public class Q_5802 {
    public static void main(String[] args) {
        Q_5802 Q = new Q_5802();
        System.out.println(Q.countGoodNumbers(1));
        System.out.println(Q.countGoodNumbers(4));
        System.out.println(Q.countGoodNumbers(5));
        System.out.println(Q.countGoodNumbers(50));
    }

    public int countGoodNumbers(long n) {
        if (n % 2 == 0) {//偶数位
            long l = n / 2;
            return (int) (Math.pow(20, l) % 1000000007);
        } else {//奇数位
            long l = (n - 1) / 2;
            return (int) ((5 * Math.pow(20, l)) % 1000000007);
        }
    }
}
