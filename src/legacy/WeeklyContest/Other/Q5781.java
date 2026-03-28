package WeeklyContest.Other;

public class Q5781 {
    public static void main(String[] args) {
        Q5781 Q = new Q5781();
        System.out.println(Q.removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(Q.removeOccurrences("axxxxyyyyb", "xy"));
    }

    public String removeOccurrences(String s, String part) {
        while (s.split(part).length - 1 != 0) {
            s = s.replace(part, "");
        }
        s = s.replace(part, "");
        return s;
    }
}
