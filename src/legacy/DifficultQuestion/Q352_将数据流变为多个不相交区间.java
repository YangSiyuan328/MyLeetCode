package DifficultQuestion;

import java.util.*;

public class Q352_将数据流变为多个不相交区间 {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println("---------------");
        summaryRanges.addNum(1);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        System.out.println("---------------");
        summaryRanges.addNum(3);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        System.out.println("---------------");
        summaryRanges.addNum(7);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        System.out.println("---------------");
        summaryRanges.addNum(2);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
        System.out.println("---------------");
        summaryRanges.addNum(6);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals()));
    }

        static class SummaryRanges {

            //因为数据范围只有10000所以考虑用数组而不是哈希表

            int[] isExist;  // 存在该位置是否有数    1代表有数，0代表没有数。所以默认没有数
            int[] start;    // 存放到该位置的开始索引
            int[] end;      // 存放该位置开开始结束的索引
            int length = 0; // 当前集合数

            public SummaryRanges() {
                isExist = new int[10001];
                start = new int[10001];
                end = new int[10001];
            }

            public void addNum(int val) {
                if (isExist[val] == 1) return; // 如果这个数已经存在，不加入
                isExist[val] = 1;
                length++; //首先默认个数独立，所以区间个数增加
                length += val == 0 ? 0 : (isExist[val - 1] == 1 ? -1 : 0); // 可以向前合并，区间个数 -1；
                length += val == 10000 ? 0 : (isExist[val + 1] == 1 ? -1 : 0); // 可以向后合并，区间个数 -1；
                // 如果前面没数，这个区间开始节点就是当前数。
                // 如果前面有数，这个区间开始节点就和前面节点开始节点相同。
                start[val] = val == 0 ? 0 : (isExist[val - 1] == 1 ? start[val - 1] : val);
                // 如果后面没数，这个区间结束节点就是当前数。
                // 如果后面有数，这个区间结束节点就和后面节点结束节点相同。
                end[val] = val == 10000 ? 10000 : (isExist[val + 1] == 1 ? end[val + 1] : val);
            }

            public int[][] getIntervals() {
                int[][] res = new int[length][2];
                int index = 0;
                boolean isStart = false; // 标记此时的索引是否在某个区间中
                for (int i = 0; i < 10001; i++) {
                    if (isExist[i] == 1 && !isStart) { // i位置为1，没有在区间中，所以进入区间
                        isStart = true;
                        res[index][0] = i;
                    }
                    if (isExist[i] == 0 && isStart) { // i位置为0，在区间中，所以前一个节点是区间的结尾
                        isStart = false;
                        res[index++][1] = i - 1;
                    }
                }
                return res;
            }
        }

    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(val);
     * int[][] param_2 = obj.getIntervals();
     */

}
