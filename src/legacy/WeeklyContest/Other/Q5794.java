package WeeklyContest.Other;

public class Q5794 {
    public static void main(String[] args) {
        Q5794 Q = new Q5794();
        System.out.println(Q.sumGame("5023"));
        System.out.println(Q.sumGame("25??"));
        System.out.println(Q.sumGame("?3295???"));
        System.out.println(Q.sumGame("9?"));
        // ?0?3105????1834??7382?997?3?????7?63 116?566?701?065?13?3??38?7?488?????9
        // 15 14
        System.out.println(Q.sumGame("?0?3105????1834??7382?997?3?????7?63116?566?701?065?13?3??38?7?488?????9"));
        // ?0?91172275656701?361205452?62??99?9??4478?796 7373994600735??4?079246???5827572?81087461?089
        // 18 10 8
        System.out.println(Q.sumGame("?0?91172275656701?361205452?62??99?9??4478?7967373994600735??4?079246???5827572?81087461?089"));
    }

    public boolean sumGame(String num) {
        int l = num.length();
        int qNum = getQNum(num);
        if (qNum == 0) {
            return halfSum(num) != 0;
        }
        int qNum1 = getQNum(num.substring(0, l / 2));
        int sum = halfSum(num);
        System.out.println(sum);
        System.out.println(qNum);
        System.out.println(qNum1);
        int numA = Math.abs(2 * qNum1 - qNum);
        if (numA % 2 == 1) {
            return true;
        } else {
            if (Math.abs(sum) < 9 * numA / 2) return true;
        }

        return false;
    }

    public static int halfSum(String num) {
        int l = num.length();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if (num.charAt(i) != '?') {
                if (i < l / 2) {
                    sum += Character.getNumericValue(num.charAt(i));
                } else {
                    sum -= Character.getNumericValue(num.charAt(i));
                }
            }
        }
        return sum;
    }

    public static int getQNum(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '?') {
                count++;
            }
        }
        return count;
    }

}
