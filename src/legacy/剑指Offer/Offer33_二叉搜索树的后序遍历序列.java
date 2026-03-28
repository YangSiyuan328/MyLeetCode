package 剑指Offer;

public class Offer33_二叉搜索树的后序遍历序列 {

    public boolean verifyPostorder(int[] postorder) {

        return false;
    }

    private static class Info {
        int LMax;
        int RMin;
        boolean isSBT;

        public Info(int LMax, int RMin, boolean isSBT) {
            this.LMax = LMax;
            this.RMin = RMin;
            this.isSBT = isSBT;
        }
    }

    private static Info post(int[] postorder, int i) {
        if (i == postorder.length) return new Info(0, 0, true);

        Info l = post(postorder, i + 1);
        Info r = post(postorder, i + 1);

        return null;
    }

}
