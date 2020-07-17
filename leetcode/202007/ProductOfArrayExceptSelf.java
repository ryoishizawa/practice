// Date: 17/07/2020

// wrong answer
class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> leftProduct = new ArrayList<>();
        List<Integer> rightProduct = new ArrayList<>();
        
        int leftSum = 1;
        for (int i = 0; i < nums.length; i++) {
            leftSum = leftSum * nums[i];
            leftProduct.add(leftSum);
        }
        
        int rightSum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum = rightSum * nums[i];
            rightProduct.add(rightSum);
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct.get(i) * rightProduct.get(i);
        }
        return result;
    }
}
