package WeeklyContest.Week_247;

public class Q5798 {
    public static void main(String[] args) {

    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ret = new int[m][n];
        boolean R = true;
        boolean D = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i+j+k-n+1<=(n-1)){
                    if (j + k < n) {
                        ret[i][j] = grid[i][j + k];
                    }else if(j + k >= n){
                        ret[i][j] = grid[i+j+k-n+1][n-1];
                    }
                }else {
                    if (j + k < n) {
                        ret[i][j] = grid[i][j + k];
                    }else if(j + k >= n){
                        ret[i][j] = grid[i+j+k-n+1][n-1];
                    }
                }

            }
        }
        return null;
    }
}
