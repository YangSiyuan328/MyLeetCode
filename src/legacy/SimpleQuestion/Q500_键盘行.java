package SimpleQuestion;

import java.util.ArrayList;

public class Q500_键盘行 {

    public String[] findWords(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            int n1 = 0, n2 = 0, n3 = 0, l = word.length();
            for (int i = 0; i < l; i++) {
                if (s1.contains(word.charAt(i) + "")) n1++;
                else if (s2.contains(word.charAt(i) + "")) n2++;
                else n3++;
            }
            if (n1 == l || n2 == l || n3 == l) list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }

}
