package MiddleQuestion;

import java.util.Arrays;

public class Q1986_完成任务的最少工作时间段 {

    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int ans = 0;
        int L = 0;
        int R = tasks.length - 1;
        int surplusTime = sessionTime;
        while (L <= R) {
            while (L < R && tasks[L] <= surplusTime) {
                if (tasks[R] <= surplusTime) {
                    surplusTime -= tasks[R--];
                } else { // tasks[L] <= surplusTime
                    surplusTime -= tasks[L++];
                }
            }
            if (L == R) {
                if (tasks[L] <= surplusTime) {
                    return ans + 1;
                } else {
                    return ans + 2;
                }
            }
            surplusTime = sessionTime;
            ans++;
        }
        return ans;
    }

}
