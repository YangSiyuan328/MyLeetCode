package MiddleQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-09  11:21
 * @Description: <a href="https://leetcode.cn/problems/find-duplicate-file-in-system/description/" />
 * @Version: 1.0
 */
public class Q609_在系统中查找重复文件 {

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println("findDuplicate(paths) = " + findDuplicate(paths));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                StringBuilder sb = new StringBuilder();
                int index1 = files[i].indexOf("(");
                int index2 = files[i].indexOf(")");
                String key = files[i].substring(index1 + 1, index2);
                sb.append(files[0]).append("/").append(files[i], 0, index1);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(sb.toString());
                map.put(key, list);
            }
        }
        for (List<String> value : map.values()) {
            if (value.size() > 1) res.add(value);
        }
        return res;
    }

}
