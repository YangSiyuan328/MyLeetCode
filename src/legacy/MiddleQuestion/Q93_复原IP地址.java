package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-12  15:20
 * @Description: TODO
 * @Version: 1.0
 */
public class Q93_复原IP地址 {

    public static void main(String[] args) {

    }

    ArrayList<String> ipAddressesList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        char[] ipCharArray = s.toCharArray();
        process(ipCharArray, 0, 0, new StringBuilder(), 0);
        return ipAddressesList;
    }

    private void process(char[] ipCharArray, int index, int ip, StringBuilder sb, int count) {
        if (count == 4) {
            ipAddressesList.add(sb.toString());
            sb = new StringBuilder();
            count = 0;
        }
        if (index == ipCharArray.length) {
            return;
        }
        // 直接添加这个数

        process(ipCharArray, index + 1, ip,sb , count + 1);
        // 拼接一位


    }
}
