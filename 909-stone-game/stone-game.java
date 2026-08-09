class Solution {
    public boolean stoneGame(int[] piles) {
      //initially alice starts to play and check the start and end piles and picks either of them , and it should also checks to give least num to bob, so alice also checks the pile it wanted to picks beside pile also, and picks which pile has least count
        int n = piles.length;
        int[][] dp = new int[n][n];
        //we fill the dp with all min values 
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int difference = game(piles,0,n-1,dp);
        return difference>0; //we only win when we have more stones
    }
    int game(int[] piles,int start,int end,int[][] dp){
        if(start == end){
            return piles[start];
        }
        if(dp[start][end] != Integer.MIN_VALUE){
            //we do this to avoid the repetations
            return dp[start][end];
        }
        //oponenet may take start+1 or end-1 depending on what we pick
        //if we take start
        int takeStart = piles[start] - game(piles,start+1,end,dp);
        //if we get +takeStart and +takeEnd then only alice wins
        int takeEnd = piles[end] - game(piles,start,end-1,dp);
        //we return the max of our stones also store the dp 
        dp[start][end] = Math.max(takeStart, takeEnd);
        return dp[start][end];
    }
}