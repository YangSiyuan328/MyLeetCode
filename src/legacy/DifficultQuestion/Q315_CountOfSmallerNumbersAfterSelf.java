package DifficultQuestion;

import java.util.*;

class Q315_CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Q315_CountOfSmallerNumbersAfterSelf Q = new Q315_CountOfSmallerNumbersAfterSelf();
        Q.countSmaller(new int[]{5, 2, 6, 1});
    }

    public List<Integer> countSmaller(int[] nums) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap();
        for (int num : nums) {
            linkedHashMap.put(num, 0);
        }
        process(nums, 0, nums.length - 1, linkedHashMap);
        /*for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + "   value:" + entry.getValue());
        }*/
        ArrayList<Integer> list = new ArrayList<>();
        linkedHashMap.forEach((key,value)->{
            list.add(value);
        });
        return list;
    }

    public void process(int[] nums, int L, int R, Map<Integer, Integer> map) {
        if (L == R) return;
        int M = L + ((R - L) >> 1);
        process(nums, L, M, map);
        process(nums, M + 1, R, map);
        merge(nums, L, M, R, map);
    }

    public void merge(int[] nums, int L, int M, int R, Map<Integer, Integer> map) {
        int index = M + 1;
        for (int i = L; i <= M; i++) {
            while (index <= R && nums[i] > nums[index]) {
                index++;
            }
            map.put(nums[i], map.get(nums[i]) + index - M - 1);
        }
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= M) {
            help[i++] = nums[p1++];
        }
        while (p2 <= R) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[L + i] = help[i];
        }
    }
}
