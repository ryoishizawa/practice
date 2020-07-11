// Date: 11 Jul 2020

// Accepted. (Brute force, slow)
class Solution {
    public int maxArea(int[] height) {
        int maxDimension = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int currHeight = height[i] < height [j] ? height[i] : height[j];
                int currWidth = j - i;
                int dimension = currHeight * currWidth;
                if (maxDimension < dimension) {
                    maxDimension = dimension;
                }
            }
        }
        return maxDimension;
    }
}
