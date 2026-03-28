package SimpleQuestion;

public class Q806_写字符串需要的行数 {


    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int row = 0;
        int width = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            while (count < 100 && i < chars.length) {
                count += widths[chars[i++] - 'a'];
            }
            if (count > 100) {
                i--;
            } else if (count == 100){
                i = i - 2;
            }
            width = count;
            row++;
        }
        return new int[]{row, width};
    }

}
