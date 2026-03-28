package SimpleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-25  09:38
 * @Description: TODO
 * @Version: 1.0
 */
public class Q860_柠檬水找零 {

    public static void main(String[] args) {
        Q860_柠檬水找零 Q = new Q860_柠檬水找零();
        System.out.println("Q.lemonadeChange({5,5,5,10,20}) = " + Q.lemonadeChange(new int[]{5, 5, 5, 20}));
    }

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) five++;
            else if (b == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                five--;
                ten--;
            } else five -= 3;
            if (five<0) return false;
        }
        return true;
    }

}





















