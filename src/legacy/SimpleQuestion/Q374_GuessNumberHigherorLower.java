package SimpleQuestion;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
题目的描述有歧义！
-1 : 我的数字比较小 1 : 我的数字比较大 0 : 恭喜！你猜对了！
这里的「我的数字」 指的你要猜的数字，不是你输入的数字
 */
class Q374_GuessNumberHigherorLower {
    static final int n = 823161944;

    public static void main(String[] args) {
        Q374_GuessNumberHigherorLower Q = new Q374_GuessNumberHigherorLower();
        System.out.println(Q.guessNumber(921239930));
    }

    public int guessNumber(int n) {
        int low = 1;
        int hight = n;
        int mid = low + (hight - low) / 2;
        while (true) {
            if (guess(mid) > 0) {
                low = mid + 1;
                mid = low + (hight - low) / 2;
            } else if (guess(mid) < 0) {
                hight = mid - 1;
                mid = low + (hight - low) / 2;
            }else {
                return mid;
            }
        }

    }

    int guess(int num) {
        if (num < n) {
            return -1;
        } else if (num > n) {
            return 1;
        } else {
            return 0;
        }
    }
}

