package SimpleQuestion;

class Q14_LongestCommonPrefix {
    public static void main(String[] args) {
        Q14_LongestCommonPrefix Q = new Q14_LongestCommonPrefix();
        System.out.println(Q.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    // JalonJia 大佬解法
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) return "";
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }


    /*
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        // 寻找 长度最小的字符串 l
        String l = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < l.length()) {
                //l = strs[i].length();
                l = strs[i];
            }
        }
        //循环 最短字符串l 的长度次 每次判断每个字符串的第 i 位是否相同
        for (int i = 0; i < l.length(); i++) {
            // 记录第一个字符串的第 i 位，当第一个字符串的前l.length()位
            char c = strs[0].charAt(i);
            // 用来遍历每个字符串
            for (String str : strs) {
                // 出现不一样的字母时 输出前 i-1 位
                if (c != str.charAt(i)) {
                    String s = "";
                    // 记录最长公共前缀（前 i-1 位）
                    for (int k = 0; k < i; k++) {
                        s += String.valueOf(strs[0].charAt(k));
                    }
                    return s;
                }
            }
        }
        // 如果每位都相同，则返回 长度最小的字符串l
        return l;
    }*/
}
