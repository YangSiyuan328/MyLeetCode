package WeeklyContest.Week265;

import java.util.ArrayList;

public class Q5915 {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode preOne = head;
        ListNode midOne = preOne.next;
        ListNode lastOne = midOne.next;
        int length = 1;
        while (lastOne != null) {
            if (midOne.val > preOne.val && midOne.val > lastOne.val) list.add(length);
            if (midOne.val < preOne.val && midOne.val < lastOne.val) list.add(length);
            length++;
            preOne = midOne;
            midOne = lastOne;
            lastOne = midOne.next;
        }
        int listLength = list.size();
        if (listLength < 2) return new int[]{-1, -1};
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < listLength; i++) {
            minDistance = Math.min(list.get(i) - list.get(i - 1), minDistance);
        }
        return new int[]{minDistance, list.get(listLength - 1) - list.get(0)};
    }
}
