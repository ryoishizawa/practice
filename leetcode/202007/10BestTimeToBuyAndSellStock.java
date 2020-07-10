// accepted, but not good because time complexity is O(n^2)
class Solution1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];
            for (int j = i; j < prices.length; j++) {
                int sellPrice = prices[j];
                int profit = sellPrice - buyPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
