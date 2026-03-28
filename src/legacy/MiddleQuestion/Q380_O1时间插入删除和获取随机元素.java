package MiddleQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q380_O1时间插入删除和获取随机元素 {


}

class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> valIndexMap;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<Integer>();
        valIndexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valIndexMap.containsKey(val)) {
            return false;
        }
        list.add(list.size(), val);
        valIndexMap.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valIndexMap.containsKey(val)) {
            return false;
        }
        int index = valIndexMap.get(val);
        list.set(index, list.get(list.size() - 1));
        valIndexMap.put(list.get(index), index);
        list.remove(list.size() - 1);
        valIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */