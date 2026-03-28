package MiddleQuestion;

public class Q260_只出现一次的数字III {

    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        int rightOne = eor & ((~eor) + 1);
        int eor1 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor1 ^= num;
            }
        }
        return new int[]{eor1, eor ^ eor1};
    }

}
