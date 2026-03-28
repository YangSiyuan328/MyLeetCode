import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Code01_simplifyThePath {

    // for test
    public static void main(String[] args) {
        String path1 = "/home/";
        String path2 = "/../";
        String path3 = "/home//foo/";
        String path4 = "/a/./b/../../c/";
        String path5 = "/a/../../b/..//c//.//";
        String path6 = "/a//b////c/d//././/..";
        System.out.println("示例1结果：" + simplifyThePath(path1));
        System.out.println("示例2结果：" + simplifyThePath(path2));
        System.out.println("示例3结果：" + simplifyThePath(path3));
        System.out.println("示例4结果：" + simplifyThePath(path4));
        System.out.println("示例5结果：" + simplifyThePath(path5));
        System.out.println("示例6结果：" + simplifyThePath(path6));
    }

    private static String simplifyThePath(String path) {
        if (path == null || path.length() <= 1) return "/";
        Stack<String> stack = new Stack<>();
        char[] str = path.toCharArray();
        StringBuilder helpSB = new StringBuilder();
        StringBuilder resSB = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '.') {
                if (i - 1 > 0 && str[i - 1] == '.' && !stack.isEmpty()) {
                    stack.pop();
                }
            } else if (str[i] != '/') {
                helpSB.append(str[i]);
            } else { // str[i] == '/'
                // 路径存在
                if (!helpSB.toString().equals("")) {
                    stack.push(helpSB.toString());
                    helpSB = new StringBuilder(); // 重新初始化 StringBuffer
                }
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) { // 头部添加
            resSB.insert(0, stack.pop());
            resSB.insert(0, '/');
        }
        return resSB.toString();
    }
}
