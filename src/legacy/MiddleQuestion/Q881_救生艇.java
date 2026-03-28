package MiddleQuestion;

import java.util.Arrays;

public class Q881_救生艇 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int index1 = 0;
        int index2 = people.length - 1;
        int res = 0;
        while (index1 <= index2) {
            if (people[index2] == limit) {
                res++;
                index2--;
            } else if (people[index1] + people[index2] <= limit) {
                res++;
                index1++;
                index2--;
            } else {
                res++;
                index2--;
            }
        }
        return res;
    }

}
