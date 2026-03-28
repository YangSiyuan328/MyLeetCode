package SimpleQuestion;

import java.util.HashSet;

public class Q824_山羊拉丁文 {

    static HashSet<Character> set = new HashSet<>();

    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }

    public String toGoatLatin(String sentence) {
        String[] stc = sentence.split(" ");
        StringBuilder tail = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (String s : stc) {
            tail.append("a");
            StringBuilder builder = new StringBuilder(s);
            if (!set.contains(builder.charAt(0))) {
                builder.append(builder.charAt(0));
                builder.deleteCharAt(0);
            }
            builder.append("ma").append(tail);
            res.append(builder).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
