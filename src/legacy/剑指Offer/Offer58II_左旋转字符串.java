package 剑指Offer;

public class Offer58II_左旋转字符串 {

    public static void main(String[] args) {
        Offer58II_左旋转字符串 o = new Offer58II_左旋转字符串();
        System.out.println(o.reverseLeftWords("abcdefg", 2));
        System.out.println(o.reverseLeftWords1("abcdefg", 2));
        System.out.println(o.reverseLeftWords("lrloseumgh", 6));
        System.out.println(o.reverseLeftWords1("lrloseumgh", 6));
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }
}
