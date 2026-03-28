package DifficultQuestion;

public class Q1036_逃离大迷宫 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int x = source[0], y = source[1];
        int x0 = target[0], y0 = target[1];
        double l0 = Math.pow(Math.pow(x - x0, 2) + Math.pow(y - y0, 2), 0.5);
        for (int[] ints : blocked) {
            double l = Math.pow(Math.pow(x - x0 + ints[0], 2) + Math.pow(y - y0 + ints[1], 2), 0.5);
            if (l < l0) return false;
        }
        return true;
    }
}
