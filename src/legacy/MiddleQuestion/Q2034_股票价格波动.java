package MiddleQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2034_股票价格波动 {
    /*
    ["StockPrice","update","maximum","current","minimum","update","maximum","minimum","update","maximum","minimum","current","update","minimum","maximum","update","maximum","current","update","current","minimum","update","update","maximum","minimum","update","current","update","maximum","update","minimum"]
    [[],[38,2308],[],[],[],[47,7876],[],[],[58,1866],[],[],[],[43,121],[],[],[40,5339],[],[],[32,5339],[],[],[43,6414],[49,9369],[],[],[36,3192],[],[48,1006],[],[53,8013],[]]
     */
    public static void main(String[] args) {
        StockPrice sp = new StockPrice();
        sp.update(38, 2308);
        System.out.println(sp.maximum());
        System.out.println(sp.current());
        System.out.println(sp.minimum());
        sp.update(47, 7876);
        System.out.println(sp.maximum());
        System.out.println(sp.minimum());
        sp.update(58, 1866);
        System.out.println(sp.maximum());
        System.out.println(sp.minimum());
        System.out.println(sp.current());
        sp.update(43, 121);
        System.out.println(sp.minimum());
        System.out.println(sp.maximum());
        sp.update(40, 5339);
        System.out.println(sp.maximum());
        System.out.println(sp.current());//
        sp.update(32, 5339);
        System.out.println(sp.current());//
        System.out.println(sp.minimum());
        sp.update(43, 6414);
        sp.update(49, 9369);
        System.out.println(sp.maximum());
        System.out.println(sp.minimum());
        sp.update(36, 3192);
        System.out.println(sp.current());//
        sp.update(48, 1006);
        System.out.println(sp.maximum());
        sp.update(53, 8013);
        System.out.println(sp.minimum());


    }
    //超时
    static class StockPrice {
        private int max;
        private int min;
        private int cur;
        private int curTime;
        private Map<Integer, Integer> map;

        public StockPrice() {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            cur = Integer.MAX_VALUE;
            curTime = -1;
            map = new HashMap<>();
        }

        public void update(int timestamp, int price) {
            if (timestamp >= curTime) {
                curTime = timestamp;
                cur = price;
            }
            boolean b = map.containsKey(timestamp);
            int help = b ? map.get(timestamp) : -1;
            map.put(timestamp, price);
            if (b) {
                Set<Integer> keys = map.keySet();
                if (help == max) {
                    max = Integer.MIN_VALUE;
                    for (int key : keys) {
                        max = Math.max(max, map.get(key));
                    }
                }
                if (help == min) {
                    min = Integer.MAX_VALUE;
                    for (int key : keys) {
                        min = Math.min(min, map.get(key));
                    }
                }
            }
            max = Math.max(max, price);
            min = Math.min(min, price);
        }

        public int current() {
            return cur;
        }

        public int maximum() {
            return max;
        }

        public int minimum() {
            return min;
        }
    }
}
