package WeeklyContest.Other;

public class Q5782 {
    public static void main(String[] args) {
        Q5782 Q = new Q5782();
        System.out.println(Q.maxAlternatingSum(new int[]{4, 2, 5, 3}));
        System.out.println(Q.maxAlternatingSum(new int[]{5, 6, 7, 8}));
        System.out.println(Q.maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5}));
    }

    public long maxAlternatingSum(int[] nums) {
        int l = nums.length;
        int max = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    if ((k-i) % 2 == 0) {
                        sum += nums[k];
                    } else {
                        sum -= nums[k];
                    }
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
