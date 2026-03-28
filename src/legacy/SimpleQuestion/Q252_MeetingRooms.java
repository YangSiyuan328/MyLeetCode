package SimpleQuestion;

import java.util.Arrays;
import java.util.Comparator;

public class Q252_MeetingRooms {
    public static void main(String[] args) {
        Q252_MeetingRooms Q = new Q252_MeetingRooms();
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(Q.canAttendMeetings(intervals));
        System.out.println(Arrays.deepToString(intervals));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        //Arrays.sort(intervals, comparator);
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }

    Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        }
    };


}
