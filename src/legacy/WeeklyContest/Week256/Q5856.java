package WeeklyContest.Week256;

import javax.swing.text.StyledEditorKit;
import java.util.Arrays;

public class Q5856 {

    public static void main(String[] args) {
        System.out.println(minSessions(new int[]{3, 1, 3, 1, 1}, 8));
        System.out.println(minSessions(new int[]{9, 6, 9}, 14));

    }

    public static int minSessions(int[] tasks, int sessionTime) {
        return process(tasks, sessionTime, 0, tasks.length - 1, 0);
    }

    private static int process(int[] tasks, int sessionTime, int x, int y, int count) {
        if (x > y) return 0;
        if (tasks[x] + tasks[y] == sessionTime) {
            x++;
            y--;
            count++;
        } else if (tasks[x] + tasks[y] > sessionTime) {
            y--;
            count++;
        } else {
            count += process(tasks, sessionTime, x++, y--, count);
        }
        count += process(tasks, sessionTime, x + 1, y - 1, count);
        return count;
    }


}
