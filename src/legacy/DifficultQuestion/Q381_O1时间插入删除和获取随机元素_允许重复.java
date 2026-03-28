package DifficultQuestion;

import java.util.*;

public class Q381_O1时间插入删除和获取随机元素_允许重复 extends Object{

    /*
    ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
    [[],[4],[3],[4],[2],[4],[4],[3],[4],[4]]
     */
    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        System.out.println(r.insert(4));
        System.out.println(r.insert(3));
        System.out.println(r.insert(4));
        System.out.println(r.insert(2));
        System.out.println(r.insert(4));
        System.out.println(r.remove(4));
        System.out.println(r.remove(3));
        System.out.println(r.remove(4));
        System.out.println(r.remove(4));

    }
}

class RandomizedCollection {

    ArrayList<Integer> lists;

    HashMap<Integer, TreeSet<Integer>> valIndexMap;

    Random random;

    public RandomizedCollection() {
        lists = new ArrayList<>();
        valIndexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!valIndexMap.containsKey(val)) {
            lists.add(val);
            TreeSet<Integer> set = new TreeSet<>();
            set.add(lists.size() - 1);
            valIndexMap.put(val, set);
            return true;
        } else {
            TreeSet<Integer> set = valIndexMap.get(val);
            lists.add(val);
            set.add(lists.size() - 1);
            return false;
        }
    }

    public boolean remove(int val) {
        if (!valIndexMap.containsKey(val)) {
            return false;
        } else {
            TreeSet<Integer> delIndex = valIndexMap.get(val);
            int index = delIndex.iterator().next();
            int lastIndex = lists.size() - 1;
            lists.set(index, lists.get(lastIndex));
            TreeSet<Integer> moveIndex = valIndexMap.get(lists.get(lastIndex));
            if (delIndex.size() > 1) {
                delIndex.remove(index);
            } else {
                valIndexMap.remove(val);
            }
            moveIndex.remove(lastIndex);
            moveIndex.add(index);
            lists.remove(lastIndex);
            return true;
        }
    }

    public int getRandom() {
        return lists.get(random.nextInt(lists.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */