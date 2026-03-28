package SimpleQuestion;

public class Q292_Nim游戏 {
    public boolean canWinNim(int n) {
        // return n % 4 > 0;
        return !((n & 3) == 0);
    }
}
