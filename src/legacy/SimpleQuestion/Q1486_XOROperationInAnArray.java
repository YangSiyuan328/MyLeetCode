package SimpleQuestion;

/**
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * 示例 1：
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * <p>
 * 示例 2：
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * <p>
 * 示例 3：
 * 输入：n = 1, start = 7
 * 输出：7
 * <p>
 * 示例 4：
 * 输入：n = 10, start = 5
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q1486_XOROperationInAnArray {
    public static void main(String[] args) {
        Q1486_XOROperationInAnArray Q = new Q1486_XOROperationInAnArray();
        System.out.println(Q.xorOperation(5, 0));
        System.out.println(Q.xorOperation(4, 3));
        System.out.println(Q.xorOperation(1, 7));
        System.out.println(Q.xorOperation(10, 5));
    }
/*
    // 循环
    public int xorOperation(int n, int start) {
        int xor = start;
        for (int i = 1; i < n; i++) {
            xor ^= start + 2 * i;
        }
        return xor;
    }
    */
/*

    //递归
    public int xorOperation(int n, int start) {
        return xorOperation(start, n - 1, start);
    }

    public int xorOperation(int xor, int n, int start) {
        return n == 0 ? xor : xorOperation(xor ^ (start + 2), n - 1, start + 2);
    }
*/

    public int xorSum(int n) {
        if (n < 0) return 0;
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else if (n % 4 == 3) return 0;
        else return n;
    }

    public int xorOperation(int n, int start) {
        int s = start / 2, e = s + n - 1, front = xorSum(e) ^ xorSum(s-1);
        return (front << 1) + ((start & 1) & (n & 1));
    }
}


