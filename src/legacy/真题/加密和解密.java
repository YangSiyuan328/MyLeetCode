package 真题;

import java.util.Scanner;

/*
美团一面：神秘代码
题目描述:
小团在网上冲浪的时候发现了些神秘代码。 经过一段时间的研究， 小团发现了这些代码的加密规则。
对于个长度为n的字符串s，其对应的加密字符串t的第一个字符是s中的第n/2个字符(向上取整)，
而t中第二到第n个字符则刚好对应s删去第n/2个字符(向上取整)后所得字符串的加密字符串。
这个规则也可以用如下流程描述:
将t初始化为一个空串，不断地从s中取出第n/2个字符(向上取整)并将其拼到t的后面，当s为空时t即是所求的加密字符串。
为了加快破解流程，小团希望你能设计个命令行工具来帮他进行加密和解密的操作。

输入描述
第一行有两个正整数n,t(1<=n<= 100000,1<=t<=2),代表字符串的长度以及操作(1为加密，2为解密)
第二行有一个长度为n的字符串s,仅由小写英文字母组成，代表需要进行操作的字符串。
输出描述
输出一个长度为n的字符串，代表操作的结果。

样例输入
6 2
hahaha
6 1
hhhaaa
样例输出
hhhaaa
hahaha
 */
class 加密和解密 {

    private static void main(String[] args) {
        System.out.println(test());
    }

    private static String test() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        String str = sc.next();
        return t == 1 ? encryption(n, str) : decrypt(n, str);
    }

    // 加密
    public static String encryption(int n, String str) {
        StringBuilder builder = new StringBuilder(str);
        StringBuilder res = new StringBuilder();
        while (builder.length() > 0) {
            res.append(builder.charAt((builder.length() + 1) / 2 - 1));
            builder.deleteCharAt((builder.length() + 1) / 2 - 1);
        }
        return res.toString();
    }

    //解密
    public static String decrypt(int n, String str) {
        StringBuilder builder = new StringBuilder(str);
        StringBuilder res = new StringBuilder();
        while (builder.length() > 0) {
            res.insert(res.length() / 2, builder.charAt(builder.length() - 1));// 在指定的位置10，插入指定的字符串
            builder.deleteCharAt(builder.length() - 1);
        }
        return res.toString();
    }
}
