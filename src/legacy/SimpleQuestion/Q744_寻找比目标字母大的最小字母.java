package SimpleQuestion;

public class Q744_寻找比目标字母大的最小字母 {

    public static void main(String[] args) {
        Q744_寻找比目标字母大的最小字母 Q = new Q744_寻找比目标字母大的最小字母();
        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char target = 'x';
        System.out.println(Q.nextGreatestLetter(letters, target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        char cur = 0;
        int path = 128;
        for (char letter : letters) {
            if (letter > target && letter - target < path) {
                path = letter - target;
                cur = letter;
            } else if (letter < target && letter - target + 26 < path) {
                path = letter - target + 26;
                cur = letter;
            }
        }
        return cur;
    }

}
