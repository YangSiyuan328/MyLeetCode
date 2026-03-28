package SimpleQuestion;

//一周28
public class Q1716_计算力扣银行的钱 {

    public static void main(String[] args) {
        Q1716_计算力扣银行的钱 Q = new Q1716_计算力扣银行的钱();
        int i = Q.totalMoney(26);
        System.out.println(i);
    }

    public int totalMoney(int n) {
        if (n < 7) return (1 + n) * n / 2;
        int mod = n % 7;
        int c = n / 7;
        int res = 0;
        res += c * 28 + 7 * (c - 1) * c / 2; // 7/2*(c*c-c)
        res += ((c + 1) + (c + mod)) * mod / 2;
        return res;
    }

    public int totalMoney1(int n) {
        if (n < 7) return (1 + n) * n / 2;
        int mod = n % 7;
        int c = n / 7;
        int res = 0;
        res += c * 28 + 7 * (c * c - c) / 2;
        res += (2 * c + mod + 1) * mod / 2;
        return res;
    }
}
