package WeeklyContest.Other;

public class Q5792 {
    public static void main(String[] args) {
        Q5792 Q = new Q5792();
        System.out.println(Q.countTriples(5));
        System.out.println(Q.countTriples(10));
    }

    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        count += 2;
                    }
                }
            }
        }
        return count;
    }
}
