package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q89_格雷编码 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        return process(n, list);
    }

    private List<Integer> process(int n, ArrayList<Integer> list) {
        int size = list.size();
        if (size == 1 << n) return list;
        for (int i = size - 1; i >= 0; i--) {
            list.add(list.get(i) + size);
        }
        return process(n, list);
    }

    public int[] grayCode1(int n) {
        return grayCodeProcess(n, new int[]{0});
    }

    public int[] grayCodeProcess(int n, int[] arr) {
        int l = arr.length;
        if (l == 1 >> n) return arr;
        int[] cur = new int[l >> 1];
        for (int i = 0; i < l; i++) {
            cur[i] = arr[i];
            cur[2 * l - i - 1] = cur[i] + l;
        }
        return grayCodeProcess(n, cur);
    }
}
