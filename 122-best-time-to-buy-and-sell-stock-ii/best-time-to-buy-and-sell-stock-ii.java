class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i < dp.length; i++){
           Arrays.fill(dp[i], -1);
        }
        return profit(prices,0,false,dp);
    }
    int profit(int[] prices,int day,boolean holding,int[][] dp){
        //if we are not holding a stock we have two option either to buy or to skip
        //if we hold a stock we can either sell it or not
        if(day == prices.length){
            return 0;
        }
        int state;
        if(holding){
            state = 1;
        }else{
            state =0;
        }
        if(dp[day][state] != -1){
           return dp[day][state];
        }    
        if(!holding){
            //we can buy or skip
            //if we buy
            int buy = -prices[day]+profit(prices,day+1,true,dp);
            int skip = profit(prices,day+1,false,dp);
            dp[day][state] = Math.max(buy, skip);
            return dp[day][state];
        }else{
            //we can sell or skip
            int sell = prices[day]+profit(prices,day+1,false,dp);
            int skip = profit(prices,day+1,true,dp);
            dp[day][state] = Math.max(sell, skip);
            return dp[day][state];
        }

    }
}