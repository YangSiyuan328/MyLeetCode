package SimpleQuestion;

public class Q1629_按键持续时间最长的键 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        int index = 0;
        for (int i = releaseTimes.length - 1; i > 0; i--) {
            releaseTimes[i] -= releaseTimes[i - 1];
            if (releaseTimes[i] > max) {
                max = releaseTimes[i];
                index = i;
            } else if (releaseTimes[i] == max) {
                index = keysPressed.charAt(index) - keysPressed.charAt(i) > 0 ? keysPressed.charAt(index) : keysPressed.charAt(i);
            }
        }
        return keysPressed.charAt(index);
    }
}
