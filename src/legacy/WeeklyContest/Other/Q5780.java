package WeeklyContest.Other;

public class Q5780 {
    public static void main(String[] args) {
        Q5780 Q = new Q5780();
        System.out.println(Q.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(Q.canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(Q.canBeIncreasing(new int[]{1, 1, 1}));
        System.out.println(Q.canBeIncreasing(new int[]{1, 2, 3}));
        System.out.println(Q.canBeIncreasing(new int[]{105, 924, 32, 968}));
        System.out.println(Q.canBeIncreasing(new int[]{13, 205, 553, 527, 790, 238}));
        System.out.println(Q.canBeIncreasing(new int[]{512, 867, 904, 997, 403}));

    }

    public boolean canBeIncreasing(int[] nums) {
        int l = nums.length;
        if (l < 3) return true;
        int count = 0;
        if (nums[0] >= nums[1]) {
            nums[0] = nums[1] - 1;
            count++;
        }
        if (nums[l - 2] >= nums[l - 1]) {
            nums[l - 1] = nums[l - 2] + 1;
            count++;
        }
        if (count > 1) return false;
        for (int i = 0; i < l - 2; i++) {

            if (nums[i] >= nums[i + 1]) {
                count++;
                //删除下一个数
                if (nums[i - 1] >= nums[i + 1]) {
                    if (i + 2 < l && nums[i] > nums[i + 2]) {
                        count++;
                    }
                } else {// 删除当前数

                }

            }

        }
        return count <= 1;
    }
}
