package MiddleQuestion;

public class Q478_在圆内随机生成点 {

    class Solution {
        double r0, x0, y0, dx, dy;

        public Solution(double radius, double x_center, double y_center) {
            r0 = radius;
            x0 = x_center;
            y0 = y_center;
            dx = x0 - r0;
            dy = y0 - r0;
        }

        public double[] randPoint() {
            double xl = 2 * Math.random() * r0;
            double yl = 2 * Math.random() * r0;
            double x = dx + xl;
            double y = dy + yl;
            double r = Math.pow(Math.pow(x - x0, 2) + Math.pow(y - y0, 2), 0.5);
            return r < r0 ? new double[]{x, y} : randPoint();
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
}
