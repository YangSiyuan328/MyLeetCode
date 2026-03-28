package MiddleQuestion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-25  11:17
 * @Description: TODO
 * @Version: 1.0
 */
public class Q406_根据身高重建队列 {

    public static void main(String[] args) {
        Q406_根据身高重建队列 Q = new Q406_根据身高重建队列();
//        System.out.println("Q.lemonadeChange({5,5,5,10,20}) = " + Arrays.deepToString(Q.reconstructQueue(new int[][]{{7, 1}, {4, 4}, {7, 0}, {5, 0}, {6, 1}, {5, 2}})));
        System.out.println("Q.lemonadeChange({5,5,5,10,20}) = " + Arrays.deepToString(Q.reconstructQueue(new int[][]{
                {9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}
        })));
    }

    public int[][] reconstructQueue(int[][] people) {
//        if (people == null || people.length == 0) return people;
        Arrays.sort(people, (o1, o2) -> {
            if (o2[0] == o1[0]) return o1[1] - o2[1];
            else return o2[0] - o1[0];
        });
//        System.out.println(Arrays.deepToString(people));
        ArrayList<int[]> resArrayList = new ArrayList<>();
        for (int[] person : people) {
            resArrayList.add(person[1], person);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = resArrayList.get(i);
        }
        return resArrayList.toArray(new int[people.length][]);
    }

}
















