package WeeklyContest.Week_355;

import java.util.*;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: WeeklyContest.Week_355
 * @Author: 杨思远
 * @CreateTime: 2024-04-12  20:47
 * @Description: TODO
 * @Version: 1.0
 */
public class Q2788 {

    public static void main(String[] args) {
        Q2788 obj = new Q2788();
        System.out.println("obj.splitWordsBySeparator(Arrays.asList(\"one.two.three\", \"four.five\", \"six\"), '.') = " + obj.splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.'));
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            String s = String.format("\\%s", separator);
            String[] split = word.split(s);
            for (String ss : split) {
                if (!ss.isEmpty()) {
                    result.add(ss);
                }
            }
        }
        return result;
    }


    public List<String> splitWordsBySeparator_ai(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c == separator) {
                    if (sb.length() > 0) {
                        result.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
        }
        return result;
    }

}
