package 剑指Offer;

public class Offer65_不用加减乘除做加法 {

    public int add1(int a, int b) {
        int tem;
        while (b != 0) {
            tem = (a & b) << 1;
            a = a ^ b;
            b = tem;
        }
        return a;
    }

    public int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }


}
