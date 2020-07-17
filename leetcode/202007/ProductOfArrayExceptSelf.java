// Date: 17/07/2020
// Accepted after reading the article in LeetCode.
class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        
        int leftSum = 1;
        for (int i = 0; i < nums.length; i++) {
            leftSum = leftSum * nums[i];
            leftProduct[i] = leftSum;
        }
        
        int rightSum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum = rightSum * nums[i];
            rightProduct[i] = rightSum;
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = rightProduct[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = leftProduct[i - 1];
            } else {
                result[i] = leftProduct[i - 1] * rightProduct[i + 1];
            }
        }
        return result;
    }
}


// Solved with O(1) space complexity.
// But this is a bit slower even though time complexity is the same.
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int leftSum = 1;
        for (int i = 0; i < nums.length; i++) {
            leftSum = leftSum * nums[i];
            result[i] = leftSum;
        }
        
        int rightSum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                result[i] = rightSum;
                continue;
            }
            if (i == nums.length - 1) { 
                result[i] = result[i - 1];
            } else {
                result[i] = result[i - 1] * rightSum;
            }
            rightSum = rightSum * nums[i];
        }
        
        return result;
    }
}
