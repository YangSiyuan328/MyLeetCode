package SimpleQuestion;

public class Q1570_两个稀疏向量的点积 {

    class SparseVector {

        int[] vector;

        SparseVector(int[] nums) {
            vector = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int[] v1 = this.vector;
            int[] v2 = vec.vector;
            int res = 0;
            for (int i = 0; i < this.vector.length; i++) {
                if (v1[i] != 0 && v2[i] != 0) {
                    res += v1[i] * v2[i];
                }
            }
            return res;
        }
    }

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

}


