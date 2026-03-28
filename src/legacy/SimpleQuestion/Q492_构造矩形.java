package SimpleQuestion;

import java.util.Arrays;

public class Q492_构造矩形 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(2)));
        System.out.println(Arrays.toString(constructRectangle(1)));
    }

    public static int[] constructRectangle(int area) {
        int W = (int) Math.pow(area, 0.5);
        if (W * W == area) return new int[]{W, W};
        while (W > 0) {
            if (area % W == 0) {
                return new int[]{area / W, W};
            }
            W--;
        }
        return null;
    }

}
