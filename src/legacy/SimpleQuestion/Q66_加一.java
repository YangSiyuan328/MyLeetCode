package SimpleQuestion;

public class Q66_加一 {

    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        for (int i = len; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] arr = new int[len + 2];
        arr[0] = 1;
        return arr;
    }

    public int[] plusOne1(int[] digits) {
        int l = digits.length;
        boolean flag = true;
        for (int digit : digits) {
            if (digit != 9) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] res = new int[l + 1];
            res[0] = 1;
            return res;
        }
        if (digits[l - 1] == 9) {
            for (int i = l - 1; i >= 0; i--) {
                if (digits[i] > 8) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    break;
                }
            }
        } else {
            digits[l - 1] += 1;
        }
        return digits;
    }

}
