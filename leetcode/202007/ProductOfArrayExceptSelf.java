// Date: 17/07/2020
// Accepted after reading the article in LeetCode.
class Solution {
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
