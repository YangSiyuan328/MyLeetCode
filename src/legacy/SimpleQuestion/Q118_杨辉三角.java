package SimpleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q118_杨辉三角 {

    ArrayList<List<Integer>> lists = new ArrayList<>();


    public List<List<Integer>> generate(int numRows) {
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(getCnk(i,j));
            }
            lists.add(new ArrayList<>(list));
        }
        return lists;
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
        int res = 1;
        for (int i = 1; i <= k; i++) {
            res *= n - i + 1;
            res /= i;
        }
        return res;
    }

}
