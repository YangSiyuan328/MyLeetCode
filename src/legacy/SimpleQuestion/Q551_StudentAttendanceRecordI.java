package SimpleQuestion;

public class Q551_StudentAttendanceRecordI {

    public boolean checkRecord1(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA >= 2) return false;
            }
            if (s.charAt(i) == 'L') {
                if (i >= 2 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkRecord(String s) {
        int i = s.indexOf('A');
        return (i == -1 || s.lastIndexOf('A') == i) && !s.contains("LLL");
        //return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }

}
