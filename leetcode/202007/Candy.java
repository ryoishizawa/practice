// LeetCode 135
// solved by myself after getting hint from the title 'Approach 2: Using two arrays'
class Solution1 {
    public int candy(int[] ratings) {
        // calculate candy from left to right
        int[] candies1 = new int[ratings.length];
        // calculate candy from right to left
        int[] candies2 = new int[ratings.length];
        // left to right
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                candies1[i] = 1;
            } else {
                // compare ratings[i] and ratings[i-1]
                if (ratings[i] > ratings[i-1]) {
                    candies1[i] = candies1[i-1] + 1;
                } else {
                    candies1[i] = 1;
                }
            }
        }
        // right to left
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i == ratings.length - 1) {
                candies2[i] = 1;
            } else {
                if (ratings[i] > ratings[i+1]) {
                    candies2[i] = candies2[i+1] + 1;
                } else {
                    candies2[i] = 1;
                }
            }
        }
        // compare and get max value
        int[] maxCandies = new int[ratings.length];
        for (int i = 0; i < candies1.length; i++) {
            maxCandies[i] = Math.max(candies1[i], candies2[i]);
        }
        // calculate and return value
        int total = 0;
        for (int i = 0; i < maxCandies.length; i++) {
            total = total + maxCandies[i];
        }
        return total;
    }
}
