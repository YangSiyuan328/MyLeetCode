package MiddleQuestion;

public class Q1894_找到需要补充粉笔的学生编号 {

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) return i;
        }
        return -1;
    }

}
