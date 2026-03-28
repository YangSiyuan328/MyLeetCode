package MiddleQuestion;

public class Q223_矩形面积 {


    public int computeArea(int aL, int aD, int aR, int aU, int bL, int bD, int bR, int bU) {
        int areaAnd = (aU - aD) * (aR - aL) + (bU - bD) * (bR - bL);
        if (aD >= bU || aR <= bL || aL >= bR || aU <= bD) {
            return areaAnd;
        }
        int dx = Math.min(aR, bR) - Math.max(aL, bL);
        int dy = Math.min(aU, bU) - Math.max(aD, bD);
        int overlapArea = dx * dy;
        return areaAnd - overlapArea;
    }

}
