class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int localMax = 0;
        int buy = 0;
        for (int i = 1; i < prices.length; ++i) {
            int profit = prices[i] - prices[buy];
            if (profit > localMax) {
                localMax = profit;
            } else {
                buy = i;
                max += localMax;
                localMax = 0;
            }
        }
        return max + localMax;
    }
}