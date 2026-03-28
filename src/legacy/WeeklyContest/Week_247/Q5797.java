package WeeklyContest.Week_247;

class Q5797 {
    public static void main(String[] args) {
        Q5797 Q = new Q5797();
        System.out.println(Q.maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(Q.maxProductDifference(new int[]{4,2,5,9,7,4,8}));
        System.out.println(Q.maxProductDifference(new int[]{1,6,7,5,2,4,10,6,4}));
    }

    public int maxProductDifference(int[] nums) {

        int max1 = nums[0]>>1;
        int max2 = nums[0]>>1;
        int min1 = nums[0]<<1;
        int min2 = nums[0]<<1;
        for (int value : nums) {
            if (value > max1) {
                max1 = value;
            }
            if (value < min1) {
                min1 = value;
            }
        }
        for (int value : nums) {
            if (value < max1 && value > max2) {
                max2 = value;
            }
            if (value > min1 && value < min2) {
                min2 = value;
            }
        }
        return max1*max2-min1*min2;
    }
    /*public int maxProductDifference(int[] nums) {
        mergeSort1(nums);
        int l = nums.length;
        return nums[l-1]*nums[l-2]-nums[1]*nums[0];
    }
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    public static void process(int[] arr, int L, int R) {
        if (L == R) { // base case
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }*/

}
