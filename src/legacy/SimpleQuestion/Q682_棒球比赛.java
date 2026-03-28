package SimpleQuestion;

public class Q682_棒球比赛 {

    public static void main(String[] args) {
        Q682_棒球比赛 Q = new Q682_棒球比赛();
        System.out.println(Q.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    public int calPoints(String[] ops) {
        int[] score = new int[ops.length];
        int count = 0;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            switch (op) {
                case "+":
                    score[i] = getOneOrTwo(score, i, 2);
                    break;
                case "D":
                    score[i] = getOneOrTwo(score, i, 1) << 1;
                    break;
                case "C":
                    score[getOneOrTwo(score, i, 0)] = 0;
                    break;
                default:
                    score[i] = Integer.parseInt(op);
            }
        }
        for (int j : score) {
            count += j;
        }
        return count;
    }

    private int getOneOrTwo(int[] score, int k, int num) {
        if (num == 0) {
            while (k-- > 0) {
                if (score[k] != 0) return k;
            }
        }
        if (num == 1) {
            while (k-- > 0) {
                if (score[k] != 0) return score[k];
            }
        }
        if (num == 2) {
            int sum = 0;
            while (k-- > 0 && num > 0) {
                if (score[k] != 0) {
                    sum += score[k];
                    num--;
                }
            }
            return sum;
        }
        return 0;
    }

}
