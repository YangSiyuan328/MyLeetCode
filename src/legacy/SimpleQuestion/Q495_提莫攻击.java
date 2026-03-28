package SimpleQuestion;

public class Q495_提莫攻击 {
    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        int endTime = -1;
        int res = 0;
        int l = timeSeries.length;
        for (int i = 0; i < l; i++) {
            int timeStart = timeSeries[i];
            if (endTime < timeStart) {
                res += duration;
            } else {
                res += timeSeries[i] - timeSeries[i - 1];
            }
            endTime = timeStart + duration - 1;
        }
        return res;
    }

    // 参考答案
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int prev = timeSeries[0];
        for(int i=1;i<timeSeries.length;i++){
            int cur = timeSeries[i];
            if(prev + duration-1 < cur){
                ans += duration;
            }else{
                ans += (cur - prev);
            }
            prev = cur;
        }
        ans += duration;
        return ans;
    }
}
