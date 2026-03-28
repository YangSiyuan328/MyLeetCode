package 剑指Offer;

public class Offer11_旋转数组的最小数字 {

    public static void main(String[] args) {
        Offer11_旋转数组的最小数字 o = new Offer11_旋转数组的最小数字();
        System.out.println(o.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(o.minArray(new int[]{2, 3, 4, 5, 1}));
        System.out.println(o.minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(o.minArray(new int[]{1, 3, 5}));
        System.out.println(o.minArray(new int[]{3, 1, 3}));
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}
