package SimpleQuestion;

public class Q868_二进制间距 {

    public static void main(String[] args) {


    }

    public int binaryGap(int n) {
        int mod;
        int res = 0;
        int curIndex = 0;
        int lastIndex = -1;
        while (n > 0) {
            mod = n & 1;
            if (mod == 1) {
                if (lastIndex == -1) {
                    lastIndex = curIndex;
                } else {
                    res = Math.max(res, curIndex - lastIndex);
                    lastIndex = curIndex;
                }
            }
            curIndex++;
            n >>= 1;
        }
        return res;
    }

}
