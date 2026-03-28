package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q119_杨辉三角II {

    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> getRow(int rowIndex) {
        for (int j = 0; j <= rowIndex; j++) {
            list.add(getCnk(rowIndex,j));
        }
        return list;
    }

    /**
     * 计算排列数的方法，即从n个元素中选k个元素，有多少种不同的选法
     *
     * @param n 元素总数，本题为 (1 - t) 的次方数
     * @param k 被筛选的个数，
     * @return 排列数 Cnk 的值
     */
    private static int getCnk(int n, int k) {
        if (k == 0 || k == n) return 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res *= n - i + 1;
            res /= i;
        }
        return (int) res;
    }
}
