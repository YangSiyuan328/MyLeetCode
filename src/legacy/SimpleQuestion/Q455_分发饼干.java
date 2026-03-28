package SimpleQuestion;

import java.util.Arrays;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-20  14:36
 * @Description: TODO
 * @Version: 1.0
 */
public class Q455_分发饼干 {
    public static void main(String[] args) {
        Q455_分发饼干 Q = new Q455_分发饼干();
        int[] g = {10, 9, 8, 7};
        int[] s = {10, 9, 8, 7};
        System.out.println("Q = " + Q.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        int gIndex = 0;
        int sIndex = 0;
        // 对数组进行升序排序
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                sum++;
                gIndex++;
            }
            sIndex++;
        }
        return sum;
    }

}
