import java.util.Map;
import java.util.Stack;

public class Code02_randomAccess {
    // for test
    public static void main(String[] args) {
        int[] A1 = new int[]{1, 2, 3, 4};
        int[] w1 = new int[]{2, 3, 1, 4};
        int[] A2 = new int[]{1, 1, 3};
        int[] w2 = new int[]{2, 5, 3};
        int[] A3 = new int[]{1, 2, -1};
        int[] w3 = new int[]{0, 1, 4};
        getAllProbability(A1, w1);
        getAllProbability(A2, w2);
        getAllProbability(A3, w3);
    }

    // for test
    private static void getAllProbability(int[] A, int[] w) {
        int ALength = A.length;
        int[] countNum = new int[ALength]; // 统计A中每一位出现的次数 也就是 频数
        double[] possibility = new double[ALength]; // 对应存放A每一位出现的可能性
        int curNum = 0;
        int total = 1000000; // 测试总数
        for (int i = 0; i < total; i++) {
            curNum = randomAccess(A, w);
            for (int j = 0; j < ALength; j++) {
                // 如果A的某两个元素出现多次会计算，但是总概率不影响
                // 可以用Map<Integer,Double>存放进行优化
                if (A[j] == curNum) countNum[j]++;
            }
        }
        for (int i = 0; i < ALength; i++) {
            // 测试次数足够大时，概率 约等于 频率 = 频数 / 总数；
            possibility[i] = ((double) countNum[i]) / total;
        }
        for (int i = 0; i < ALength; i++) {
            System.out.println(A[i] + "出现的概率为：" + possibility[i]);
        }
    }


    private static int randomAccess(int[] A, int[] w) {
        if (A == null || w == null || A.length == 0 || w.length == 0) return Integer.MIN_VALUE;
        int wLength = w.length;
        int[] pre = new int[wLength];
        pre[0] = w[0];
        for (int i = 1; i < wLength; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        int myRandom = (int) (Math.random() * pre[wLength - 1] + 1);
        for (int i = 0; i < pre.length; i++) {
            if (myRandom <= pre[i]) {
                return A[i];
            }
        }
        return Integer.MIN_VALUE;
    }

}
