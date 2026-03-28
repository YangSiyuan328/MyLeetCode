package WeeklyContest.Week_393;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: WeeklyContest.Week_393
 * @Author: 杨思远
 * @CreateTime: 2024-04-13  21:31
 * @Description: TODO
 * @Version: 1.0
 * 给你一个字符串 s，表示一个 12 小时制的时间格式，其中一些数字（可能没有）被 "?" 替换。
 * <p>
 * 12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，MM 的取值范围为 00 至 59。最早的时间为 00:00，最晚的时间为 11:59。
 * <p>
 * 你需要将 s 中的 所有 "?" 字符替换为数字，使得结果字符串代表的时间是一个 有效 的 12 小时制时间，并且是可能的 最晚 时间。
 * <p>
 * 返回结果字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "1?:?4"
 * <p>
 * 输出： "11:54"
 * <p>
 * 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "11:54"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "0?:5?"
 * <p>
 * 输出： "09:59"
 * <p>
 * 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "09:59"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * s.length == 5
 * s[2] 是字符 ":"
 * 除 s[2] 外，其他字符都是数字或 "?"
 * 输入保证在替换 "?" 字符后至少存在一个介于 "00:00" 和 "11:59" 之间的时间。
 */
public class Q3109 {

    public static void main(String[] args) {
        Q3109 obj = new Q3109();
        System.out.println(obj.findLatestTime("1?:?4"));  // 输出： "11:54"
        System.out.println(obj.findLatestTime("0?:5?"));  // 输出： "09:59"
        System.out.println(obj.findLatestTime("??:5?"));  // 输出： "09:59"
        System.out.println(obj.findLatestTime("??:??"));  // 输出： "09:59"
        System.out.println(obj.findLatestTime("??:1?"));  // 输出： "09:59"
    }


    public String findLatestTime(String s) {
        char[] time = s.toCharArray();
        if (time[0] == '?') {
            if (time[1] == '?') {
                time[0] = '1';
                time[1] = '1';
            } else if (time[1] <= '1') {
                time[0] = '1';
            } else {
                time[0] = '0';
            }
        } else if (time[0] == '0') {
            if (time[1] == '?') {
                time[1] = '9';
            }
        } else if (time[0] == '1') {
            if (time[1] == '?') {
                time[1] = '1';
            }
        }
        if (time[3] == '?') {
            time[3] = '5';
        }
        if (time[4] == '?') {
            time[4] = '9';
        }
        return new String(time);
    }

}
