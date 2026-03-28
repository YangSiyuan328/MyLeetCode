package 剑指OfferII;

public class OfferII069_山峰数组的顶部 {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr[0] > arr[1]) return 0;
        int l = arr.length;
        if (arr[l - 1] > arr[l - 2]) return l - 1;
        int L = 1;
        int R = l - 2;
        int M = 0;
        while (L <= R) {
            M = (L + R) >> 1;
            if (arr[M] > arr[M - 1] && arr[M] > arr[M + 1]) {
                return M;
            } else if (arr[M] < arr[M - 1]) {
                R = M - 1;
            } else if (arr[M] < arr[M + 1]) {
                L = M + 1;
            }
        }
        return M;
    }

}
