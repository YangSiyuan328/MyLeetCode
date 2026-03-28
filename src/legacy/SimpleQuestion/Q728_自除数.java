package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q728_自除数 {

    public static void main(String[] args) {
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSDN(i)) list.add(i);
        }
        return list;
    }

    public static boolean isSDN(int number) {
        int n = number;
        while (n > 0) {
            if (n % 10 == 0 || number % (n % 10) != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }


}
