package MiddleQuestion;

import java.util.Arrays;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-25  14:05
 * @Description: TODO
 * @Version: 1.0
 */
public class Q452_用最少数量的箭引爆气球 {

    public static void main(String[] args) {
        Q452_用最少数量的箭引爆气球 Q = new Q452_用最少数量的箭引爆气球();
        System.out.println("Q.findMinArrowShots() = " + Q.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println("Q.findMinArrowShots() = " + Q.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }


    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
//        System.out.println(Arrays.deepToString(points));
        int res = 1;
        int right = points[0][1];
        for (int[] point : points) {
            if (point[0] > right) {
                res++;
                right = point[1];
            }
        }
        return res;
    }


}










