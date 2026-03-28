package DifficultQuestion;

class Q115_DistinctSubsequences {

    public static void main(String[] args) {
        Q115_DistinctSubsequences Q = new Q115_DistinctSubsequences();
        System.out.println(Q.numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
    }

    public int numDistinct(String s, String t) {
        if (t == null) return 1;
        return process(s.toCharArray(), 0, t, "");
    }


    public static int process(char[] str, int i, String t, String path) {
        if (i == str.length) {
            return t.equals(path) ? 1 : 0;
        }
        //分支限界法
        int ans1 = 0, ans2 = 0;
        // 不添加 index 位置元素
        ans1 = process(str, i + 1, t, path);
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                // 添加 index 位置元素
                ans2 = process(str, i + 1, t, path + str[i]);
            }
        }
        return ans1 + ans2;
    }

}

