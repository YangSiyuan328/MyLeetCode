package SimpleQuestion;

import java.util.HashSet;
import java.util.Set;

public class Q804_唯一摩尔斯密码词 {

    public static final String[] morse = new String[]{".-", "-...",
            "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            set.add(stringToMorseRepresentations(word));
        }
        return set.size();
    }

    private String stringToMorseRepresentations(String word) {
        StringBuilder builder = new StringBuilder();
        for (char c : word.toCharArray()) {
            builder.append(morse[c - 'a']);
        }
        return builder.toString();
    }

}
