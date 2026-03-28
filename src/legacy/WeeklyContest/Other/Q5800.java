package WeeklyContest.Other;

public class Q5800 {
    public static void main(String[] args) {
        Q5800 Q = new Q5800();
        Q.buildArray(new int[]{0,2,1,5,3,4});

    }

    public int[] buildArray(int[] nums) {
        int l = nums.length;
        if (l<2) return nums;
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            System.out.println(nums[i]);
            arr[i]=nums[nums[i]];
        }
        return arr;
    }
}
