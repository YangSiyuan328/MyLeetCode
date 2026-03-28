package DifficultQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q282_给表达式添加运算符 {

    public static void main(String[] args) {
        Q282_给表达式添加运算符 Q = new Q282_给表达式添加运算符();
        // List<String> list = Q.addOperators("123", 6);
        List<String> list = Q.addOperators("105", 5);
        for (String s : list) {
            System.out.println(s);
        }
    }

    ArrayList<String> list = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        char[] nums = num.toCharArray();
        process(nums, 1, Integer.parseInt(String.valueOf(nums[0])), target, new StringBuffer().append(nums[0]));
        process1(nums, 1, Integer.parseInt(String.valueOf(nums[0])), target, nums[0]+"");
        return list;
    }

    private void process1(char[] nums, int i, int curAns, int target, String s) {
        if (i == nums.length) {
            if (curAns == target) {
                list.add(s);
            }
            return;
        }
        int num = Integer.parseInt(String.valueOf(nums[i]));
        // 加
        process1(nums, i + 1, curAns + num, target, s + "+" + num);
        // 减
        process1(nums, i + 1, curAns - num, target, s + "-" + num);
        // 乘  2*i-1是字符串长度 2*i-3是前一个符号的位置  2 * i - 3 > 0 ==>  i << 1 > 3
        if (i << 1 > 3) {
            int numBefore = Integer.parseInt(String.valueOf(nums[i - 1]));
            if (s.charAt(2 * i - 3) == '+') {
                curAns += (num - 1) * numBefore;
            }
            if (s.charAt(2 * i - 3) == '-') {
                curAns -= (num - 1) * numBefore;
            }
            if (s.charAt(2 * i - 3) == '*') {
                curAns *= num;
            }
        } else {
            curAns *= num;
        }
        process1(nums, i + 1, curAns, target, s + "*" + num);
    }

    private void process(char[] nums, int i, int curAns, int target, StringBuffer sb) {
        if (i == nums.length) {
            if (curAns == target) {
                list.add(sb.toString());
            }
            return;
        }
        int num = Integer.parseInt(String.valueOf(nums[i]));
        // 加
        process(nums, i + 1, curAns + num, target, sb.append("+").append(num));
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        // 减
        process(nums, i + 1, curAns - num, target, sb.append("-").append(num));
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        // 乘  2*i-1是字符串长度 2*i-3是前一个符号的位置  2 * i - 3 > 0 ==>  i << 1 > 3
        if (i << 1 > 3) {
            int numBefore = Integer.parseInt(String.valueOf(nums[i - 1]));
            if (sb.charAt(2 * i - 3) == '+') {
                curAns += (num - 1) * numBefore;
            }
            if (sb.charAt(2 * i - 3) == '-') {
                curAns -= (num - 1) * numBefore;
            }
            if (sb.charAt(2 * i - 3) == '*') {
                curAns *= num;
            }
        } else {
            curAns *= num;
        }
        process(nums, i + 1, curAns, target, sb.append("*").append(num));
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
    }
}