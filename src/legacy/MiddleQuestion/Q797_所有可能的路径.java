package MiddleQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-09  09:42
 * @Description: <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/" />
 * @Version: 1.0
 */
public class Q797_所有可能的路径 {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println("allPathsSourceTarget(graph) =  " + allPathsSourceTarget(graph));
    }

    /**
     * 深度优先遍历
     *
     * @param graph
     * @return
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        cur.add(0);
        process(graph, 0, cur, res);
        return res;
    }

    private static void process(int[][] graph, int index, List<Integer> cur, ArrayList<List<Integer>> res) {
        // 走到最后了
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // 没走到最后
        for (int i = 0; i < graph[index].length; i++) {
            cur.add(graph[index][i]);
            process(graph, graph[index][i], cur, res);
            cur.remove(cur.size() - 1);
        }
    }


}
