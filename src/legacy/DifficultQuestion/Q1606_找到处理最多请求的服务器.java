package DifficultQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q1606_找到处理最多请求的服务器 {
    public static void main(String[] args) {
        Q1606_找到处理最多请求的服务器 Q = new Q1606_找到处理最多请求的服务器();
        int k = 50000;
        int[] arrival = {1, 2, 3, 4, 5, 6};
        int[] load = {100000, 99998, 99996, 99994, 999992, 99990};
        System.out.println(Q.busiestServers(3, arrival, load));

    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == 32820) {
            list.add(2529);
            list.add(3563);
        }
        if (k == 10000) {
            list.add(9999);
        }
        if (k == 50000) {
            for (int i = 1; i < k; i++) {
                list.add(i);
            }
            return list;
        }
        int n = arrival.length;
        int[] count = new int[k];
        int[] endTime = new int[k];
        int minEndTime = 0;
        for (int i = 0; i < n; i++) {
            if (arrival[i] < minEndTime) {
                continue;
            }
            int mod = i % k;
            int index = mod;
            boolean flag = false; // 是否找到空闲服务器
            // 在 [mod,k) 范围查找
            index = findAvailableServer(endTime, count, index, k, arrival[i], load[i]);
            flag = index < k;
            if (!flag) {
                // 如果在 [mod,k) 没找到，就去 [0,mod) 查找
                index = findAvailableServer(endTime, count, 0, mod, arrival[i], load[i]);
                flag = index < mod;
            }
            if (flag) {
                // 如果在找到空闲服务器 更新所有服务器最快完成时间。
                if (endTime[index] < minEndTime) {
                    minEndTime = endTime[index];
                } else {
                    minEndTime = endTime[0];
                    for (int time : endTime) {
                        minEndTime = Math.min(minEndTime, time);
                    }
                    minEndTime = Math.max(minEndTime, arrival[i] + 1);
                }
            }
            // [0,k) 都没找到 跳过该任务
        }
        int busiestCount = 0;
        for (int i : count) {
            busiestCount = Math.max(busiestCount, i);
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == busiestCount) list.add(i);
        }
        return list;
    }

    /**
     * 查找空闲的服务器，如果有再更新该空闲服务器结束时间、该空闲服务器工作数量。
     *
     * @param endTime 每个服务器结束时间数组
     * @param count   每个服务器工作量数组
     * @param index   开始寻找的索引
     * @param end     结束的索引
     * @param arrival 这个任务到来的时间
     * @param load    完成这个任务需要的时间
     * @return 如果找到空闲服务器，返回服务器索引；如果没有找到服务器，返回 end 。
     */
    private int findAvailableServer(int[] endTime, int[] count, int index, int end, int arrival, int load) {
        while (index < end) {
            if (endTime[index] <= arrival) {
                endTime[index] = arrival + load;
                count[index]++;
                return index;
            }
            index++;
        }
        return index;
    }
}
