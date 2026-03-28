package SimpleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-12  17:37
 * @Description: TODO
 * @Version: 1.0
 */
public class Q202_快乐数 {

    public boolean isHappy(int n) {
        int m = n;
        int sum = 0;
        int cnt = 0;
        while (m != 1) {
            while (m > 0) {
                // 个位数
                int x = m % 10;
                // 余下的数
                m = m / 10;
                // 每次加 个位数的平方
                sum += x * x;
            }
            if (cnt == 10) {
                return false;
            }
            cnt ++;
            m = sum;
            sum = 0;
        }
        return true;
    }

}
