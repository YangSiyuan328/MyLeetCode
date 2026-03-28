package DifficultQuestion;

public class Q517_超级洗衣机 {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) return 0;
        int size = machines.length;
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % size != 0) return -1;
        int avg = sum / size;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < machines.length; i++) {
            int leftMove = leftSum - i * avg;
            int rightMove = (sum - leftSum - machines[i]) - (size - i - 1) * avg;
            if (leftMove < 0 && rightMove < 0) {
                ans = Math.max(ans, -leftMove - rightMove);
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftMove), Math.abs(rightMove)));
            }
            leftSum += machines[i];
        }
        return ans;
    }
}
