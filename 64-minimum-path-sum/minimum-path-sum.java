class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int row=0;row<dp.length;row++){
            for(int col=0;col<grid[0].length;col++){
                dp[row][col] = -1;
            }
        }
        return sum(grid,0,0,dp);
    }
    int sum(int[][] grid,int r,int c,int[][] dp){
        //here dp need to store min of the path
        if(r == grid.length-1 && c == grid[0].length-1){
            return grid[r][c];
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        //we can move either down or right
        //these are to initialize 
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        
        //each tym we go to a bax in a grid we add the cost of that box to the min we got , from the down or right

        if(r<grid.length-1){//are there any rown at down
            //means we go right
            down = sum(grid,r+1,c,dp);
        }
        if(c<grid[0].length-1){
            right=sum(grid,r,c+1,dp);
        }
        dp[r][c] = Math.min(down,right)+grid[r][c];
        return dp[r][c];
    }
}