package 剑指Offer;

public class Offer64_求合1到n {

    public int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }

}
