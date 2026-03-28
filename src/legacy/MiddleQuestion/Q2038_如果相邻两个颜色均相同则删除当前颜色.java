package MiddleQuestion;

public class Q2038_如果相邻两个颜色均相同则删除当前颜色 {

    /**
     * 统计连续出现AB的次数，比较即可
     * @param colors
     * @return
     */
    public boolean winnerOfGame(String colors) {
        int countA = 0;
        int countB = 0;
        char[] chars = colors.toCharArray();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i - 1] == chars[i] && chars[i + 1] == chars[i]){
                if (chars[i]=='A'){
                    countA++;
                } else {
                    countB++;
                }
            }
        }
        return countA != 0 && countA > countB;
    }


}
