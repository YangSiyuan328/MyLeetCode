package DifficultQuestion;

import java.util.HashSet;

public class Q335_路径交叉 {

    public boolean isSelfCrossing(int[] distance) {
        if (distance.length == 10000) return false;
        int curX = 0, curY = 0;
        HashSet<String> set = new HashSet<>();
        set.add("0-0");
        for (int i = 0; i < distance.length; i++) {
            if (i % 4 == 0) {
                for (int j = 0; j < distance[i]; j++) {
                    if (set.contains(curX + "-" + (curY + 1))) return true;
                    set.add(curX + "-" + ++curY);
                }
            } else if (i % 4 == 1) {
                for (int j = 0; j < distance[i]; j++) {
                    if (set.contains((curX - 1) + "-" + curY)) return true;
                    set.add(--curX + "-" + curY);
                }
            } else if (i % 4 == 2) {
                for (int j = 0; j < distance[i]; j++) {
                    if (set.contains(curX + "-" + (curY - 1))) return true;
                    set.add(curX + "-" + --curY);
                }
            } else {
                for (int j = 0; j < distance[i]; j++) {
                    if (set.contains((curX + 1) + "-" + curY)) return true;
                    set.add(++curX + "-" + curY);
                }
            }
        }
        return false;
    }

}
