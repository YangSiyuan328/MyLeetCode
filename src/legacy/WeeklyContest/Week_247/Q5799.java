package WeeklyContest.Week_247;

public class Q5799 {
    public static void main(String[] args) {
        Q5799 Q = new Q5799();
        System.out.println(Q.wonderfulSubstrings("aba"));
        System.out.println(Q.wonderfulSubstrings("aabb"));
        System.out.println(Q.wonderfulSubstrings("he"));
        System.out.println(Q.wonderfulSubstrings("fiabhedce"));
    }

    public long wonderfulSubstrings(String word) {
        int l = word.length();
        if (l <= 2) return l;
        String[][] str = new String[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                str[i][j] = word.substring(i, j+1);
            }
        }
        int sum = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {

            }
        }
        return sum;
    }
    
}
