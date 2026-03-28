package SimpleQuestion;

public class Q69_Sqrt_X {
    public static void main(String[] args) {
        Q69_Sqrt_X Q = new Q69_Sqrt_X();
        System.out.println(Q.mySqrt(3));
        System.out.println(Q.mySqrt(4));
        System.out.println(Q.mySqrt(8));
    }

    public int mySqrt1(int x) {
        return (int) Math.pow(x, 0.5);
    }

    public int mySqrt(int x) {
        double d = x / 2;
        while (Math.abs(d * d - x) > 0.5) {
            d = (d + x / d) / 2;
        }
        return (int) d;
    }

    /*public double mySqrt(int x) {
        int k = 0;
        double d = x;
        while (Math.abs(d * d - x) > 0.5) {
            d = (d + x / d) / 2;
        }
        return d;
    }*/
}
