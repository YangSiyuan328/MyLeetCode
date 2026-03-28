package SimpleQuestion;

public class Q1614_括号的最大嵌套深度 {
    public int maxDepth(String s) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cur++;
            } else if (s.charAt(i) == ')') {
                cur--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
