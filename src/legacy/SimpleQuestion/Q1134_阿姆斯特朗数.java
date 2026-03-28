package SimpleQuestion;

import java.util.ArrayList;

public class Q1134_阿姆斯特朗数 {

    public boolean isArmstrong(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = n;
        int mod;
        while (a > 0) {
            mod = a % 10;
            list.add(mod);
            a /= 10;
        }
        int l = list.size();
        for (Integer integer : list) {
            a += Math.pow(integer, l);
        }
        return a == n;
    }

}
