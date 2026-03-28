package SimpleQuestion;

public class Q482_密钥格式化 {


    public String licenseKeyFormatting(String s, int k) {
        char[] str = s.toCharArray();
        int l = str.length;
        for (char c : str) {
            if (c == '-') l--;
        }
        if (l==0) return "";
        if (l % k == 0) {
            l += l / k - 1;
        } else {
            l += l / k;
        }
        char[] res = new char[l];
        for (int i = l - 1, j = str.length - 1; i >= 0; ) {
            for (int m = 0; m < k && i >= 0; m++) {
                while (str[j] == '-') j--;
                res[i--] = str[j];
                j--;
            }
            if (i < 0) break;
            res[i--] = '-';
        }
        return new String(res).toUpperCase();
    }

    // 倒着插
    public String licenseKeyFormatting1(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c != '-') {
                sb.append(c);
            }
        }
        int index = sb.length() - k;
        while (index >= 1) {
            sb.insert(index, '-');
            index -= k;
        }
        return sb.toString().toUpperCase();
    }

}
