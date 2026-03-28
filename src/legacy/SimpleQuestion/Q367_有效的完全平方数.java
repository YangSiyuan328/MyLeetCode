package SimpleQuestion;

public class Q367_有效的完全平方数 {

    // [1+(2n-1)]*n/2 ==num
    //   1+(2n-1) == 2*num/n
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        for (int i = 2; i <= 46340 && i * i <= num; i++){
            if ( i * i == num) return true;
        }
        return false;
    }

}
