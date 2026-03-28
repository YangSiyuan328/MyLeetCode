package MiddleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-27  12:41
 * @Description: TODO
 * @Version: 1.0
 */
public class Q738_单调递增的数字 {

    public int monotoneIncreasingDigits(int n) {
        int num = 0;
        int res = 0;
        int count = 0;
        while (n > 0) {
            num = n % 10;
            n /= 10;
            count += 1;
            res += count * num;
        }
        return -1;
    }

}
