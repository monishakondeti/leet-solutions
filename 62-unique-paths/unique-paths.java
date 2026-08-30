class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        //fills the dp with -1 means we still didnt calculated the position
        for(int row=0;row<dp.length;row++){
            for(int col = 0;col<dp[row].length;col++){
                dp[row][col] =-1;
            }
        }
        return count(m,n,dp);
    }
    int count(int r,int c,int[][] dp){
        //we can either go down means r-- or can go right means c-- at first 

        //base case
        if(r == 1 || c== 1){
            return 1;
        }

        //checking we already calculated at that position or not
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int down = count(r-1,c,dp);
        int right = count(r,c-1,dp);
        dp[r][c] = down+right;
        return dp[r][c];
    }
}