package 真题;

import java.util.Arrays;
import java.util.Scanner;

/*
京东一面：建造规划
题目描述：
小明在玩教建造类的游戏。 他需要为一段末开荒的地段设计路段的规划，以便起重机通过。
游戏里的每段路都有能承重的级别，小明现在希望尽可能让能承重更大的起重机通过，这样他就可以比较快地完成建造了。
游戏规定小明只能选一种起重机机型，小明想知道这个起重机最高的承重级别应该是多少，使得在该承重条件下，
起重机可以从任何一个点出发去向任何一个点而不会损坏道路(损坏道路指的是路段上行驶了超过承重能力的起重机)。
为了方便，我们将需要规划的建造点抽象成N个点，有M条边将他们相连。

输入描述
第一行是两个空格隔开的正整数n,m。n代表点数，我们将点从1到n编号，m指边的数量
接下来m行，每行3个空格隔开的正整数u,v,p,代表节点u和节点v之间有一条承重能力为p的路径。

输入样例：
3 3
1 2 3
1 3 4
2 3 5

输出样例
4
 */
class 建造规划_并查集 {

    public static void main(String[] args) {
        System.out.println(getMin());
    }

    static int[] p; // 并查集

    public static int getMin(){ // 程序入口
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] connections = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                connections[i][j] = sc.nextInt();
            }
        }
        return getMaxWeight(n, connections);
    }

    public static int getMaxWeight(int n, int[][] connections) {
        p  = new int[n + 1];
        for(int i = 0; i < p.length; i ++) p[i] = i; // 初始化并查集
        Arrays.sort(connections, (e1, e2) -> e2[2] - e1[2]); // 按权值从小到大排序所有的边
        int min = Integer.MAX_VALUE;
        for (int[] connection : connections) {
            int x = find(connection[0]), y = find(connection[1]), w = connection[2];
            if (x != y) { // 合并两个集合
                p[x] = y;
                min = Math.min(min, w);
            }
        }
        return min;
    }

    public static int find(int x){ // 返回x的祖宗结点
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
