package org.techinterviewhandbook.grind75;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell;
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy){
                buy = prices[i];
            }
            sell = prices[i];
            maxProfit = Math.max(maxProfit, sell-buy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BuyAndSellStock().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new BuyAndSellStock().maxProfit(new int[]{7,6,4,3,1}));
    }
}
