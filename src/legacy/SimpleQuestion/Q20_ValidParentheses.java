package SimpleQuestion;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q20_ValidParentheses {
    public static void main(String[] args) {
        Q20_ValidParentheses Q = new Q20_ValidParentheses();
        System.out.println(Q.isValid("){"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
    /*
    public boolean isValid(String s) {
        int l = s.length();
        if (l % 2 == 1) {
            return false;
        }
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                // 进栈
                stack.push(c[i]);
            } else {
                if (stack.empty()){
                    return false;
                }
                if (c[i] == ')') {
                    // 出栈
                    Character p = stack.pop();
                    if (p != '(') {
                        return false;
                    }
                }
                if (c[i] == '}') {
                    // 出栈
                    Character p = stack.pop();
                    if (p != '{') {
                        return false;
                    }
                }
                if (c[i] == ']') {
                    // 出栈
                    Character p = stack.pop();
                    if (p != '[') {
                        return false;
                    }
                }

            }
        }
        // 判断是否为空
        return stack.empty();
    }
    */
}
