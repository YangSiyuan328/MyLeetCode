package 剑指Offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer45_把数组排成最小的数 {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public String minNumber1(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort(((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        return String.join("", list);
    }

}
