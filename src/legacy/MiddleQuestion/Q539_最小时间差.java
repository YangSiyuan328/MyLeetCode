package MiddleQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q539_最小时间差 {

    public static void main(String[] args) {
        Q539_最小时间差 Q = new Q539_最小时间差();
        ArrayList<String> list = new ArrayList<>();
        //["00:00","04:00","22:00"]
        list.add("00:00");
        list.add("04:00");
        list.add("22:00");
        System.out.println(Q.findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] time = new int[size];
        int index = 0;
        for (String str : timePoints) {
            int m = ((str.charAt(0) - '0') * 10 + (str.charAt(1) - '0')) * 60 + (str.charAt(3) - '0') * 10 + str.charAt(4) - '0';
            time[index++] = m;
        }
        Arrays.sort(time);
        int i = time[0];
        int cur = time[0] + 1440 - time[size - 1];
        int min = cur;
        for (int j = 1; j < time.length; j++) {
            cur = time[j] - i;
            min = Math.min(min, cur);
            i = time[j];
        }
        return min;
    }
}
