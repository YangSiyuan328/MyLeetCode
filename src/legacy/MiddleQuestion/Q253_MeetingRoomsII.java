package MiddleQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q253_MeetingRoomsII {
    public static void main(String[] args) {
        Q253_MeetingRoomsII Q = new Q253_MeetingRoomsII();
        int[][] intervals = {{1, 5}, {8, 9}, {8, 9}};
        System.out.println(Q.minMeetingRooms(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> arr = new ArrayList<>();
        int endTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < endTime) {
                arr.add(intervals[i]);
            } else {
                endTime = intervals[i][1];
            }
        }
        return 1 + (arr.size() == 0 ? 0 : getMeetingRooms(arr));
    }

    private static int getMeetingRooms(ArrayList<int[]> arr) {
        ArrayList<int[]> help = new ArrayList<>();
        int endTime = arr.get(0)[1];
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i)[0] < endTime) {
                help.add(arr.get(i));
            } else {
                endTime = arr.get(i)[1];
            }
        }
        return 1 + (help.size() == 0 ? 0 : getMeetingRooms(help));
    }
}
