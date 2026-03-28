package 剑指Offer;

public class Offer58I_翻转单词顺序 {

    public static void main(String[] args) {
        // System.out.println(reverseWords("  hello world!  "));
    }

    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("") || str[i].equals(" ")) continue;
            sb.append(str[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
