import java.util.Scanner;

public class Triangle {


    public static void main(String[] args) {
        System.out.println("请输入行数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        drawTriangle(n);
        test(n);
    }

    static void drawTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                if (j > n - 1 - i && j < n + 1 + i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void test(int  num) {
        for (int i = num - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            int conut = 2 * (num - i) - 1;
            for (int k = conut; k > 0; k--) {
                System.out.print("*");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
