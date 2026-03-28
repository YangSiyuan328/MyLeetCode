package MiddleQuestion;

public class Q165_比较版本号 {

    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");
        int minL = Math.min(a1.length, a2.length);
        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.parseInt(a1[n]) : 0);
            int j = (n < a2.length ? Integer.parseInt(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }


}
