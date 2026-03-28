package MiddleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-13  14:48
 * @Description: TODO
 * @Version: 1.0
 */
public class Q11_盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("maxArea(height) = " + maxArea(height));
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxArea = (right - left) * Math.min(height[right], height[left]);
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            if (height[left] >= height[right]) {
                right--;
                while (height[right] < minHeight) {
                    right--;
                }
            } else {
                left++;
                while (height[left] < minHeight) {
                    left++;
                }
            }
            maxArea = Math.max((right - left) * Math.min(height[right], height[left]), maxArea);
        }
        return maxArea;
    }

}
