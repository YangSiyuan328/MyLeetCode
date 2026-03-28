package 面试题;

import java.util.ArrayList;
import java.util.List;

public class Q08_06_汉诺塔问题 {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        Q08_06_汉诺塔问题 Q = new Q08_06_汉诺塔问题();
        Q.hanota(A, B, C);
        for (Integer integer : C) {
            System.out.println(integer);
        }
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, C, B);
    }

    private void move(int N, List<Integer> from, List<Integer> to, List<Integer> other) {
        if (N == 1) {
            to.add(from.remove(from.size() - 1));
        } else {
            move(N - 1, from, other, to);
            to.add(from.remove(from.size() - 1));
            move(N - 1, other, to, from);
        }
    }
}
