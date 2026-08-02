class Solution {
    public int maxProfit(int[] prices) {
        //we buy stock on 1st day and then subtract with evry other day , we check what is max and return
        //but time complexity is O(n^2)
       /* int max = 0;
        for(int i = 0;i<prices.length-1;i++){
            for(int j = i+1;j<prices.length;j++){
                //we buy on ith and sell o jth
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
        */
        int min = prices[0];
        int profit = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i] < min){
                min = prices[i];//finds the min cost to buy
            }else{
                profit = Math.max(profit,prices[i]-min);
            }
        }
        return profit;
    }
}