package 剑指Offer;

public class Offer05_替换空格 {

    public static void main(String[] args) {
        Offer05_替换空格 O = new Offer05_替换空格();
        System.out.println(O.replaceSpace("We are happy."));
    }

    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
