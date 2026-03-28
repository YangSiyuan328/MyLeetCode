package SimpleQuestion;

public class Q476_数字的补数 {

    public int findComplement(int num) {
        int temp = num, c = 0;
        while(temp > 0){
            temp >>= 1;
            c =  (c << 1) + 1;
        }
        return num ^ c;
    }

    public int findComplement1(int num) {
        int ans = 0;
        int i = 31;
        while ((num >> i & 1) == 0) {
            i--;
        }
        for (; i >= 0; i--) {
            int j = (num >> i & 1) == 0 ? 1 : 0;
            ans |= j << i;
        }
        return ans;
    }

}
