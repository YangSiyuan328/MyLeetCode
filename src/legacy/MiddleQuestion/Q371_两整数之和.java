package MiddleQuestion;

public class Q371_两整数之和 {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

}
