package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q229_求众数II {

    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> majorityElement(int[] nums) {
        int A = 0, B = 0, countA = 0, countB = 0;
        for (int num : nums) {
            if ((countA == 0 || num == A) && num != B) {
                countA++;
                A = num;
            } else if (countB == 0 || num == B) {
                countB++;
                B = num;
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int num : nums) { // 这里 if 比三元快1ms
            if (num == A) countA++;
            else if (num == B) countB++;
        }
        if (countA > nums.length / 3) list.add(A);
        if (A != B && countB > nums.length / 3) list.add(B);
        return list;
    }

}
