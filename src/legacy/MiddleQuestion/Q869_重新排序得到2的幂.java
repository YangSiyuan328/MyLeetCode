package MiddleQuestion;

import java.util.ArrayList;

public class Q869_重新排序得到2的幂 {

    public boolean reorderedPowerOf2(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        return getInt(list, 0);
    }

    public boolean getInt(ArrayList<Integer> list, int curNum) {
        if (list.isEmpty()) return PowerOf2(curNum);
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            Integer remove = list.remove(i);
            if (curNum == 0 && remove == 0) {
                list.add(i, remove);
                continue;
            }
            flag |= getInt(list, curNum * 10 + remove);
            if (flag) return true;
            list.add(i, remove);
        }
        return flag;
    }

    public boolean PowerOf2(int n) {
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

}
