package MiddleQuestion;

import java.util.Stack;

public class Q71_简化路径 {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        char[] chars = (path + '/').toCharArray();
        StringBuilder sb = new StringBuilder("/");
        StringBuilder cur = new StringBuilder("");
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                if (cur.length() != 0) {
                    if ("..".equals(cur.toString())) {
                        int l = sb.length();
                        do {
                            if (l == 1) break;
                            sb.deleteCharAt(--l);
                        } while (l > 1 && '/' != sb.charAt(l - 1));
                    } else if (cur.length() > 0 && !".".equals(cur.toString())) {
                        sb.append(cur.toString());
                        sb.append('/');
                    }
                    cur = new StringBuilder();
                }
            } else {
                cur.append(chars[i]);
            }
        }
        int l = sb.length();
        if (l > 1 && '/' == sb.charAt(l - 1)) sb.deleteCharAt(l - 1);
        return sb.toString();
    }
}
