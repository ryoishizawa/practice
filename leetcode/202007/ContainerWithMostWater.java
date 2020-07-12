// Date: 11 Jul 2020

// Accepted. (Brute force, slow)
class Solution1 {
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

// Better solution from leetcode, using Two Pointer approach.
class Solution2 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
